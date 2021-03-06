package com.fyp.roubaisha.counter;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;

import com.fyp.roubaisha.counter.UserTasbih.UserTasbih;

public class TasbihOption extends AppCompatActivity implements View.OnClickListener {

    private CardView tasbih, usertasbih;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbih_option);

        getSupportActionBar().setTitle("Tasbih");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tasbih = (CardView) findViewById(R.id.tasbih);
        usertasbih = (CardView) findViewById(R.id.usertasbih);

        tasbih.setOnClickListener(this);
        usertasbih.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tasbih:
                Intent i = new Intent(TasbihOption.this,TasbihActivity.class);
                startActivity(i);
                break;
            case R.id.usertasbih:
                Intent in = new Intent(TasbihOption.this, UserTasbih.class);
                startActivity(in);
                break;
        }
    }
}
