package com.example.myvid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class TopRightFragment extends Fragment {
    @Nullable
    @Override
    // Fragment Shit
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.top_right_fragment, container, false);
        return view;
    }

    // The Display fragment registers with the EventBus to receive messages
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    // When the display fragment receives a message it extracts it from the MessageEvent
    // and displays it in its textview
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        // Extracts message from the Message Event
        String input = event.message;
        // Finds TextView
        TextView tvDisplay = getView().findViewById(R.id.display_right);
        // Displays message from the MessageEvent into it's own textview
        tvDisplay.setText(input);
    }
}
