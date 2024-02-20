import java.util.Arrays;
import java.util.List;

public class Student_PCT implements Student {
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

            preferences[i] = new School(i, schools.get(i));

        }
        Arrays.sort(preferences);
        // for (School s: preferences) {
        // System.out.println("school: " + s.index + ", quality: " + s.quality);
        // }
        int rank = N- ((int) ((aptitude/S)*N));
        if (rank < 10) {
            int []ret2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            return ret2;
        }
        int[] ret = new int[10];
        for (int i = 0; i < 10; i++) {
            ret[i] = preferences[rank-i].index;
        }
        return ret;
    }
}
