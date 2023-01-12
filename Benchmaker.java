import java.io.FileWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;

public class Benchmaker {

  /**
   * Runs two different counting methods and tracks the time spent in milliseconds to complete each method.
   * Complexity : O(1)
   * 
   * @param n the number for the range to add all intermediate numbers between
   * @return a formatted string wiht n and the elapsed times
   * @throws NoSuchElementException if the return values for the two comparison methods are different
   */
  public static String compare(long n) throws NoSuchElementException {
    String result = "";
    double bruteTime = 0.0;
    double formulaTime = 0.0;
    try {
      double start = System.currentTimeMillis();
      long sum1 = ComparisonMethods.bruteForce(n);
      double end = System.currentTimeMillis();
      bruteTime = end - start;
      start = System.currentTimeMillis();
      long sum2 = ComparisonMethods.constantTime(n);
      end = System.currentTimeMillis();
      formulaTime = end - start;
      if (sum1 != sum2) 
        throw new Exception("return values of the two comparison methods are different"); 
      result = n + "\t" + bruteTime + "\t" + formulaTime + "\n";
    }
    finally {
    return result;
    }
  }
  
  /**
   * Calls compare(n) using each of an array of values and writes the results to a specified file.
   * Complexity : O(N)
   * 
   * @param f file for result to be recorded
   * @param queryNs input array for n number to be used for compare(n)
   */
  public static void createResultsFile(File f, long[] queryNs) {
    try {
      FileWriter fileWriter = new FileWriter(f); // Creates a Filewriter
      for (int i = 0; i < queryNs.length; i++) {
        fileWriter.write(compare(queryNs[i]));
      }
      fileWriter.close();
    } catch (FileNotFoundException fnf) {
        System.out.println("Exception encountered, unable to complete method.");
    } catch (NoSuchElementException nse) {
      System.out.println("Return values of the two comparison methods are different.");
    } catch (InterruptedIOException iioe) {
      System.out.println("Exception encountered while writing for value N = ");
    } catch (IOException e) {
      System.out.println("Exception encountered whiel closing file.");
    }
  }
  
  public static void main(String[] args) {
    long[] queryNs = new long[] {1,2,3,4,5,6,7};
    //createResultsFile("Output.txt", queryNs);
  }
  
}
