package com.pinkskinstudio.charactercreator.ui.character_rpg;

import com.pinkskinstudio.charactercreator.ui.character_rpg.CharacterFragment.OnCharacterItemInteractionListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pinkskinstudio.charactercreator.R;
import com.pinkskinstudio.charactercreator.entities.Character_RPG;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private List<Character_RPG> allCharacters;
    private final OnCharacterItemInteractionListener mListener;

    // Constructor
    public CharacterAdapter(OnCharacterItemInteractionListener listener) { mListener = listener; }

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
        if (this.allCharacters != null) {
            Character_RPG currentCharacter = allCharacters.get(position);
            holder.choiceRadioButton.setText(currentCharacter.getCharacterID() + " " +
                    currentCharacter.getCharacterName());
            holder.choiceRadioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        // Notify the active callbacks interface (the activity, if the
                        // fragment is attached to one) that an item has been selected.
                        mListener.onCharacterItemInteraction(allCharacters.get(position));
                    }
                }
            });
        } else {
            holder.choiceRadioButton.setText("No Character");
        }
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (allCharacters == null) {
            return 0;
        }
        return allCharacters.size();
    }

    public void setAllCharacters(List<Character_RPG> character_rpg) {
        this.allCharacters = character_rpg;
        notifyDataSetChanged();
    }



}
