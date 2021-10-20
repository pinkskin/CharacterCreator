package com.pinkskinstudio.charactercreator;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.pinkskinstudio.charactercreator.entities.CHARACTER_SUBRACE_1;
import com.pinkskinstudio.charactercreator.entities.Character_RPG;
import com.pinkskinstudio.charactercreator.entities.Class_RPG;
import com.pinkskinstudio.charactercreator.entities.CHARACTER_RACE;

import java.util.List;

@Dao
public interface CharacterCreatorDao {

    // TODO: 04/07/2020  
    // https://developer.android.com/training/data-storage/room/accessing-data

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertRace(CHARACTER_RACE raceName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertSubrace1(CHARACTER_SUBRACE_1 subrace1);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertClass(Class_RPG className);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCharacter(Character_RPG character);

    @Query("DELETE FROM CHARACTER_RACE")
    public void deleteAllRace();

    @Query("DELETE FROM CHARACTER_SUBRACE_1")
    public void deleteAllSubrace1();

    @Query("DELETE FROM class_table")
    public void deleteAllClass();

    @Query("DELETE FROM character_table")
    public void deleteAllCharacter();

    @Query("SELECT * FROM CHARACTER_RACE ORDER BY race_name ASC")
    public LiveData<List<CHARACTER_RACE>> getRacesAlphabetized();

    @Query("SELECT * FROM CHARACTER_SUBRACE_1 ORDER BY subrace_name ASC")
    public LiveData<List<CHARACTER_SUBRACE_1>> getSubracesAlphabetized();

    // For testing
    /*@Query("SELECT race_name FROM race_table WHERE race_name == 'Goblin'")
    public String getHumanName();*/

    @Query("SELECT * FROM class_table ORDER BY class_name ASC")
    public LiveData<List<Class_RPG>> getClassesAlphabetized();

    @Query("SELECT * FROM character_table ORDER BY character_ID ASC")
    public LiveData<List<Character_RPG>> getCharactersAscending();
}
