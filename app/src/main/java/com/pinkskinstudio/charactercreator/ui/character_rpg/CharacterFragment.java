package com.pinkskinstudio.charactercreator.ui.character_rpg;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pinkskinstudio.charactercreator.CharacterCreatorViewModel;
import com.pinkskinstudio.charactercreator.R;
import com.pinkskinstudio.charactercreator.entities.Character_RPG;
import com.pinkskinstudio.charactercreator.ui.class_rpg.ClassFragment;

import java.util.List;

public class CharacterFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    OnCharacterItemInteractionListener mListener;
    CharacterAdapter characterAdapter;
    CharacterCreatorViewModel characterCreatorViewModel;

    public CharacterFragment() {
        // Required empty public constructor
    }

    // TODO: Customize parameter initialization
    // unused
    public static CharacterFragment newInstance(int columnCount) {
        CharacterFragment characterFragment = new CharacterFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        characterFragment.setArguments(args);
        return characterFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Character Creator");

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.choices_list, container, false);

        // Set the adapter
        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.choicesListRecycleView);
        recyclerView.setHasFixedSize(true);
        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        characterAdapter = new CharacterAdapter(mListener);
        recyclerView.setAdapter(characterAdapter);
        characterCreatorViewModel = new ViewModelProvider(requireActivity())
                .get(CharacterCreatorViewModel.class);

        characterCreatorViewModel.getCharactersAscending().observe(getViewLifecycleOwner(),
                new Observer<List<Character_RPG>>() {
                    @Override
                    public void onChanged(@Nullable final List<Character_RPG> character_rpg) {
                        // Update the cached copy of the words in the adapter.
                        characterAdapter.setAllCharacters(character_rpg);
                    }
                });

        return view;
    }

    // To make sure the interface is implemented
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ClassFragment.OnClassItemInteractionListener) {
            mListener = (OnCharacterItemInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnCharacterItemInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnCharacterItemInteractionListener {
        // TODO: Update argument type and name
        void onCharacterItemInteraction(Character_RPG character_rpg);
    }
}