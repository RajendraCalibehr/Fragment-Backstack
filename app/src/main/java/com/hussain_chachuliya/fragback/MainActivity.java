package com.hussain_chachuliya.fragback;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get FragmentManager and FragmentTransaction object.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Create FragmentOne instance.
        Frag1 fragmentOne = new Frag1();

        // Add fragment one with tag name.
        fragmentTransaction.add(R.id.fragment_holder, fragmentOne, "Fragment One");
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        FragmentManager fm = getSupportFragmentManager();
        if(FragmentUtil.getVisibleFragment(getSupportFragmentManager()).getTag().equalsIgnoreCase("Fragment One")) {
            this.finish();
            return;
        }

        fm.beginTransaction()
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .show(fm.getFragments().get(fm.getFragments().indexOf(FragmentUtil.getVisibleFragment(fm)) - 1))
                .hide(FragmentUtil.getVisibleFragment(fm))
                .commit();

    }
}
