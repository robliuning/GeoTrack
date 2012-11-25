package com.example.geotrack;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.provider.Settings;



public class SplashActivity extends Activity {

    final Context context = this;
	
    Thread splashThread = new Thread() {
        @Override					
        public void run() {
           try {
              int waited = 0;
        
                               
              while (waited < 3000) {
                 sleep(100);
                 waited += 100;
              }
           } catch (InterruptedException e) {
              // do nothing
           } finally {
              finish();
              Intent i = new Intent();
              i.setClassName("com.example.geotrack",
                             "com.example.geotrack.MainActivity"); 
              startActivity(i);
           }
        }
     };
    
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
      
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);   
        final boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER); 
        
        
        if(gpsEnabled){
          	
            AlertDialog.Builder adb = new AlertDialog.Builder(context);      	  
         	  adb.setTitle("Warning");
         	  adb.setMessage("Location Service is disabled!")
         	  		.setCancelable(false)
         	  		.setPositiveButton("Noted", new DialogInterface.OnClickListener(){
         	  			public void onClick(DialogInterface dialog, int id){
         	  				dialog.cancel();
         	  				splashThread.start();
         	  			}
         	  		})
         	  		.setNegativeButton("Setting", new DialogInterface.OnClickListener(){
         	  			public void onClick(DialogInterface dialog,int id){
         	  				Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
         	  				context.startActivity(intent);
         	  			}
         	  		});         	  		
         	  		AlertDialog ad = adb.create();          	  		
         	  		ad.show();           	  
           }else{
        	   splashThread.start();
           } 
        
           
       
      
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_splash, menu);
        return true;
    }
}
