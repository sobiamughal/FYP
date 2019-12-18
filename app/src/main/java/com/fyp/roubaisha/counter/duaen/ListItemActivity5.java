package com.fyp.roubaisha.counter.duaen;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.fyp.roubaisha.counter.R;

public class ListItemActivity5 extends AppCompatActivity {
    Button play;
    MediaPlayer mP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_activity_5);
        getSupportActionBar().setTitle("Dua when enter the home ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        play = (Button)findViewById(R.id.button_play);
         mP = MediaPlayer.create(ListItemActivity5.this, R.raw.mse);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mP.isPlaying()){
                    mP.pause();
                    play.setBackgroundResource(R.drawable.play);
                }else {
                    mP.start();
                    play.setBackgroundResource(R.drawable.pause);
                }
            }
        });
    }
    public void onBackPressed(){
        super.onBackPressed();
        //stopAndPlay();
        mP.stop();
        finish();

    }
    @Override

    protected void onPause() {
        super.onPause();
        if (mP != null){
            mP.stop();
            if (isFinishing()){
                mP.stop();
                mP.release();
            }
        }
    }
}