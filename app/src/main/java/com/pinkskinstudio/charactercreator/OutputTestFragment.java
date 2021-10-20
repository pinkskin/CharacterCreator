package com.pinkskinstudio.charactercreator;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pinkskinstudio.charactercreator.entities.Character_RPG;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OutputTestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OutputTestFragment extends Fragment {

    private ArrayList<String> userChoicesList = new ArrayList<String>();

    public OutputTestFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static OutputTestFragment newInstance(String param1, String param2) {
        OutputTestFragment fragment = new OutputTestFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_output_test, container, false);

        TextView raceTextView = (TextView) view.findViewById(R.id.raceTextView);
        TextView classTextView = (TextView) view.findViewById(R.id.classTextView);

        CharacterCreatorViewModel characterCreatorViewModel = new
                ViewModelProvider(requireActivity())
                .get(CharacterCreatorViewModel.class);
        raceTextView.setText(characterCreatorViewModel.getUserChoicesList().get(0));
        classTextView.setText(characterCreatorViewModel.getUserChoicesList().get(1));

        return view;
    }
}