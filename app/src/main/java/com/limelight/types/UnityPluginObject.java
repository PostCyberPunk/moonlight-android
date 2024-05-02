package com.limelight.types;

import android.app.Activity;

public abstract class UnityPluginObject {
    protected Activity mActivity;

    public UnityPluginObject(Activity a) {
        a = mActivity;
        onCreate();
    }

    protected abstract void onCreate();

    public abstract void onDestroy();

    public abstract void onResume();

    public abstract void onPause();

    public abstract void onStop();

}