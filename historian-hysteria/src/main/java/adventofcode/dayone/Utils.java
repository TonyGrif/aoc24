package adventofcode.dayone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/** Utilities class containing functions required for historian-hysteria */
public class Utils {
  /**
   * Parse a text file for column integer data
   *
   * @param file The text file to parse
   * @return A list containing all the column data contained within their own list
   */
  public ArrayList<ArrayList<Integer>> parseFile(File file) {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      ArrayList<Integer> columnOne = new ArrayList<>();
      ArrayList<Integer> columnTwo = new ArrayList<>();

      String line;
      while ((line = reader.readLine()) != null) {
        String[] nums = line.split("\\s+");
        columnOne.add(Integer.parseInt(nums[0]));
        columnTwo.add(Integer.parseInt(nums[1]));
      }
      return new ArrayList<>() {
        {
          add(columnOne);
          add(columnTwo);
        }
      };
    } catch (IOException e) {
      System.err.println(e.getMessage());
      return new ArrayList<>();
    }
  }
}
