package com.fyp.roubaisha.counter.prayertime;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.fyp.roubaisha.counter.MyCalendarView;
import com.fyp.roubaisha.counter.PrayerTimeYearActivity;
import com.fyp.roubaisha.counter.R;

import org.json.JSONException;
import org.json.JSONObject;

public class PrayerTimeActivity extends AppCompatActivity {

    private static final String TAG = "PrayerTimeActivity";

    String url;
    // Tag used to cancel the request
    String tag_json_obj = "json_obj_req";
    //Progress Dialog
    ProgressDialog pDialog;

    TextView mFajrTv,mZuharTv,mAsrTv,mMaghribTv,mIshaTv,mLocationTv,mDateTv;
    EditText mSearchEt;
    Button mSearchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_time);

        getSupportActionBar().setTitle("Prayer Time");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFajrTv     = findViewById(R.id.fajrTv);
        mZuharTv    = findViewById(R.id.zuharTv);
        mAsrTv      = findViewById(R.id.asrTv);
        mMaghribTv  = findViewById(R.id.maghribTv);
        mIshaTv     = findViewById(R.id.ishaTv);
        mLocationTv = findViewById(R.id.locationTv);
        mDateTv     = findViewById(R.id.dateTv);
//        mSearchEt   = (EditText) findViewById(R.id.searchEt);
//        mSearchBtn  = (Button)   findViewById(R.id.searchBtn);


//        mSearchBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //get text from editText
//                String mLocation = mSearchEt.getText().toString().trim();
//                //validate if it is null or not
//                if (mLocation.isEmpty()){
//                    Toast.makeText(PrayerTimeActivity.this, "Please enter location", Toast.LENGTH_SHORT).show();
//                }else{
//                    url = "http://muslimsalat.com/"+mLocation+".json?key=b2d880ae06d9e5a5cc7088d1ae0b0158";
//                    searchLocation();
//                }
//            }
//        });

        url = "http://muslimsalat.com/karachi.json?key=b2d880ae06d9e5a5cc7088d1ae0b0158";
        searchLocation();


    }

    private void searchLocation() {

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //get data from JSON
                        try {
                            //get location
                            String country = response.get("country").toString();
                            String state = response.get("state").toString();
                            String city = response.get("city").toString();
                            String location = country+", "+state+", "+city;
                            //get date
                            String date = response.getJSONArray("items").getJSONObject(0).get("date_for").toString();
                            //get names and timings
                            String mFajr = response.getJSONArray("items").getJSONObject(0).get("fajr").toString();
                            String mZuhar = response.getJSONArray("items").getJSONObject(0).get("dhuhr").toString();
                            String mAsr = response.getJSONArray("items").getJSONObject(0).get("asr").toString();
                            String mMaghrib = response.getJSONArray("items").getJSONObject(0).get("maghrib").toString();
                            String mIsha = response.getJSONArray("items").getJSONObject(0).get("isha").toString();

                            //set this data to textView
                            mFajrTv.setText(mFajr);
                            mZuharTv.setText(mZuhar);
                            mAsrTv.setText(mAsr);
                            mMaghribTv.setText(mMaghrib);
                            mIshaTv.setText(mIsha);
                            mLocationTv.setText(location);
                            mDateTv.setText(date);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if(error instanceof NoConnectionError){
                    ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService((Context.CONNECTIVITY_SERVICE));
                    NetworkInfo activeNetwork = null;
                    if (cm != null){
                        activeNetwork = cm.getActiveNetworkInfo();
                    }
                    if (activeNetwork != null && activeNetwork.isConnectedOrConnecting()){
                        Toast.makeText(PrayerTimeActivity.this, "Server is not connected", Toast.LENGTH_SHORT).show();
                       
                    }else {
                        Toast.makeText(PrayerTimeActivity.this, "your device is not connected to internet. ", Toast.LENGTH_SHORT).show();
                    }
                }
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(PrayerTimeActivity.this,"Error",Toast.LENGTH_SHORT).show();
                // hide the progress dialog

                pDialog.hide();

            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_calendar,menu);
        MenuItem menuItem = menu.findItem(R.id.searchbtn);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search by City");
//        int id = searchView.getContext()
//                .getResources()
//                .getIdentifier("android:id/search_src_text", null, null);
//        EditText editText = (EditText) searchView.findViewById(id);
//        String mLocation = searchView.getQuery().toString().trim();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.isEmpty()){

                }else {
                    url = "http://muslimsalat.com/"+query+".json?key=b2d880ae06d9e5a5cc7088d1ae0b0158";
                    searchLocation();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                url = "http://muslimsalat.com/"+s+".json?key=b2d880ae06d9e5a5cc7088d1ae0b0158";
                searchLocation();
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_pcalendar){
            Intent intent = new Intent(PrayerTimeActivity.this, PrayerTimeYearActivity.class);
            startActivity(intent);
        }else if(id==R.id.searchbtn){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}