package assignment.part.tdd;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class DiceGameTest {
  @Test
  void playGameMethodShouldReturnTrueForTotalValue7() {
    DiceGame diceGame = new DiceGame();

    Die dieMockOne = mock(Die.class);
    Die dieMockTwo = mock(Die.class);

    when(dieMockOne.rollDie()).thenReturn(3);
    when(dieMockTwo.rollDie()).thenReturn(4);

    assertTrue(diceGame.playGame());
  }
}
