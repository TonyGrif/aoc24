package adventofcode.dayone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

/** Utilities class containing functions required for historian-hysteria */
public class Utils {
  /**
   * Parse a text file for column integer data
   *
   * @param file The text file to parse
   * @return A list containing all the column data contained within their own list
   */
  public static ArrayList<ArrayList<Integer>> parseFile(File file) {
    try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
      ArrayList<Integer> columnOne = new ArrayList<>();
      ArrayList<Integer> columnTwo = new ArrayList<>();

      String line = reader.readLine();
      while (line != null) {
        String[] nums = line.split("\\s+");
        columnOne.add(Integer.parseInt(nums[0]));
        columnTwo.add(Integer.parseInt(nums[1]));

        line = reader.readLine();
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

  /**
   * Calculate the distance between all elements of two lists
   *
   * @param listOne The first list
   * @param listTwo The second list
   * @return The distances between all elements
   */
  public static Integer countTotalDistance(ArrayList<Integer> listOne, ArrayList<Integer> listTwo) {
    AtomicReference<Integer> count = new AtomicReference<>(0);

    IntStream.range(0, listOne.size())
        .forEach(
            index ->
                count.updateAndGet(v -> v + Math.abs(listOne.get(index) - listTwo.get(index))));

    return count.get();
  }

  /**
   * Calculate the 'similarity score' for the two lists
   *
   * @param listOne List containing the main numbers
   * @param listTwo List containing numbers for frequency
   * @return The similarity score of the two lists
   */
  public static Integer calculateSimilarityScore(
      ArrayList<Integer> listOne, ArrayList<Integer> listTwo) {
    AtomicReference<Integer> count = new AtomicReference<>(0);

    for (Integer val : listOne) {
      count.updateAndGet(v -> v + (val * Collections.frequency(listTwo, val)));
    }

    return count.get();
  }
}
