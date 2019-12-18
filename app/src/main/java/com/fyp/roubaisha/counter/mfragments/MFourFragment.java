package com.fyp.roubaisha.counter.mfragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fyp.roubaisha.counter.R;
import com.fyp.roubaisha.counter.mactivity.MMaghribfard;
import com.fyp.roubaisha.counter.mactivity.MMaghribnafil;
import com.fyp.roubaisha.counter.mactivity.MMaghribsunnah;

public class MFourFragment extends Fragment {
    Activity context;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context=getActivity();
        return inflater.inflate(R.layout.fragment_four, container, false);
    }
    public void onStart(){
        super.onStart();
        Button btmf=(Button)context.findViewById(R.id.btnOpenmf);
        btmf.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                //create an Intent object
                Intent intent=new Intent(context, MMaghribfard.class);
                //add data to the Intent object
                //start the second activity
                startActivity(intent);
            }

        });
        Button btnOpenms=(Button)context.findViewById(R.id.btnOpenms);
        btnOpenms.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                //create an Intent object
                Intent intent=new Intent(context, MMaghribsunnah.class);
                //add data to the Intent object
                //start the second activity
                startActivity(intent);
            }

        });
        Button btnOpenmn=(Button)context.findViewById(R.id.btnOpenmn);
        btnOpenmn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                //create an Intent object
                Intent intent=new Intent(context, MMaghribnafil.class);
                //add data to the Intent object
                //start the second activity
                startActivity(intent);
            }

        });
    }


}
