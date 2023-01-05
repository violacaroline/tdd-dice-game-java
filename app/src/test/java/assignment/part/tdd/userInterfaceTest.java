package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;

import org.junit.jupiter.api.*;


public class UserInterfaceTest {
  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  private final PrintStream originalOutputStream = System.out;
  private UserInterface userInterface;

  @BeforeEach
  void setUpOutputStreamAndUserInterface() {
    System.setOut(new PrintStream(outputStream));
    this.userInterface = new UserInterface();
  }

  @AfterEach
  void resetOutputStream() {
    System.setOut(originalOutputStream);
  }

  @Test
  void uiShouldPrintWelcomeMessage() {
    userInterface.printWelcome();

    assertEquals("Welcome!", outputStream.toString().trim());
  }

  @Test
  void uiShouldPrintWinningMessage() {
    userInterface.printWinningMessage();

    assertEquals("You Won!", outputStream.toString().trim());
  }
}
