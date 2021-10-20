package com.pinkskinstudio.charactercreator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.pinkskinstudio.charactercreator.R;

public class MainActivity extends AppCompatActivity {

    // TODO: 23/06/2020 Make it possible to just randomize a choice or everything
    // TODO: 23/06/2020 Don't forget to make a minigame out of it 
    // TODO: 23/06/2020 Make the app customizable by users. (add tables etc)
    // TODO: 30/06/2020 Make a keyword list in excel or txt file
    // TODO: 28/07/2020 make the list-item selection work
    // TODO: 28/07/2020 edit this character rpg to reflect ALL the subclasses, subprofessions etc
    // TODO: 28/07/2020 just make a query that if var != null, display

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting the Toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Character Creator");
        /*myToolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().popBackStack();
                //finish();
            }
        });*/

        Button characterCreationButton = (Button) findViewById(R.id.characterCreationButton);
        characterCreationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CharacterCreationActivity.class);
                startActivity(intent);
            }
        });

        Button characterListButton = (Button) findViewById(R.id.characterListButton);
        characterListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CharacterList.class);
                startActivity(intent);
            }
        });
    }

    // To make the toolbar use the layout from menu in res
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }*/
}
