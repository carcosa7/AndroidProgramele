package com.heyletscode.ihavetofly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isMute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });

        TextView highScoreTxt = findViewById(R.id.highScoreTxt);

        final SharedPreferences prefs = getSharedPreferences("game", MODE_PRIVATE);
        highScoreTxt.setText("HighScore: " + prefs.getInt("highscore", 0));

        isMute = prefs.getBoolean("isMute", false);

        final ImageView volumeCtrl = findViewById(R.id.volumeCtrl);

        if (isMute)
            volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
        else
            volumeCtrl.setImageResource(R.drawable.ic_volume_up_black_24dp);

        volumeCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isMute = !isMute;
                if (isMute)
                    volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
                else
                    volumeCtrl.setImageResource(R.drawable.ic_volume_up_black_24dp);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isMute", isMute);
                editor.apply();

            }
        });

        Button button = findViewById(R.id.about_btn);
        // Button resulthistory = findViewById(R.id.results_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startClick(v);
            }
        });

    }

    public void startClick(View v)
    {
//        if(R.id.start_btn == v.getId()){
//            Intent intent = new Intent (this, GameActivity.class);
//            startActivity(intent);
//        }
//
//        else if(R.id.results_id == v.getId())
//        {
//            Intent intent = new Intent (this, ResultsActivity.class);
//            startActivity(intent);
//        }
//
//        else if(R.id.settings_btn == v.getId())
//        {
//            Intent intent = new Intent (this, SettingsActivity.class);
//            startActivity(intent);
//        }

        if(R.id.about_btn == v.getId())
        {
            Intent intent = new Intent (this, AboutActivity.class);
            startActivity(intent);
        }
        else if(R.id.highscore_btn == v.getId())
        {
            Intent intent = new Intent (this, HighscoreActivity.class);
            startActivity(intent);
        }
    }
}
