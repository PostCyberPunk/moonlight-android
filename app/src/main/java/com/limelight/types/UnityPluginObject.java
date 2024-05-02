package com.limelight.types;

import android.app.Activity;

public abstract class UnityPluginObject {
    protected Activity mActivity;
    //TODO: why not working?
//    protected UnityPluginObject(Activity activity) {
//        mActivity = activity;
//        this.onCreate();
//    }
//    protected abstract void onCreate();
    protected UnityPluginObject(Activity activity) {
        mActivity = activity;
    }
    protected abstract void onCreate();
    public abstract void onDestroy();
    public abstract void onResume();
    public abstract void onPause();
    public abstract void onStop();

}