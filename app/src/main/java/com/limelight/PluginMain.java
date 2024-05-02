package com.limelight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.limelight.types.UnityPluginObject;

import java.util.ArrayList;
import java.util.List;

public class PluginMain extends Activity {
    private AppPlugin m_AppPlugin;
    private PcPlugin m_PcPlugin;
    private final List<UnityPluginObject> m_PluginList = new ArrayList<>();
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TRY
        mActivity = this;

        PreferenceManager.setDefaultValues(mActivity, R.xml.preferences, false);
        ActivatePcPlugin();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (UnityPluginObject plugin : m_PluginList) {
            if (plugin != null)
                plugin.onDestroy();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (UnityPluginObject plugin : m_PluginList) {
            if (plugin != null)
                plugin.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        for (UnityPluginObject plugin : m_PluginList) {
            if (plugin != null)
                plugin.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        for (UnityPluginObject plugin : m_PluginList) {
            if (plugin != null)
                plugin.onStop();
        }
    }

    public void ActivatePcPlugin() {
        LimeLog.info("PcPlugin starting");
        m_PcPlugin = new PcPlugin(this, mActivity);
        m_PluginList.add(m_PcPlugin);
    }

    public void StopPcPlugin() {
        if (m_PcPlugin == null)
            return;
        m_PluginList.remove(m_PcPlugin);
        m_PcPlugin.onDestroy();
        m_PcPlugin = null;
        LimeLog.info("PcPlugin stopped");
    }

    public void ActivateAppPlugin(Intent i) {
        LimeLog.info("AppPlugin starting");
        m_AppPlugin = new AppPlugin(this, mActivity, i);
        m_PluginList.add(m_AppPlugin);
    }

    public void StopAppPlugin() {
        if (m_AppPlugin == null)
            return;
        m_PluginList.remove(m_AppPlugin);
        m_AppPlugin.onDestroy();
        m_AppPlugin = null;
        LimeLog.info("AppPlugin stopped");
    }

    public void DestroyPlugin(UnityPluginObject plugin) {
        if (plugin == null)
            return;
        //call stop method base on the plugin types
        if (plugin instanceof AppPlugin) { StopAppPlugin();
        } else if (plugin instanceof PcPlugin) {
            StopPcPlugin();
        }
    }
}
