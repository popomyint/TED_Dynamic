package com.example.ted_dynamic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ted_dynamic.Bottom_Fragment.Discover_Frag;
import com.example.ted_dynamic.Bottom_Fragment.My_TED_Frag;
import com.example.ted_dynamic.Bottom_Fragment.Podcasts_Frag;
import com.example.ted_dynamic.Bottom_Fragment.Talks_Frag;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        BottomNavigationView nav = findViewById(R.id.navigation);
        nav.setOnNavigationItemSelectedListener(navListener);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.setting_nav, menu);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Fragment frag;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.discover:
                    actionBar.setTitle("Discover");
                    frag = new Discover_Frag();
                    LoadFragment(frag);
                    return true;
                case R.id.podcasts:
                    actionBar.setTitle("Podcasts");
                    frag = new Podcasts_Frag();
                    LoadFragment(frag);
                    return true;
                case R.id.my_talks:
                    actionBar.setTitle("My Talks");
                    frag = new My_TED_Frag();
                    LoadFragment(frag);
                    return true;
                default:
                    actionBar.setTitle("TED Talks");
                    frag = new Talks_Frag();
                    LoadFragment(frag);
                    return true;
            }
        }
    };

    private void LoadFragment(Fragment frag) {
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.frame_container, frag);
        trans.addToBackStack(null);
        trans.commit();
    }

}
