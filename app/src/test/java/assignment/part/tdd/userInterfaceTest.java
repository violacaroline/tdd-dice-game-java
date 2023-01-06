package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;
import java.util.Scanner;
import org.junit.jupiter.api.*;
// import org.mockito.Mockito;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

  @Test
  void uiPrintMenuShouldReturnGameEventQuitForLetterQ() {
    String correctInput = "q";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(correctInput.getBytes());

    assertEquals(GameEvent.QUIT, this.userInterface.printMenu(new Scanner(inputStream)));
  }

  @ParameterizedTest
  @ValueSource(strings = {"l", "1", "'", "/<", "something else", "-1"})
  void uiPrintMenuShouldReturnGameEventNothingForAnyOtherLetterThanPorQ(String randomInput) {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(randomInput.getBytes());

    assertEquals(GameEvent.NOTHING, this.userInterface.printMenu(new Scanner(inputStream)));
  }
}
