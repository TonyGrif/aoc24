package adventofcode.dayone;

public class Interface {
  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    System.out.println(new Interface().getGreeting());
  }
}
