package com.hms.killthedemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class duel extends AppCompatActivity {

    int DemonHealth = 100;
    int heroHealth = 100;
    String HeroName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duel);

        TextView heroName = findViewById(R.id.txtHeroName);
        TextView demonHealth = findViewById(R.id.txtDemonHealth);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("name");
            HeroName = value;
        }

        heroName.setText("Hero " + HeroName + " - " + heroHealth);
        demonHealth.setText("" + DemonHealth);

        findViewById(R.id.btnScissor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int demonPick = random.nextInt(3 + 1) + 1;

                if(demonPick == 1){
                    Toast.makeText(duel.this, "Draw", Toast.LENGTH_SHORT).show();
                } else if (demonPick == 2) {
                    Toast.makeText(duel.this, "Lose", Toast.LENGTH_SHORT).show();
                    heroHealth -= 10;
                    heroName.setText("Hero " + HeroName + " - " + heroHealth);
                } else {
                    Toast.makeText(duel.this, "Win", Toast.LENGTH_SHORT).show();
                    DemonHealth -= 10;
                    demonHealth.setText("" + DemonHealth);
                }

                if(heroHealth < 10){
                    Finish("Lose");
                } else if(DemonHealth < 10){
                    Finish("Win");
                }
            }
        });

        findViewById(R.id.btnRock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int demonPick = random.nextInt(3 + 1) + 1;

                if(demonPick == 1){
                    Toast.makeText(duel.this, "Win", Toast.LENGTH_SHORT).show();
                    DemonHealth -= 10;
                    demonHealth.setText("" + DemonHealth);
                } else if (demonPick == 2) {
                    Toast.makeText(duel.this, "Draw", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(duel.this, "Lose", Toast.LENGTH_SHORT).show();
                    heroHealth -= 10;
                    heroName.setText("Hero " + HeroName + " - " + heroHealth);
                }

                if(heroHealth < 10){
                    Finish("Lose");
                } else if(DemonHealth < 10){
                    Finish("Win");
                }
            }
        });

        findViewById(R.id.btnPaper).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int demonPick = random.nextInt(3 + 1) + 1;

                if(demonPick == 1){
                    Toast.makeText(duel.this, "Lose", Toast.LENGTH_SHORT).show();
                    heroHealth -= 10;
                    heroName.setText("Hero " + HeroName + " - " + heroHealth);
                } else if (demonPick == 2) {
                    Toast.makeText(duel.this, "Win", Toast.LENGTH_SHORT).show();
                    DemonHealth -= 10;
                    demonHealth.setText("" + DemonHealth);
                } else {
                    Toast.makeText(duel.this, "Draw", Toast.LENGTH_SHORT).show();
                }

                if(heroHealth < 10){
                    Finish("Lose");
                } else if(DemonHealth < 10){
                    Finish("Win");
                }
            }
        });
    }

    private void Finish(String status) {
        Intent gotoResult = new Intent(this, result.class);
        gotoResult.putExtra("name", HeroName);
        gotoResult.putExtra("status", status);
        startActivity(gotoResult);
    }
}