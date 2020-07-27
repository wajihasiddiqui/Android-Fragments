package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Button btn;
    FrameLayout frameLayout;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        frameLayout = findViewById(R.id.frame);
        tabLayout = findViewById(R.id.tablayout);

        tabLayout.addTab(tabLayout.newTab().setText("CHAT"));
        tabLayout.addTab(tabLayout.newTab().setText("STATUS"));
        tabLayout.addTab(tabLayout.newTab().setText("CALLS"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getText().toString()){

                    case "CHAT":
                        getSupportFragmentManager().beginTransaction().add(R.id.frame, new chat()).commit();
                        break;

                    case "STATUS":
                        getSupportFragmentManager().beginTransaction().add(R.id.frame, new calls()).commit();
                        break;

                    case "CALLS":
                        getSupportFragmentManager().beginTransaction().add(R.id.frame, new status()).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager().beginTransaction().add(R.id.frame, new myfragment()).commit();
            }
        });
    }
}