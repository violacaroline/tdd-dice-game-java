package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;

import org.junit.jupiter.api.*;


public class userInterfaceTest {
  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  private final PrintStream originalOutputStream = System.out;

  @BeforeEach
  void setUpOutputStream() {
    System.setOut(new PrintStream(outputStream));
  }

  @AfterEach
  void resetOutputStream() {
    System.setOut(originalOutputStream);
  }

  @Test
  void uiShouldPrintWelcomeMessage() {
    userInterface.printWelcome();

    assertEquals("Welcome", outputStream.toString());
  }
}
