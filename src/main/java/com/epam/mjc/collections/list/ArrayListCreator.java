package com.epam.mjc.collections.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCreator {
    public ArrayList<String> createArrayList(List<String> sourceList) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (sourceList.size() > 2) {
            for (int i = 2; i < sourceList.size(); i += 3) {
                arrayList.add(sourceList.get(i));
                arrayList.add(sourceList.get(i));
            }
        }
        return arrayList;
    }
}
