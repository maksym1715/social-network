package project.social_network.exersices;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NextClosestTime {

    public static void main(String[] args) {

    }


    public String nextClosestTime(String time) {
        String[] split = time.split(":");
        String hour = split[0];
        String minute = split[1];
        Integer firstHourInteger = Integer.parseInt(hour) / 10;
        Integer secondHourInteger = Integer.parseInt(hour) % 10;

        Integer firstMinInteger = Integer.parseInt(minute) / 10;
        Integer secondMinInteger = Integer.parseInt(minute) % 10;
        Set<Integer> set = new HashSet<>();
        set.add(firstHourInteger);
        set.add(secondHourInteger);
        set.add(firstMinInteger);
        set.add(secondMinInteger);

        int firstHourIntegerForLoop = firstHourInteger;
        int secondHourIntegerForLoop = secondHourInteger;
        int firstMinIntegerForLoop = firstMinInteger;
        int secondMinIntegerForLoop = secondMinInteger;

        while (true) {
            if (set.contains(firstHourInteger) && set.contains(secondHourInteger) && set.contains(firstMinInteger) && set.contains(secondMinIntegerForLoop)) {
                return String.valueOf(firstHourIntegerForLoop) + String.valueOf(secondHourIntegerForLoop) +":"+ String.valueOf(firstMinIntegerForLoop) + String.valueOf(secondMinIntegerForLoop);
            }
            secondMinIntegerForLoop = secondMinIntegerForLoop + 1;
            if (secondMinIntegerForLoop == 10) {
                secondMinIntegerForLoop = 0;
                firstMinIntegerForLoop = firstMinIntegerForLoop + 1;
            }
            int i = (firstMinIntegerForLoop * 10 + secondMinIntegerForLoop);
            firstHourIntegerForLoop = i / 10;

            if (firstMinIntegerForLoop * 10 + secondMinIntegerForLoop == 59) {
                firstMinIntegerForLoop = 0;
                secondMinIntegerForLoop = 0;
                secondHourIntegerForLoop = secondHourInteger + 1;
                firstHourIntegerForLoop = firstMinInteger / 10;
            }

            if (firstHourIntegerForLoop * 10 + secondHourIntegerForLoop > 24) {
                firstHourIntegerForLoop = 0;
                secondHourIntegerForLoop = 0;
            }
        }

    }

}
