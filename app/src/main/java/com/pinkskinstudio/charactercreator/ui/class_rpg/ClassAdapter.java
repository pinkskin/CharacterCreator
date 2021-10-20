package com.pinkskinstudio.charactercreator.ui.class_rpg;

import com.pinkskinstudio.charactercreator.ui.class_rpg.ClassFragment.OnClassItemInteractionListener;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.pinkskinstudio.charactercreator.R;
import androidx.recyclerview.widget.RecyclerView;

import com.pinkskinstudio.charactercreator.entities.Class_RPG;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {

    private List<Class_RPG> allClasses;
    private String chosenClass;
    private final OnClassItemInteractionListener mListener;
    Application application;

    // Constructor
    public ClassAdapter(OnClassItemInteractionListener listener/*, Application application*/) {
        mListener = listener;
        //this.application = application;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView choiceRadioButton;

        private ViewHolder(View view) {
            super(view);
            choiceRadioButton = (TextView) view.findViewById(R.id.choiceTextView);
        }

        // code below does not work
        /*@Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }*/
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.choice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (this.allClasses != null) {
            Class_RPG currentClass = allClasses.get(position);
            holder.choiceRadioButton.setText(currentClass.getClassName());
            holder.choiceRadioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        // Notify the active callbacks interface (the activity, if the
                        // fragment is attached to one) that an item has been selected.
                        /*CharacterCreatorViewModel characterCreatorViewModel =
                                new CharacterCreatorViewModel(application);
                        characterCreatorViewModel.addUserChoice(currentClass.getClassName());*/
                        //Log.d("trybaby", "" + characterCreatorViewModel.getUserChoicesList().size());
                        mListener.onClassItemInteraction(allClasses.get(position));
                        setChosenClass(allClasses.get(position).getClassName());
                    }
                }
            });
        } else {
            holder.choiceRadioButton.setText("No Class");
        }
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (allClasses == null) {
            return 0;
        }
        return allClasses.size();
    }

    public void setAllClasses(List<Class_RPG> class_rpg) {
        this.allClasses = class_rpg;
        notifyDataSetChanged();
    }

    public String getChosenClass() {
        return chosenClass;
    }

    public void setChosenClass(String chosenClass) {
        this.chosenClass = chosenClass;
    }
}
