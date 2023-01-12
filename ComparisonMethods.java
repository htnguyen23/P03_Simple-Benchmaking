//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ComparisonMethods.java
// Course:   CS 300 Fall 2020
//
// Author:   Huong Nguyen
// Email:    htnguyen23@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         none
// Online Sources:  none
//
///////////////////////////////////////////////////////////////////////////////

public class ComparisonMethods {
  
  /**
   * Calculates and returns the sum of all integers 1 to n.
   * Complexity : O(N)
   * 
   * @param n the number for the range to add all intermediate numbers between
   * @return the sum of 1 to n
   */
  public static long bruteForce(long n) {
    long sum = 0;
    for (long i = 0; i <= n; i++) {
      sum = sum + i;
    }
    return sum;
  }
  
  /**
   * Calculates and returns the sum of all integers 1 to n.
   * Complexity : O(1)
   * 
   * @param n the number for the range to add all intermediate numbers between
   * @return the sum of 1 to n
   */
  public static long constantTime(long n) {
    long sum = 0;
    sum = n*(1+n)/2;
    return sum;
  }
  
  /**
   * Checks whether removeIndividual() works as expected
   * Complexity : O(1)
   * 
   * @return true if method functionality is verified, false otherwise
   */
  public static boolean testBruteForce() {
    int n = 10;
    int expected = 55;
    if (bruteForce(n) != expected) {
      return false;
    }
    return true;
  }
  
  /**
   * Checks whether constantTime() works as expected
   * Complexity : O(1)
   * 
   * @return true if method functionality is verified, false otherwise
   */
  public static boolean testConstantTime() {
    int n = 10;
    int expected = 55;
    if (constantTime(n) != expected) {
      //System.out.println(constantTime(n));
      return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    if (!testBruteForce())
      System.out.println("testBruteForce() failed");
    if (!testConstantTime()) 
      System.out.println("testConstantTime() failed");
  }
}
