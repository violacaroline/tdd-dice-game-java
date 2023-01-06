package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;
import java.util.Scanner;
import org.junit.jupiter.api.*;
// import org.mockito.Mockito;

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
    String correctInput = "p";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(correctInput.getBytes());

    assertEquals(GameEvent.PLAY, this.userInterface.printMenu(new Scanner(inputStream)));
  }
}
