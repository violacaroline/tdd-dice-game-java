package assignment.part.tdd;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class PlayerTest {
  @Test
  void playGameMethodShouldCallUiWelcomeMethodOnce() {
    UserInterface ui = mock(UserInterface.class);
    DiceGame diceGame = mock(DiceGame.class);

    Player playerSUT = new Player();

    playerSUT.playGame(ui, diceGame);

    verify(ui, times(1)).printWelcome();
  }

  // VERIFY THAT UI.PRINTMENU IS CALLED
  @Test
  void playGameMethodShouldCallUiPrintMenuMethodAtLeastOnce(){
    Scanner scan = new Scanner(System.in, "utf-8");
    UserInterface ui = mock(UserInterface.class);
    DiceGame diceGame = mock(DiceGame.class);
    Player playerSUT = new Player();
    
    playerSUT.playGame(ui, diceGame);

    verify(ui, atLeastOnce()).printMenu(scan);
  }

  // VERIFY THAT DICEGAME.PLAYGAME IS CALLED WHILE UI.PRINTMENU DOES NOT RETURN QUIT

  // IF DICEGAME.PLAYGAME RETURNS TRUE, CALL UI.PRINTWINNINGMSG

  //IF DICEGAME.PLAYGAME FALSE, CALL UI.PRINTLOSINGMSG
}
