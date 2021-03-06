package com.example.dougl.whatstheline;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class FoodCardActivity extends AppCompatActivity {

    boolean isFav;
    int userInput=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String title= getIntent().getStringExtra("Title");
        String description = getIntent().getStringExtra("Description");
        int RIN = getIntent().getIntExtra("RIN",0);
        setContentView(R.layout.activity_food_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        TextView wait = (TextView) findViewById(R.id.WaitLength);
        wait.setText("Short");
        ImageView graph = (ImageView) findViewById(R.id.graphPlaceHolder);
        graph.setImageResource(R.mipmap.graph);
        final Button favButton = (Button) findViewById(R.id.FavButton);
        if(isFav){
            favButton.setText("Unfavorite");
        }
        getSupportActionBar().setTitle(title);
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set status of card to !isFav
                isFav = !isFav;
                if (isFav) {
                    favButton.setText("Unfavorite");
                } else {
                    favButton.setText("Favorite");
                }
            }

        });

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(FoodCardActivity.this, fab);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                FoodCardActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        sendUserInput(item.getTitle().toString());
                        return true;
                    }
                });

                popup.show();
            }
        });
        TextView descriptionBox = (TextView) findViewById(R.id.descriptionBox);
        descriptionBox.setText(description);

    }

    public void sendUserInput(String item) {
        switch(item){
            case "None":
                userInput = 0;
                break;
            case "Short":
                userInput = 1;
                break;
            case "Medium":
                userInput=2;
                break;
            case "Long":
                userInput=3;
                break;
            case "Literally Forever":
                userInput=4;
                break;
        }
        //send data from user to server or something
        //stored in variable userInput
    }
    

}
