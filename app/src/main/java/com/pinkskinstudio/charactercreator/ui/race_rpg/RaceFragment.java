package com.pinkskinstudio.charactercreator.ui.race_rpg;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
import com.pinkskinstudio.charactercreator.entities.CHARACTER_RACE;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnRaceItemInteractionListener}
 * interface.
 */
public class RaceFragment extends androidx.fragment.app.Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnRaceItemInteractionListener mListener;
    private RaceAdapter raceAdapter;
    private CharacterCreatorViewModel characterCreatorViewModel;
    private RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RaceFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RaceFragment newInstance(int columnCount) {
        RaceFragment raceFragment = new RaceFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        raceFragment.setArguments(args);
        return raceFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // if racefragment is shown, revert to using UP button instead of navigation. take note of casting appcompatactivity
        // https://stackoverflow.com/questions/18320713/getsupportactionbar-from-inside-of-fragment-actionbarcompat
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Races");

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choices_list, container, false);

        // Set the adapter
        Context context = view.getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.choicesListRecycleView);
        recyclerView.setHasFixedSize(true);
        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        raceAdapter = new RaceAdapter(mListener, requireActivity(), this.recyclerView);
        recyclerView.setAdapter(raceAdapter);
        // Initialize ViewModel
        characterCreatorViewModel = new ViewModelProvider(requireActivity())
                .get(CharacterCreatorViewModel.class);
        // Observe if getRacesAlphabetized get changed
        characterCreatorViewModel.getRacesAlphabetized().observe(getViewLifecycleOwner(),
                new Observer<List<CHARACTER_RACE>>() {
            @Override
            public void onChanged(@Nullable final List<CHARACTER_RACE> races) {
                // Update the cached copy of the words in the adapter.
                raceAdapter.setAllRaces(races);
            }
        });
        return view;
    }

    // To make sure the interface is implemented
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRaceItemInteractionListener) {
            mListener = (OnRaceItemInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRaceItemInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    //
    @Override
    public void onPause() {
        super.onPause();
        // add values to livedata so it persists until activity ends????
        characterCreatorViewModel.addUserChoice(raceAdapter.getChosenRace());
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
    public interface OnRaceItemInteractionListener {
        // TODO: Update argument type and name
        void onRaceItemInteraction(CHARACTER_RACE raceItem);
    }

    public RaceAdapter getRaceAdapter() {
        return raceAdapter;
    }
}
