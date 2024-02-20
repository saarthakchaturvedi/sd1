import java.util.Arrays;
import java.util.List;

public class Student_SepWeight2 implements Student {
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
            // if (W < 10) {
            // preferences[i] = new School(i,
            // (synergies.get(i) + schools.get(i)) *
            // (aptitude / S));
            // } else {
            preferences[i] = new School(i,
                    ((T / W) * synergies.get(i) + schools.get(i)) *
                            ((aptitude / S) * (S / W) + (synergies.get(i) / W)));
            // }
        }
        Arrays.sort(preferences);
        // for (School s: preferences) {
        // System.out.println("school: " + s.index + ", quality: " + s.quality);
        //
        int[] ret = new int[10];
        for (int i = 0; i < 10; i++) {
            ret[i] = preferences[i].index;
        }
        return ret;
    }
}
