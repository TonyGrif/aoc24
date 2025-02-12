package adventofcode.dayone;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class CLI {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Input file required for this program");
      System.exit(-1);
    }

    System.out.println("Parsing input file...");
    ArrayList<ArrayList<Integer>> columns = Utils.parseFile(new File(args[0]));

    System.out.println("Sorting columns...");
    Collections.sort(columns.get(0));
    Collections.sort(columns.get(1));

    System.out.println("Calculating total distances...");
    System.out.printf("Calculated Total: %s", Utils.countTotalDistance(columns.get(0), columns.get(1)));
  }
}
