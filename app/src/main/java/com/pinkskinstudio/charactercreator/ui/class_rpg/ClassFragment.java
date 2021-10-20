package com.pinkskinstudio.charactercreator.ui.class_rpg;

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
import com.pinkskinstudio.charactercreator.entities.Class_RPG;
import com.pinkskinstudio.charactercreator.ui.race_rpg.RaceFragment;

import java.util.List;

public class ClassFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    OnClassItemInteractionListener mListener;
    ClassAdapter classAdapter;
    CharacterCreatorViewModel characterCreatorViewModel;

    public ClassFragment() {
        // Required empty public constructor
    }

    // TODO: Customize parameter initialization
    // unused
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

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Classes");

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
        classAdapter = new ClassAdapter(mListener/*, getActivity().getApplication()*/);
        recyclerView.setAdapter(classAdapter);
        characterCreatorViewModel = new ViewModelProvider(requireActivity())
                .get(CharacterCreatorViewModel.class);

        characterCreatorViewModel.getAllClassesAlphabetized().observe(getViewLifecycleOwner(),
                new Observer<List<Class_RPG>>() {
            @Override
            public void onChanged(@Nullable final List<Class_RPG> class_rpg) {
                // Update the cached copy of the words in the adapter.
                classAdapter.setAllClasses(class_rpg);
            }
        });

        return view;
    }

    // To make sure the interface is implemented
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ClassFragment.OnClassItemInteractionListener) {
            mListener = (ClassFragment.OnClassItemInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnClassItemInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onPause() {
        super.onPause();
        // add values to livedata so it persists until activity ends????
        characterCreatorViewModel.addUserChoice(classAdapter.getChosenClass());
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
    public interface OnClassItemInteractionListener {
        // TODO: Update argument type and name
        void onClassItemInteraction(Class_RPG class_rpg);
    }
}