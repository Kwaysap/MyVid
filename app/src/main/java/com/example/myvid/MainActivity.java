package com.example.myvid;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TopRightFragment topRightFragment;
    TopLeftFragment topLeftFragment;
    BottomRightFragment bottomRightFragment;
    BottomLeftFragment bottomLeftFragment;
    Button buttonOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextInput = findViewById(R.id.input_left);
                String input = editTextInput.getText().toString();

                TextView displayLeft = findViewById(R.id.display_left);
                displayLeft.setText(input);
            }
        });
    }

    private void init() {
        topRightFragment = new TopRightFragment();
        topLeftFragment = new TopLeftFragment();
        bottomRightFragment = new BottomRightFragment();
        bottomLeftFragment = new BottomLeftFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.top_left_fragment, topLeftFragment)
                .add(R.id.bottom_left_fragment, bottomLeftFragment)
                .add(R.id.top_right_fragment, topRightFragment)
                .add(R.id.bottom_right_fragment, bottomRightFragment)
                .commit();
        buttonOne = findViewById(R.id.left_button);

    }
}
