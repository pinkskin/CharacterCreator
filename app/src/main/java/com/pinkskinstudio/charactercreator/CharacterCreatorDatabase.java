package com.pinkskinstudio.charactercreator;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.pinkskinstudio.charactercreator.entities.CHARACTER_RACE;
import com.pinkskinstudio.charactercreator.entities.CHARACTER_SUBRACE_1;
import com.pinkskinstudio.charactercreator.entities.Character_RPG;
import com.pinkskinstudio.charactercreator.entities.Class_RPG;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CHARACTER_RACE.class, CHARACTER_SUBRACE_1.class, Class_RPG.class,
        Character_RPG.class}, version = 1, exportSchema = false)
public abstract class CharacterCreatorDatabase extends RoomDatabase {

    private static volatile CharacterCreatorDatabase INSTANCE;
    public static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract CharacterCreatorDao characterCreatorDao();

    static CharacterCreatorDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CharacterCreatorDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CharacterCreatorDatabase.class, "character_creator_database")
                            .createFromAsset("databases/characterCreator.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // Put values initially to the database
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);  // CURRENTLY USING onOpen WHERE IT DOES STUFF EVERY OPENING OF THE APP? CONSIDER USING ONCREATE INSTEAD?? edit: stick with onOpen for now. https://stackoverflow.com/questions/53763787/oncreate-of-roomdatabase-callback-was-not-called-after-a-successful-call-to
            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.

                /*CharacterCreatorDao dao = INSTANCE.characterCreatorDao();
                //dao.deleteAllRace();
                //dao.deleteAllClass();
                //dao.deleteAllCharacter();


                CHARACTER_RACE race = new CHARACTER_RACE("Human",
                        "[+1str][+1dex][+1int][+1con][+1wis][+1cha]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("Dwarf", "[+2str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("Elf", "[+2dex][+2cha]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("Orc", "[+3str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("Goblin", "[+3int][+2dex]");
                dao.insertRace(race);
                //testttt
                race = new CHARACTER_RACE("1", "[+2str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("2", "[+2dex][+2cha]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("3", "[+3str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("4", "[+3int][+2dex]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("5", "[+2str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("6", "[+2dex][+2cha]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("7", "[+3str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("8", "[+3int][+2dex]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("9", "[+2str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("10", "[+2dex][+2cha]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("11", "[+3str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("12", "[+3int][+2dex]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("13", "[+2str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("14", "[+2dex][+2cha]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("15", "[+3str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("16", "[+3int][+2dex]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("17", "[+2str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("18", "[+2dex][+2cha]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("19", "[+3str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("20", "[+3int][+2dex]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("21", "[+2str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("22", "[+2dex][+2cha]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("23", "[+3str][+2con]");
                dao.insertRace(race);
                race = new CHARACTER_RACE("24", "[+3int][+2dex]");
                dao.insertRace(race);

                Class_RPG class_ = new Class_RPG("Warrior", "df");
                dao.insertClass(class_);
                class_ = new Class_RPG("Rogue", "df");
                dao.insertClass(class_);
                class_ = new Class_RPG("Wizard", "df");
                dao.insertClass(class_);
                class_ = new Class_RPG("Cleric", "df");
                dao.insertClass(class_);
                class_ = new Class_RPG("Bard", "df");
                dao.insertClass(class_);

                Character_RPG character = new Character_RPG("Sample Character_RPG");
                dao.insertCharacter(character);             //Log.d("STATE", dao.getHumanName());*/
            });
        }
    };
}
