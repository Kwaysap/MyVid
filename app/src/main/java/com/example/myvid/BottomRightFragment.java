package com.example.myvid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class BottomRightFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.bottom_right_fragment, container, false);
        // OnClickListener which waits for the user to click on the EditText
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextInput = v.findViewById(R.id.input_right);
                String input = editTextInput.getText().toString();
                // Once the user clicks on the EditText, it sends the message to
                // the other fragment using EventBus
                EventBus.getDefault().post(new MessageEvent(input));

            }
        });
        return view;
    }


}
