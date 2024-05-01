package com.limelight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PcList {
    private final ArrayList<PcPlugin.ComputerObject> itemList = new ArrayList<>();
    public void addComputer(PcPlugin.ComputerObject computer) {
        itemList.add(computer);
        sortList();
    }

    private void sortList() {
        Collections.sort(itemList, new Comparator<PcPlugin.ComputerObject>() {
            @Override
            public int compare(PcPlugin.ComputerObject lhs, PcPlugin.ComputerObject rhs) {
                return lhs.details.name.toLowerCase().compareTo(rhs.details.name.toLowerCase());
            }
        });
    }

    public boolean removeComputer(PcPlugin.ComputerObject computer) {
        return itemList.remove(computer);
    }

    public Object getItem(int i) {
        return itemList.get(i);
    }

    public int getCount() {
        return itemList.size();
    }
}
