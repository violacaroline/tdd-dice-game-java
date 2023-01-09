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
  private Player playerSUT;
  private UserInterface ui;
  private DiceGame diceGame;

  @BeforeEach
  void setUpMocksAndScanner() {
    this.scan = new Scanner(System.in, "utf-8");
    this.ui = mock(UserInterface.class);
    this.diceGame = mock(DiceGame.class);
    this.playerSUT = new Player(ui, scan, diceGame);
  }

  @Test
  void playGameMethodShouldCallUiWelcomeMethodOnce() {
    when(this.ui.printMenu(scan)).thenReturn(GameEvent.QUIT);

    this.playerSUT.playGame();

    verify(this.ui, times(1)).printWelcome();
  }

  @Test
  void playGameMethodShouldCallUiPrintMenuMethodAtLeastOnce() {
    when(this.ui.printMenu(scan)).thenReturn(GameEvent.QUIT);
  
    this.playerSUT.playGame();

    verify(this.ui, atLeastOnce()).printMenu(scan);
  }

  @Test
  void playGameMethodShouldCallUiQuittingMethodWhenPrintMenuReturnsGameEventQuit() {
    when(this.ui.printMenu(scan)).thenReturn(GameEvent.QUIT);

    this.playerSUT.playGame();

    verify(this.ui, times(1)).printQuittingMessage();
  }

  // VERIFY THAT DICEGAME.PLAYGAME IS CALLED WHILE UI.PRINTMENU RETURNS PLAY
  @Test
  void playGameMethodShouldCallDiceGamePlayGameWhenPrintMenuReturnsGameEventPlay() {
    when(this.ui.printMenu(scan)).thenReturn(GameEvent.PLAY);
    when(this.ui.printMenu(scan)).thenReturn(GameEvent.QUIT);


    this.playerSUT.playGame();

    verify(this.diceGame, atLeastOnce()).playGame();
  }

  // IF DICEGAME.PLAYGAME RETURNS TRUE, CALL UI.PRINTWINNINGMSG
  @Test
  void playGameMethodShouldCallUiPrintWinningMessageWhenDiceGamePlayGameReturnsTrue() {
    when(this.ui.printMenu(scan)).thenReturn(GameEvent.PLAY);
    when(this.diceGame.playGame()).thenReturn(true);
    when(this.ui.printMenu(scan)).thenReturn(GameEvent.QUIT);


    this.playerSUT.playGame();

    verify(this.ui, times(1)).printWinningMessage();
  }

  //IF DICEGAME.PLAYGAME FALSE, CALL UI.PRINTLOSINGMSG
}
