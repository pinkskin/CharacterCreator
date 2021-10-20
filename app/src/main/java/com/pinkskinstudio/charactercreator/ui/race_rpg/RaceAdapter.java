package com.pinkskinstudio.charactercreator.ui.race_rpg;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pinkskinstudio.charactercreator.CharacterCreatorViewModel;
import com.pinkskinstudio.charactercreator.R;
import com.pinkskinstudio.charactercreator.entities.CHARACTER_RACE;
import com.pinkskinstudio.charactercreator.ui.race_rpg.RaceFragment.OnRaceItemInteractionListener;
import com.pinkskinstudio.charactercreator.logic.Randomizer;

import java.util.List;

public class RaceAdapter extends RecyclerView.Adapter<RaceAdapter.ViewHolder> {

    private List<CHARACTER_RACE> allRaces;
    private String chosenRace;
    private final OnRaceItemInteractionListener mListener;
    private boolean isRandomizeSelection = false;
    private int randomRacePositionInt;
    private CharacterCreatorViewModel characterCreatorViewModel;
    private LinearLayoutManager linearLayoutManager;

    // Constructor
    public RaceAdapter(OnRaceItemInteractionListener listener, ViewModelStoreOwner activity, RecyclerView recyclerView) {
        mListener = listener;
        //this.application = application;
        this.characterCreatorViewModel = new ViewModelProvider(activity)
                .get(CharacterCreatorViewModel.class);
        this.linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView choiceTextView;

        private ViewHolder(View view) {
            super(view);
            choiceTextView = (TextView) view.findViewById(R.id.choiceTextView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.choice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (this.allRaces != null) {
            CHARACTER_RACE currentRace = allRaces.get(position);
            holder.choiceTextView.setText(currentRace.getRace_name());

            // must work after going back to the fragment
            if (characterCreatorViewModel.getRaceCurrentlySelectedHolderPosition() == position) {
                holder.choiceTextView.setBackgroundResource(R.color.gray);
            }

            if (this.isRandomizeSelection == true) {
                if (position != randomRacePositionInt) {
                    holder.choiceTextView.setBackgroundResource(R.color.stainedWhite);
                } else {
                    holder.choiceTextView.setBackgroundResource(R.color.gray);
                    characterCreatorViewModel.setRaceCurrentlySelectedHolderPosition(position);
                    setChosenRace(currentRace.getRace_name()); // used together with getChosenRace to be used by racefragment to cache data in viewmodel
                    mListener.onRaceItemInteraction(currentRace);
                }
                holder.choiceTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (null != mListener) {
                            //Log.d("trybaby", "" + characterCreatorViewModel.getUserChoicesList().size());
                            isRandomizeSelection = false;
                            holder.choiceTextView.setBackgroundResource(R.color.gray);
                            //currentlySelected = holder;
                            characterCreatorViewModel.setRaceCurrentlySelectedHolderPosition(position);
                            setChosenRace(currentRace.getRace_name());
                            notifyDataSetChanged();
                            mListener.onRaceItemInteraction(currentRace);
                        }
                    }
                });
            } else {
                if (position != characterCreatorViewModel.getRaceCurrentlySelectedHolderPosition()) {
                    holder.choiceTextView.setBackgroundResource(R.color.stainedWhite);
                }
                holder.choiceTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (null != mListener) {
                            holder.choiceTextView.setBackgroundResource(R.color.gray);
                            //currentlySelected = holder;
                            characterCreatorViewModel.setRaceCurrentlySelectedHolderPosition(position);
                            setChosenRace(currentRace.getRace_name()); // used together with getChosenRace to be used by racefragment to cache data in viewmodel
                            notifyDataSetChanged();
                            mListener.onRaceItemInteraction(currentRace);
                        }
                    }
                });
            }
        } else {
            holder.choiceTextView.setText("No Race");
        }
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (allRaces == null) {
            return 0;
        }
        return allRaces.size();
    }

    // DO THIS TO AVOID SELECTION ERROR WHEN SCROLLING THE RECYCLERVIEW
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    // used by main activity when randomSelectMenu is clicked
    public void randomSelectMenuClicked() {
        setIsRandomizeSelection(true);
        randomizeSelection();
        notifyDataSetChanged();
        //this.linearLayoutManager.scrollToPosition(this.holderPosition);
    }

    public void setAllRaces(List<CHARACTER_RACE> races) {
        this.allRaces = races;
        notifyDataSetChanged();
    }

    // randomize selection and scroll to the holder position
    public void randomizeSelection() {
        this.randomRacePositionInt = Randomizer.normalRandomizedPositionInt(getItemCount()); // from Randomizer class in logic package
        this.linearLayoutManager.scrollToPositionWithOffset(this.randomRacePositionInt, 0);
    }

    public String getChosenRace() {
        return this.chosenRace;
    }

    public void setChosenRace(String chosenRace) {
        this.chosenRace = chosenRace;
    }

    public void setIsRandomizeSelection(boolean isRandomizeSelection) {
        this.isRandomizeSelection = isRandomizeSelection;
    }
}