
// Student_random.java: sample implementation for Student
// COS 445 HW1, Spring 2018
// Created by Andrew Wonnacott

import java.util.Arrays;
import java.util.List;

public class Student_random2 implements Student {
    private class School implements Comparable<School> {
        public School(int i, double q) {
            index = i;
            quality = q;
        }

        private int index;
        private double quality;

        public int compareTo(School n) { // smaller pairs are higher quality
            int ret = Double.compare(n.quality, quality);
            return (ret == 0) ? (Integer.compare(index, n.index)) : ret;
        }
    }
    // if n.quality is less than quality, returns -1
    // if n.quality is greater than quality, returns 1

    public int[] getApplications(int N, double S, double T, double W, double aptitude, List<Double> schools,
            List<Double> synergies) {

        School[] preferences = new School[schools.size()];
        for (int i = 0; i < synergies.size(); i++) {
            preferences[i] = new School(i,
                    (synergies.get(i) + schools.get(i)) *
                            ((aptitude + synergies.get(i)) / (S + W)));
        }
        Arrays.sort(preferences);
        // for (School s : preferences) {
        // System.out.println("quality: " + s.quality + ", index: " + s.index);
        // }
        // System.out.println("does this work??");
        int[] ret = new int[10];
        for (int i = 0; i < 10; i++) {
            ret[i] = preferences[i].index;
            // System.out
            // .println("applying to school with quality " + preferences[i].quality + ", at
            // index " + preferences[i].index);
        }
        return ret;
    }
}
