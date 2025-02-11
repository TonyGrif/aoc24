package adventofcode.dayone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestUtils {
  private static Utils utilities;

  @BeforeAll
  static void utils() {
    utilities = new Utils();
  }

  @Test
  void testParseFile() {
    File file = new File(System.getProperty("user.dir") + "/" + "src/test/resources/sample.txt");
    ArrayList<ArrayList<Integer>> columns = utilities.parseFile(file);
    assertEquals(2, columns.size());
    assertEquals(10, columns.get(0).size(), columns.get(0).toString());
  }
}
