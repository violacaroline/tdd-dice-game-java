package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class DiceGameTest {
  @Test
  void playGameMethodShouldReturnTrueForTotalValue7() {
    Die dieMockOne = mock(Die.class);
    Die dieMockTwo = mock(Die.class);
    DiceGame diceGameSUT = new DiceGame(dieMockOne, dieMockTwo);

    when(dieMockOne.getValue()).thenReturn(4);
    when(dieMockTwo.getValue()).thenReturn(3);

    assertTrue(diceGameSUT.playGame());
  }

  @Test
  void playGameMethodShouldReturnFalseForTotalValueThatIsNot7() {
    Die dieMockOne = mock(Die.class);
    Die dieMockTwo = mock(Die.class);
    DiceGame diceGame = new DiceGame(dieMockOne, dieMockTwo);

    when(dieMockOne.getValue()).thenReturn(5);
    when(dieMockTwo.getValue()).thenReturn(1);

    assertFalse(diceGame.playGame());
  }
}
