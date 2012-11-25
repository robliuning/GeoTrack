package com.example.geotrack;


import android.app.FragmentTransaction;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;

public class MainActivity extends SherlockFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /** Called when the activity is first created. */
        ActionBar bar = getSupportActionBar();
        
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tab1 = bar.newTab();
        ActionBar.Tab tab2 = bar.newTab();
        tab1.setText("Tracking");
        tab2.setText("About us");
        tab1.setTabListener(new MyTabListener());
        tab2.setTabListener(new MyTabListener());
        bar.addTab(tab1);
        bar.addTab(tab2);   
    }
    
    private class MyTabListener implements ActionBar.TabListener
    {
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
    if(tab.getPosition()==0)
    {
    FragmentAbout frag = new FragmentAbout();
    //ft.replace(android.R.id.content, frag);
    }
    else
    {
    //FragmentMain frag = new FragmentMain();
    //ft.replace(android.R.id.content, frag);
    }
    }
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    // TODO Auto-generated method stub
    }
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    // TODO Auto-generated method stub
    }
	public void onTabSelected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	public void onTabUnselected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	public void onTabReselected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
    }
}
