package adventofcode.dayone;

import java.io.File;
import java.util.ArrayList;

public class CLI {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Input file required for this program");
      System.exit(-1);
    }

    ArrayList<ArrayList<Integer>> columns = Utils.parseFile(new File(args[0]));
    System.out.println(columns);
  }
}
