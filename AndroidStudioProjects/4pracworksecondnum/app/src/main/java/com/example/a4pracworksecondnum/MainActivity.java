package com.example.a4pracworksecondnum;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);  // Add this line

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragment1();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragment2();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {  // Add this block
            @Override
            public void onClick(View v) {
                displayFragment3();
            }
        });
    }

    public void displayFragment1() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new BlankFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void displayFragment2() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new BlankFragment2());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void displayFragment3() {  // Add this method
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new BlankFragment3());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
