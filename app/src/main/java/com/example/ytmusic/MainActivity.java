package com.example.ytmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ytmusic.databinding.MainActivityBinding;
import com.example.ytmusic.ui.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}