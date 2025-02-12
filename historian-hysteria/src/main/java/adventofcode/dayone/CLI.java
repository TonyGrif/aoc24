package adventofcode.dayone;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CLI {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Input file required for this program");
      System.exit(-1);
    }

    File input = new File(args[0]);
    ArrayList<String> opts = new ArrayList<>(Arrays.asList(args).subList(1, args.length));

    parseCommand(input, opts);
  }

  private static void parseCommand(File input, ArrayList<String> opts) {
    if (opts.contains("--day-two")) {
      // TODO
    }
    dayone(input);
  }

  private static void dayone(File inputFile) {
    System.out.println("Parsing input file...");
    ArrayList<ArrayList<Integer>> columns = Utils.parseFile(inputFile);

    System.out.println("Sorting columns...");
    Collections.sort(columns.get(0));
    Collections.sort(columns.get(1));

    System.out.println("Calculating total distances...");
    System.out.printf(
        "Calculated Total: %s", Utils.countTotalDistance(columns.get(0), columns.get(1)));

    System.exit(0);
  }
}
