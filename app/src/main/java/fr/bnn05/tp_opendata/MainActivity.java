package fr.bnn05.tp_opendata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String key_list = "key_list";
    public ArrayList<Diarrhé> diarrhéList;
    private String API = "https://public.opendatasoft.com/api/records/1.0/search/?dataset=sentinelles-diarrhee-aigue&q=&sort=week&facet=geo_name";
    private DiarrhéAdapter diaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        diarrhéList = new ArrayList<>();
        ListView lvDia = findViewById(R.id.listView);
        diaAdapter = new DiarrhéAdapter(MainActivity.this,diarrhéList );
        lvDia.setAdapter(diaAdapter);
        if(this.checkInternet()){
            new HTTPSRequest().execute(API, diaAdapter, diarrhéList);
        }
    }

    private boolean checkInternet() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
        if(activeNetworkInfo != null && activeNetworkInfo.isConnected()){
            return true;
        }else{
            Toast.makeText(getApplicationContext(), "No internet connection", Toast.LENGTH_LONG).show();
            return false;
        }

    }

    public void onClickMap(View view) {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        intent.putExtra(key_list, diarrhéList);
        startActivityForResult(intent, 1);
    }
}