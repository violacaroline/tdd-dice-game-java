package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DieTest {
  @Test
  void dieShouldHaveValuePropertyInitializedToZero() {
    Die die = new Die();

    assertEquals(0, die.getValue());
  }

  @Test
  void dieRollMethodShouldSetValuePropertyToAnIntBetween1And6() {
    Die die = new Die();
    int min = 1;
    int max = 6;

    int randomDieValue = die.roll();

    assertTrue(randomDieValue >= min && randomDieValue <= max);
  }
}
