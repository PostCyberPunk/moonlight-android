package com.limelight.types;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;

import com.limelight.PluginMain;

import java.io.File;

public abstract class UnityPluginObject {
    protected Activity mActivity;
    protected Intent mIntent;
    protected PluginMain mPluginMain;

    //TODO: why not working?
//    protected UnityPluginObject(Activity activity) {
//        mActivity = activity;
//        this.onCreate();
//    }
//    protected abstract void onCreate();
    protected UnityPluginObject(PluginMain p, Activity a) {
        mPluginMain = p;
        mActivity = a;
    }

    protected UnityPluginObject(PluginMain p, Activity a, Intent i) {
        mPluginMain = p;
        mActivity = a;
        mIntent = i;
    }

    protected abstract void onCreate();

    public abstract void onDestroy();

    public abstract void onResume();

    public abstract void onPause();

    public void onStop() {
    }

    ;

    protected void finish() {
        mPluginMain.DestroyPlugin(this);
    }

    protected Intent getIntent() {
        return mIntent;
    }

    protected SharedPreferences getSharedPreferences(String name, int mode) {
        return mActivity.getSharedPreferences(name, mode);
    }

    protected boolean bindService(Intent intent, ServiceConnection conn, int flags) {
        return mActivity.bindService(intent, conn, flags);
    }

    protected void unbindService(ServiceConnection conn) {
        mActivity.unbindService(conn);
    }

    protected File getCacheDir() {
        return mActivity.getCacheDir();
    }
}