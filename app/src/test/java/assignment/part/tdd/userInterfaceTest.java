package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;
import java.awt.*;
import java.awt.event.KeyEvent;

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
    this.userInterface.printWelcome();

    assertEquals("Welcome!", outputStream.toString().trim());
  }

  @Test
  void uiShouldPrintWinningMessage() {
    this.userInterface.printWinningMessage();

    assertEquals("You Won!", outputStream.toString().trim());
  }

  @Test
  void uiShouldPrintYouLostMessage() {
    this.userInterface.printLosingMessage();

    assertEquals("You Lost..", outputStream.toString().trim());
  }

  @Test 
  void uiPrintMenuShouldReturnGameEventPlayForLetterP() {
    Robot robot = new Robot();
    
    this.userInterface.printMenu();
    robot.keyPress(KeyEvent.VK_P);
  }
}
