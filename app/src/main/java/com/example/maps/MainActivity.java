package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int ERROR_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //checking the devices maps api version
    public boolean isServicesOk(){
        Log.d(TAG, "isServicesOk: checking google maps version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        if (available == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServicesOk: everything working fine");
            return true;
        }else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //there is a fixable error
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(this, available, ERROR_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}