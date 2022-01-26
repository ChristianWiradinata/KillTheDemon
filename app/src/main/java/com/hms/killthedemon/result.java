package com.hms.killthedemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class result extends AppCompatActivity {

    String status;
    String heroName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        View layout = findViewById(R.id.layout);

        TextView resultStatus = findViewById(R.id.txtStatus);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("status");
            String name = extras.getString("name");
            status = value;
            heroName = name;
        }

        if(status.equals("Lose")){
            layout.setBackgroundColor(getResources().getColor(R.color.red));
        } else if(status.equals("Win")){
            layout.setBackgroundColor(getResources().getColor(R.color.green));
        }

        resultStatus.setText("" + status);

        findViewById(R.id.btnRetry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoDuel = new Intent(result.this, duel.class);
                gotoDuel.putExtra("name", heroName);
                startActivity(gotoDuel);
            }
        });

        findViewById(R.id.btnLeave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoMain = new Intent(result.this, MainActivity.class);
                startActivity(gotoMain);
            }
        });
    }
}