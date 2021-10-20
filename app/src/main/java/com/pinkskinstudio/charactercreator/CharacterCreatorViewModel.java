package com.pinkskinstudio.charactercreator;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.pinkskinstudio.charactercreator.entities.Character_RPG;
import com.pinkskinstudio.charactercreator.entities.Class_RPG;
import com.pinkskinstudio.charactercreator.entities.CHARACTER_RACE;

import java.util.ArrayList;
import java.util.List;

public class CharacterCreatorViewModel extends AndroidViewModel {

    private CharacterCreatorRepository mRepository;

    private LiveData<List<CHARACTER_RACE>> allRaces;
    private LiveData<List<Class_RPG>> allClasses;
    private LiveData<List<Character_RPG>> allCharacters;
    // cached list TO BE CHANGED INTO HASHMAP
    private ArrayList<String> userChoicesList = new ArrayList<String>();
    // cached adapter stuff for currently selected viewholder
    private int raceCurrentlySelectedHolderPosition = -1;

    public CharacterCreatorViewModel (Application application) {
        super(application);
        mRepository = new CharacterCreatorRepository(application);
        allRaces = mRepository.getRacesAlphabetized();
        allClasses = mRepository.getClassesAlphabetized();
        allCharacters = mRepository.getCharactersAscending();
    }

    public LiveData<List<CHARACTER_RACE>> getRacesAlphabetized() {
        return allRaces;
    }

    public LiveData<List<Class_RPG>> getAllClassesAlphabetized() {
        return allClasses;
    }

    public LiveData<List<Character_RPG>> getCharactersAscending() { return allCharacters; }

    public void insertCharacter(Character_RPG character) { mRepository.insertCharacter(character); }

    // try to add strings to ArrayList<String> userChoicesList
    public void addUserChoice(String userChoice) {
        this.userChoicesList.add(userChoice);
    }
    // get the ArrayList<String> userChoicesList
    public ArrayList<String> getUserChoicesList() { return this.userChoicesList; }

    public int getRaceCurrentlySelectedHolderPosition() {
        return raceCurrentlySelectedHolderPosition;
    }
    public void setRaceCurrentlySelectedHolderPosition(int raceCurrentlySelectedHolderPosition) {
        this.raceCurrentlySelectedHolderPosition = raceCurrentlySelectedHolderPosition;
    }
}

/*
Warning: Don't keep a reference to a context that has a shorter lifecycle than your ViewModel!
Examples are:
        Activity
        RaceFragment
        View
Keeping a reference can cause a memory leak, e.g. the ViewModel has a reference to a destroyed
Activity! All these objects can be destroyed by the operative system and recreated when there's a
configuration change, and this can happen many times during the lifecycle of a ViewModel.

If you need the application context (which has a lifecycle that lives as long as the application
does), use AndroidViewModel, as shown in this codelab.

Important: ViewModels don't survive the app's process being killed in the background when the OS
needs more resources. For UI data that needs to survive process death due to running out of
resources, you can use the Saved State module for ViewModels.
*/

