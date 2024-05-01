package com.limelight;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.limelight.nvstream.http.ComputerDetails;
import com.limelight.nvstream.http.PairingManager;
import com.limelight.preferences.PreferenceConfiguration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PcList {
    private final ArrayList<DumbActivity.ComputerObject> itemList = new ArrayList<>();
    public void addComputer(DumbActivity.ComputerObject computer) {
        itemList.add(computer);
        sortList();
    }

    private void sortList() {
        Collections.sort(itemList, new Comparator<DumbActivity.ComputerObject>() {
            @Override
            public int compare(DumbActivity.ComputerObject lhs, DumbActivity.ComputerObject rhs) {
                return lhs.details.name.toLowerCase().compareTo(rhs.details.name.toLowerCase());
            }
        });
    }

    public boolean removeComputer(DumbActivity.ComputerObject computer) {
        return itemList.remove(computer);
    }

    public Object getItem(int i) {
        return itemList.get(i);
    }

    public int getCount() {
        return itemList.size();
    }
}
