package com.epam.mjc.collections.list;

import java.util.*;

public class ListSorter {
    public void sort(List<String> sourceList) {
        List<Integer> integerList = new ArrayList<>();
        int index = 0;
        int valueForList;
        while (!sourceList.isEmpty()) {
            if (sourceList.size() == 1) {
                integerList.add(Integer.parseInt(sourceList.get(0)));
                sourceList.remove(0);
                break;
            }
            valueForList = new ListComparator().compare(sourceList.get(0), sourceList.get(1));
            for (int j = 2; j < sourceList.size(); j++) {
                if (Math.abs(valueForList) > Math.abs(Integer.parseInt(sourceList.get(j)))) {
                    index = sourceList.indexOf(sourceList.get(j));
                    valueForList = Integer.parseInt(sourceList.get(j));

                } else if (j + 1 == sourceList.size() && valueForList == 0 && index == 0) {
                    valueForList = Integer.parseInt(sourceList.get(0));

                } else if (Math.abs(valueForList) == Math.abs(Integer.parseInt(sourceList.get(j)))) {
                    valueForList = new ListComparator().compare(Integer.toString(valueForList), sourceList.get(j));
                    index = sourceList.indexOf(Integer.toString(valueForList));
                } else {
                    index = sourceList.indexOf(Integer.toString(valueForList));
                }
            }
            integerList.add(valueForList);
            sourceList.remove(index);
            index = 0;
        }

        List<String> stringList = new ArrayList<>();
        for (Integer integer : integerList) {
            stringList.add(Integer.toString(integer));
        }
        System.out.println(stringList);
    }

    public static void main(String[] args) {
        ListSorter sorter = new ListSorter();
        List<String> list1 = new ArrayList<>(List.of("7", "10", "6", "-7", "-2", "0", "-2", "-23"));
        List<String> list = new ArrayList<>(List.of("-5", "-12", "0", "20", "9", "-20", "37"));
        sorter.sort(list);
        sorter.sort(list1);
    }
}

class ListComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        if (Math.abs(x) == Math.abs(y))
            return Math.min(x, y);
        else if (Math.abs(x) > Math.abs(y))
            return y;
        else
            return x;
    }
}
