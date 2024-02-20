import java.util.List;
import java.util.Arrays;

public class Student_SepWeight5 implements Student {
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
        for (int i = 0; i < synergies.size(); i++) {
            preferences[i] = new School(i,
                    ((T / (T + W)) * synergies.get(i) + (W / (W + T)) * schools.get(i)) *
                            ((aptitude / S) * (S / (S + W)) + (W / (W + S)) * (synergies.get(i) / W)));
        }
        Arrays.sort(preferences);
        int[] ret = new int[10];
        for (int i = 0; i < 10; i++) {
            ret[i] = preferences[i].index;
        }
        return ret;
    }
}