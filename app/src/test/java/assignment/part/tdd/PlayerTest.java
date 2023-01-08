package assignment.part.tdd;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
  private Scanner scan;
  private UserInterface ui;
  private DiceGame diceGame;

  @BeforeEach
  void setUpMocksAndScanner() {
    this.scan = new Scanner(System.in, "utf-8");
    this.ui = mock(UserInterface.class);
    this.diceGame = mock(DiceGame.class);
  }

  @Test
  void playGameMethodShouldCallUiWelcomeMethodOnce() {
    Player playerSUT = new Player();

    playerSUT.playGame(ui, scan, diceGame);

    verify(ui, times(1)).printWelcome();
  }

  @Test
  void playGameMethodShouldCallUiPrintMenuMethodAtLeastOnce() {
    Player playerSUT = new Player();
    
    playerSUT.playGame(ui, scan, diceGame);

    verify(ui, atLeastOnce()).printMenu(scan);
  }

  @Test
  void playGameMethodShouldCallUiQuittingMethodWhenPrintMenuReturnsGameEventQuit() {
    Player playerSUT = new Player();

    when(ui.printMenu(scan)).thenReturn(GameEvent.QUIT);

    playerSUT.playGame(ui, scan, diceGame);

    verify(ui, times(1)).printQuittingMessage();
  }

  // VERIFY THAT DICEGAME.PLAYGAME IS CALLED WHILE UI.PRINTMENU DOES NOT RETURN QUIT

  // IF DICEGAME.PLAYGAME RETURNS TRUE, CALL UI.PRINTWINNINGMSG

  //IF DICEGAME.PLAYGAME FALSE, CALL UI.PRINTLOSINGMSG
}
