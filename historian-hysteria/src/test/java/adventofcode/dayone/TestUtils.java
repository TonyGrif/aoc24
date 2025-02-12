package adventofcode.dayone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestUtils {
  private static File testFile;

  @BeforeAll
  static void setup() {
    testFile = new File("src/test/resources/sample.txt");
  }

  @Test
  void testParseFile() {
    ArrayList<ArrayList<Integer>> columns = Utils.parseFile(testFile);
    assertEquals(2, columns.size());
    assertEquals(10, columns.get(0).size(), columns.get(0).toString());
    assertEquals(columns.get(0).size(), columns.get(1).size());
  }

  @Test
  void testCountTotalDistance() {
    ArrayList<ArrayList<Integer>> columns = Utils.parseFile(testFile);
    assertEquals(244216, Utils.countTotalDistance(columns.get(0), columns.get(1)));
  }

  @Test
  void testCalcSimilarityScore() {
    ArrayList<ArrayList<Integer>> columns = Utils.parseFile(testFile);
    assertEquals(0, Utils.calculateSimilarityScore(columns.get(0), columns.get(1)));
  }
}
