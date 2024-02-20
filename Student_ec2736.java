import java.util.List;
import java.util.Arrays;

public class Student_ec2736 implements Student {
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

        // TODO
        // doesn't take into account N, T, or the relative size of S/W and W/T
        // does take into account aptitude + synergy relative to other applicants for
        // each university.
        double[] lambda = { .5, 1, 2, 4, 8 };
        for (int i = 0; i < synergies.size(); i++) {
            double prob = ((aptitude + synergies.get(i)) / (W + S));
            if (prob < .2)
                prob *= lambda[0];
            else if (prob < .4)
                prob *= lambda[1];
            else if (prob < .6)
                prob *= lambda[2];
            else if (prob < .8)
                prob *= lambda[3];
            else
                prob *= lambda[4];
            preferences[i] = new School(i,
                    (prob) * (schools.get(i) + synergies.get(i)));
        }
        Arrays.sort(preferences);
        int[] ret = new int[10];
        for (int i = 0; i < 10; i++) {
            ret[i] = preferences[i].index;
        }
        return ret;
    }
    // public int[] getApplications(int N, double S, double T, double W, double
    // aptitude, List<Double> schools,
    // List<Double> synergies) {

    // School[] preferences = new School[schools.size()];
    // for (int i = 0; i < synergies.size(); i++) {
    // if (W < 10) {
    // preferences[i] = new School(i,
    // (synergies.get(i) + schools.get(i)) *
    // (aptitude / S));
    // } else {
    // preferences[i] = new School(i,
    // (synergies.get(i) + schools.get(i)) *
    // (aptitude / S + synergies.get(i) / W));
    // }
    // }
    // Arrays.sort(preferences);
    // // for (School s: preferences) {
    // // System.out.println("school: " + s.index + ", quality: " + s.quality);
    // // }
    // int[] ret = new int[10];
    // for (int i = 0; i < 10; i++) {
    // ret[i] = preferences[i].index;
    // }
    // return ret;
    // }
}

// Part B
// public int[] getApplications(int N, double S, double T, double W, double
// aptitude, List<Double> schools,
// List<Double> synergies) {
// School[] preferences = new School[schools.size()];
// for (int i = 0; i < synergies.size(); i++) {
// preferences[i] = new School(i, schools.get(i));
// }
// // lower indices = higher quality schools
// Arrays.sort(preferences);
// int rank = (int) ((aptitude / S) * N);
// int[] ret = new int[10];
// // if (N - rank < 10) {
// // // int[] ret2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
// // int[] ret2 = { N - 9, N - 8, N - 7, N - 6, N - 5, N - 4, N - 3, N - 2, N -
// 1
// // };
// // return ret2;
// // }
// if (N - rank < 10) {
// int[] ret2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
// return ret2;

// }
// ret[0] = preferences[N - rank].index;
// for (int i = 1; i < 10; i++) {
// ret[i] = i;
// }
// // for (int i = 0; i < 10; i++) {
// // ret[i] = preferences[N - rank].index;
// // }
// return ret;
// }
