package project.social_network.exersices;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));
    }


    public static int totalFruit(int[] fruits) {
        LinkedList<Integer> linkedList = new LinkedList();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        linkedList.add(fruits[0]);
        map.put(fruits[0], 1);
        int size = linkedList.size();
        for (int i = 0, c = i + 1; c < fruits.length; ) {
            if (!map.containsKey(fruits[c]) && map.size() > 1) {
                size = Math.max(size, linkedList.size());
                Integer first =  linkedList.getFirst();
                linkedList.removeFirst();
                i++;
                Integer i1 = map.get(first);
                if (i1 == 1) {
                    map.remove(first);
                } else {
                    map.put(first, i1 - 1);
                }
            } else if (map.containsKey(fruits[c])) {
                linkedList.add(fruits[c]);
                map.compute(fruits[c], (a, b) -> b + 1);
                size = Math.max(linkedList.size(), size);
                c++;
            } else {
                linkedList.add(fruits[c]);
                map.put(fruits[c], 1);
                c++;
                size = Math.max(linkedList.size(), size);
            }
        }
        return size;
    }

}
