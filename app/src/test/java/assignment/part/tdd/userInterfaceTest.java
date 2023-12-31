package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;
import java.util.Scanner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserInterfaceTest {
  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  private final PrintStream originalOutputStream = System.out;
  private UserInterface userInterfaceSUT;

  @BeforeEach
  void setUpOutputStreamAndUserInterface() {
    System.setOut(new PrintStream(outputStream));
    this.userInterfaceSUT = new UserInterface();
  }

  @AfterEach
  void resetOutputStream() {
    System.setOut(originalOutputStream);
  }

  @Test
  void uiShouldPrintWelcomeMessage() {
    this.userInterfaceSUT.printWelcome();

    assertEquals("Welcome!", outputStream.toString().trim());
  }

  @Test
  void uiShouldPrintWinningMessage() {
    this.userInterfaceSUT.printWinningMessage();

    assertEquals("You Won!", outputStream.toString().trim());
  }

  @Test
  void uiShouldPrintYouLostMessage() {
    this.userInterfaceSUT.printLosingMessage();

    assertEquals("You Lost..", outputStream.toString().trim());
  }

  @Test
  void uiPrintMenuShouldReturnGameEventPlayForLetterP() {
    String correctInput = "p";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(correctInput.getBytes());

    assertEquals(GameEvent.PLAY, this.userInterfaceSUT.printMenu(new Scanner(inputStream)));
  }

  @Test
  void uiPrintMenuShouldReturnGameEventQuitForLetterQ() {
    String correctInput = "q";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(correctInput.getBytes());

    assertEquals(GameEvent.QUIT, this.userInterfaceSUT.printMenu(new Scanner(inputStream)));
  }

  @ParameterizedTest
  @ValueSource(strings = {"l", "1", "'", "/<", "something else", "-1"})
  void uiPrintMenuShouldReturnGameEventNothingForAnyOtherLetterThanPorQ(String randomInput) {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(randomInput.getBytes());

    assertEquals(GameEvent.NOTHING, this.userInterfaceSUT.printMenu(new Scanner(inputStream)));
  }

  @Test
  void uiShouldPrintQuitMessage() {
    this.userInterfaceSUT.printQuittingMessage();

    assertEquals("Quitting.. See you next time!", outputStream.toString().trim());
  }
}
