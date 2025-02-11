package adventofcode.dayone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InterfaceTest {
  @Test
  void appHasAGreeting() {
    Interface classUnderTest = new Interface();
    assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
  }
}
