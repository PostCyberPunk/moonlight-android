package com.limelight.grid;

import com.limelight.AppPlugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppList {
    private ArrayList<AppPlugin.AppObject> allApps = new ArrayList<>();
    private static void sortList(List<AppPlugin.AppObject> list) {
        Collections.sort(list, new Comparator<AppPlugin.AppObject>() {
            @Override
            public int compare(AppPlugin.AppObject lhs, AppPlugin.AppObject rhs) {
                return lhs.app.getAppName().toLowerCase().compareTo(rhs.app.getAppName().toLowerCase());
            }
        });
    }

    public void addApp(AppPlugin.AppObject app) {
        // Always add the app to the all apps list
        allApps.add(app);
        sortList(allApps);
    }

    public void removeApp(AppPlugin.AppObject app) {
        allApps.remove(app);
    }

    public Object getItem(int position) {
        return allApps.get(position);
    }

    public int getCount() {
        return allApps.size();
    }
}
