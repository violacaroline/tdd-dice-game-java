package assignment.part.tdd;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class PlayerTest {
  @Test
  void playGameMethodShouldCallUiWelcomeMethodOnce() {
    UserInterface ui = mock(UserInterface.class);
    DiceGame diceGame = mock(DiceGame.class);

    Player playerSUT = new Player(ui, diceGame);

    playerSUT.playGame();

    verify(ui, times(1)).printWelcome();
  }
}
