package com.pinkskinstudio.charactercreator.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.pinkskinstudio.charactercreator.CharacterCreatorViewModel;
import com.pinkskinstudio.charactercreator.OutputTestFragment;
import com.pinkskinstudio.charactercreator.R;
import com.pinkskinstudio.charactercreator.entities.Character_RPG;
import com.pinkskinstudio.charactercreator.entities.Class_RPG;
import com.pinkskinstudio.charactercreator.entities.CHARACTER_RACE;
import com.pinkskinstudio.charactercreator.ui.character_rpg.CharacterFragment;
import com.pinkskinstudio.charactercreator.ui.class_rpg.ClassFragment;
import com.pinkskinstudio.charactercreator.ui.race_rpg.RaceFragment;

public class CharacterCreationActivity extends AppCompatActivity implements
        RaceFragment.OnRaceItemInteractionListener, ClassFragment.OnClassItemInteractionListener,
        CharacterFragment.OnCharacterItemInteractionListener{
    private RaceFragment mRaceFragment;
    private ClassFragment mClassFragment;
    private CharacterFragment mCharacterFragment;
    private Toolbar myToolbar;
    private CharacterCreatorViewModel characterCreatorViewModel;

    // tester fragment
    OutputTestFragment outputTestFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);

        // Setting the Toolbar
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar_character_creation);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Character Creator");
        myToolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                //getSupportFragmentManager().popBackStack();
            }
        });

        mRaceFragment = new RaceFragment();
        mClassFragment = new ClassFragment();
        mCharacterFragment = new CharacterFragment();
        outputTestFragment = new OutputTestFragment();

        FrameLayout characterCreationFrameLayout = (FrameLayout) findViewById(R.id.characterCreationFrameLayout);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.characterCreationFrameLayout, mRaceFragment, "raceFragment")
                //.addToBackStack(null)
                .commit();
    }

    // To make the toolbar use the layout from menu in res
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // implemented from RaceFragment
    @Override
    public void onRaceItemInteraction(CHARACTER_RACE raceItem) {
        /*getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.myFrameLayout, mClassFragment, "classFragment")
                .addToBackStack(null)
                .commit();*/
    }
    @Override
    public void onClassItemInteraction(Class_RPG classItem) {
        //Log.d("show", ""+this.userChoicesArr.length);
        /*OutputTestFragment outputTestFragment = new OutputTestFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.myFrameLayout, outputTestFragment, "characterFragment")
                .addToBackStack(null)
                .commit();*/
    }
    @Override
    public void onCharacterItemInteraction(Character_RPG characterItem) {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.randomSelectMenu) {
            RaceFragment raceFragment = (RaceFragment) getSupportFragmentManager()
                    .findFragmentByTag("raceFragment");
            if (raceFragment != null && raceFragment.isVisible()) {
                raceFragment.getRaceAdapter().randomSelectMenuClicked();
            }
            // TODO: 07/08/2020 consider having a next button in fragments and perhaps link this to the method therein
        } else if (item.getItemId() == R.id.nextMenu) {
            RaceFragment raceFragment = (RaceFragment) getSupportFragmentManager()
                    .findFragmentByTag("raceFragment");
            ClassFragment classFragment = (ClassFragment) getSupportFragmentManager()
                    .findFragmentByTag("classFragment");

            if (raceFragment != null && raceFragment.isVisible()) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.characterCreationFrameLayout, new ClassFragment()/*mClassFragment*/, "classFragment")
                        .addToBackStack(null)
                        .commit();
            }
            if (classFragment != null && classFragment.isVisible()) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.characterCreationFrameLayout, outputTestFragment/*mClassFragment*/, "outputTestFragment")
                        .addToBackStack(null)
                        .commit();
            }
        } else {

        }

        return super.onOptionsItemSelected(item);
    }
}