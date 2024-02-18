// Student_usnews.java: sample implementation for Student
// COS 445 HW1, Spring 2018
// Created by Andrew Wonnacott

// import java.util.List;

// public class Student_usnews implements Student {
//   public int[] getApplications(
//       int N,
//       double S,
//       double T,
//       double W,
//       double aptitude,
//       List<Double> schools,
//       List<Double> synergies) {
//     final int[] ret = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//     return ret;
//   }
// }

import java.util.Arrays;
import java.util.List;

public class Student_usnews implements Student {
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
    int numProbAcceptances = 0;
    for (int i = 0; i < synergies.size(); i++) {
      double prob = (synergies.get(i) + aptitude) / (S + W);
      if ((N - (int) prob * N) < 55) {

        preferences[i] = new School(i,
            (synergies.get(i) + schools.get(i)) *
                ((aptitude + synergies.get(i)) / (S + W)));
        numProbAcceptances++;
      } else {
        preferences[i] = new School(i, .1 * (synergies.get(i) + schools.get(i)));
      }
    }
    Arrays.sort(preferences);
    // System.out.println("does this work??");
    if (numProbAcceptances >= 10)
      System.out.println("something is not funky");
    int[] ret = new int[10];
    for (int i = 0; i < 10; i++) {
      ret[i] = preferences[i].index;
    }
    return ret;
  }
  // private class School implements Comparable<School> {
  // public School(int i, double q) {
  // index = i;
  // quality = q;
  // }

  // private int index;
  // private double quality;

  // public int compareTo(School n) { // smaller pairs are higher quality
  // int ret = Double.compare(quality, n.quality);
  // return (ret == 0) ? (Integer.compare(index, n.index)) : ret;
  // }
  // }
  // // if n.quality is less than quality, returns -1
  // // if n.quality is greater than quality, returns 1

  // public int[] getApplications(int N, double S, double T, double W, double
  // aptitude, List<Double> schools,
  // List<Double> synergies) {

  // School[] preferences = new School[schools.size()];
  // for (int i = 0; i < synergies.size(); i++) {
  // double prob = (aptitude + synergies.get(i)) / (S + W);
  // // System.out.println(prob);
  // // if ((N - ((int) prob * N)) > 10) {
  // // preferences[i] = new School(i, 0);
  // // } else {
  // // // ((aptitude + synergies.get(i)) / (S + W)));
  // // System.out.println("actually considering index " + i + " with score " +
  // // synergies.get(i) + schools.get(i));
  // // }
  // // preferences[i] = new School(i, synergies.get(i) + schools.get(i));
  // preferences[i] = new School(i, prob);
  // }
  // Arrays.sort(preferences);

  // int[] ret = new int[10];
  // for (int i = 0; i < 10; i++) {
  // ret[i] = preferences[i].index;
  // }
  // return ret;
  // }

}