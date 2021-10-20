package com.pinkskinstudio.charactercreator;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.pinkskinstudio.charactercreator.entities.CHARACTER_RACE;
import com.pinkskinstudio.charactercreator.entities.Character_RPG;
import com.pinkskinstudio.charactercreator.entities.Class_RPG;

import java.util.List;

class CharacterCreatorRepository {
    private CharacterCreatorDao characterCreatorDao;
    private LiveData<List<CHARACTER_RACE>> allRaces;
    private LiveData<List<Class_RPG>> allClasses;
    private LiveData<List<Character_RPG>> allCharacters;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    CharacterCreatorRepository(Application application) {
        CharacterCreatorDatabase database = CharacterCreatorDatabase.getDatabase(application);
        characterCreatorDao = database.characterCreatorDao(); //https://stackoverflow.com/questions/48790457/abstract-method-used-without-implementation     side: lol nasa overview rin to ng Room
        allRaces = characterCreatorDao.getRacesAlphabetized();
        allClasses = characterCreatorDao.getClassesAlphabetized();
        allCharacters = characterCreatorDao.getCharactersAscending();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<CHARACTER_RACE>> getRacesAlphabetized() { return allRaces; }
    LiveData<List<Class_RPG>> getClassesAlphabetized() { return allClasses; }
    LiveData<List<Character_RPG>> getCharactersAscending() { return allCharacters; }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insertCharacter(Character_RPG character) {
        CharacterCreatorDatabase.databaseWriteExecutor.execute(() -> {
            characterCreatorDao.insertCharacter(character);
        });
    }

    public void insertRace(CHARACTER_RACE CHARACTERRACE) {
        CharacterCreatorDatabase.databaseWriteExecutor.execute(() -> {
            characterCreatorDao.insertRace(CHARACTERRACE);
        });
    }

    public void insertClass(Class_RPG class_rpg) {
        CharacterCreatorDatabase.databaseWriteExecutor.execute(() -> {
            characterCreatorDao.insertClass(class_rpg);
        });
    }
}
