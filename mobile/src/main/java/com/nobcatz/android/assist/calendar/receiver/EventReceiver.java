package com.nobcatz.android.assist.calendar.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class EventReceiver extends BroadcastReceiver {
    public EventReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("broadcast", "FUNFAAAAAA <3");
    }
}
