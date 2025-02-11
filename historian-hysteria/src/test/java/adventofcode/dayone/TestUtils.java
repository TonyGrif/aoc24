package adventofcode.dayone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class TestUtils {
  @Test
  void testParseFile() {
    File file = new File("src/test/resources/sample.txt");
    ArrayList<ArrayList<Integer>> columns = Utils.parseFile(file);
    assertEquals(2, columns.size());
    assertEquals(10, columns.get(0).size(), columns.get(0).toString());
    assertEquals(columns.get(0).size(), columns.get(1).size());
  }
}
