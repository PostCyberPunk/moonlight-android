package com.limelight;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.limelight.types.UnityPluginObject;

import java.util.ArrayList;
import java.util.List;

public class PluginMain extends Activity {
    private AppPlugin m_AppPlugin;
    private PcPlugin m_PcPlugin;
    private final List<UnityPluginObject> m_PluginList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TRY
        Activity mActivity = this;
        m_PcPlugin = new PcPlugin(mActivity);
        m_PluginList.add(m_PcPlugin);
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
}
