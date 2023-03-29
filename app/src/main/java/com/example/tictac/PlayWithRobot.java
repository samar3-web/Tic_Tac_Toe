package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PlayWithRobot extends AppCompatActivity implements View.OnTouchListener{

    private String playerName;
    private EditText playerNameTxt;
    private Button playerButton;
    private ImageView BackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_play_with_robot);

        BackBtn = (ImageView) findViewById(R.id.ai_player_names_back_btn);
        playerNameTxt = (EditText) findViewById(R.id.ai_player_name_edttxt);
        playerButton = (Button) findViewById(R.id.ai_player_name_btn);

        playerButton.setOnTouchListener(this);
        playerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(playerNameTxt.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Enter Name", Toast.LENGTH_LONG).show();
                } else {

                    playerName = playerNameTxt.getText().toString();
                    Intent intent = new Intent(PlayWithRobot.this,SymbolForRobot.class);
                    intent.putExtra("p1",playerName);
                    startActivity(intent);
                }
            }
        });

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (v == playerButton) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.setAlpha(0.5f);
            }   else {
                v.setAlpha(1f);
            }
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
