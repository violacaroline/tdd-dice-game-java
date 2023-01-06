package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DieTest {
  @Test
  void dieShouldHaveValueProperty() {
    Die die = new Die();

    assertTrue(die.value);
  }
}
