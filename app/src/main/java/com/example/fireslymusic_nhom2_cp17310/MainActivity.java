package com.example.fireslymusic_nhom2_cp17310;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.fireslymusic_nhom2_cp17310.Fragment.HomeFragment;
import com.example.fireslymusic_nhom2_cp17310.Fragment.LiberyFragment;
import com.example.fireslymusic_nhom2_cp17310.Fragment.ProfileFragment;
import com.example.fireslymusic_nhom2_cp17310.Fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        replaceFragment(new HomeFragment());
        bottomNavigationView.setOnItemSelectedListener(item -> {
           switch (item.getItemId()){
               case R.id.home :
                   replaceFragment(new HomeFragment());
                   break;
               case R.id.search:
                   replaceFragment(new SearchFragment());
                   break;
               case R.id.libery:
                   replaceFragment(new LiberyFragment());
                   break;
               case R.id.pers:
                   replaceFragment(new ProfileFragment());
                   break;
           }
           return true;
        });

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framechinh,fragment);
        fragmentTransaction.commit();
    }
}