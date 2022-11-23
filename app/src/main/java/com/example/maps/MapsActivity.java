package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MapsActivity extends AppCompatActivity {
    private static final String COURSE_PERMISSION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final String FINE_PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final int REQUEST_CODE = 1111;
    private Boolean isOk = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
    }

    public void getLocations(){
        String[] permissions = {FINE_PERMISSION, COURSE_PERMISSION};
        if(ContextCompat.checkSelfPermission(this, COURSE_PERMISSION)== PackageManager.PERMISSION_GRANTED){
            if (ContextCompat.checkSelfPermission(this, FINE_PERMISSION) == PackageManager.PERMISSION_GRANTED){
                isOk = true;
            }else{
                ActivityCompat.requestPermissions(this,permissions, REQUEST_CODE );
            }
        }
    }
}