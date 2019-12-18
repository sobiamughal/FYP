package com.fyp.roubaisha.counter.Quran;

import android.app.Application;
import android.content.res.Resources;

import com.fyp.roubaisha.counter.Quran.model.ModelAyat;
import com.fyp.roubaisha.counter.Quran.model.ModelSurah;
import com.fyp.roubaisha.counter.Quran.database.DatabaseHelper;
import com.fyp.roubaisha.counter.Quran.utils.PreferenceApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonesrandom on 2/20/18.
 *
 * @site www.androidexample.web.id
 * @github @alfianyusufabdullah
 */

public class App extends Application {

    private static Resources resources;

    @Override
    public void onCreate() {
        super.onCreate();

        resources = getResources();
        DatabaseHelper.initDatabase(this);
        PreferenceApp.initPreferences(this);
    }

    public static BufferedReader getRawResources(int res){
        InputStream streamReader = resources.openRawResource(res);
        return new BufferedReader(new InputStreamReader(streamReader));
    }

}
