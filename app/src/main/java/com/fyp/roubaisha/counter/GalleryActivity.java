package com.fyp.roubaisha.counter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryActivity extends AppCompatActivity implements View.OnClickListener {

    private SoundPool soundPool;
    private int tap_sound;
    private int sound3StreamId;

    TextView listdata,tv2;
    ImageView imageView;

    private static final String TAG = "Count_tasbih";
    Button countAdd,bReset;
    int counter;
    SQLiteDatabase db;

    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        //listdata = findViewById(R.id.listdata);
        //imageView = findViewById(R.id.imageView);
        //TextView txtView = findViewById(R.id.tvCountValue);
       // Intent intent = getIntent();
       // LvItem lvItem = intent.getParcelableExtra("name");
       // String name = lvItem.getName();
       // txtView.setText(name);

       // listdata.setText(name);
        listdata = findViewById(R.id.listdata);
        imageView = findViewById(R.id.imageView);
        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image",0);

        listdata.setText(receivedName);
        imageView.setImageResource(receivedImage);
        //enable back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv2 = (TextView)findViewById(R.id.tvCountValue);
        bReset = (Button)findViewById(R.id.bReset);
        db = openOrCreateDatabase("Tasbih_db", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tasbih(_id INTEGER PRIMARY KEY,name VARCHAR,count VARCHAR);");
        Cursor c=db.rawQuery("SELECT * FROM tasbih WHERE name='"+listdata.getText().toString()+"'", null);
        if(c.moveToFirst()){
            try {
                counter = Integer.parseInt(c.getString(2));
                tv2.setText(String.valueOf(counter));
            } catch(NumberFormatException nfe) {
                System.out.println("Could not parse " + nfe);
            }

        }else{
            counter = 0;
            db.execSQL("INSERT INTO tasbih(name , count) VALUES('"+listdata.getText()+"' , '"+counter+"')");
        }
        countAdd = (Button)findViewById(R.id.bAddCount);
        countAdd.setOnClickListener(this);
        bReset.setOnClickListener(this);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }

        tap_sound = soundPool.load(this, R.raw.tap_sound, 1);
    }

    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.bAddCount:
                sound3StreamId = soundPool.play(tap_sound, 1, 1, 0, 0, 1);
                //soundPool.pause(sound3StreamId);
                soundPool.autoPause();
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        vibrator.vibrate(50);
        switch(v.getId()){
            case R.id.bAddCount:
                counter ++;
                tv2.setText(""+counter);
                String count = Integer.toString(counter);
                db.execSQL("UPDATE tasbih SET count='"+count+"' WHERE name='"+listdata.getText().toString()+"'");
                break;
            case R.id.bReset:
                counter = 0;
                String cnt = Integer.toString(counter);
                tv2.setText(cnt);
                db.execSQL("UPDATE tasbih SET count='"+cnt+"' WHERE name='"+listdata.getText().toString()+"'");
                break;
        }

    }
}
