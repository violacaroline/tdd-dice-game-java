package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DieTest {
  @Test
  void dieShouldHaveValuePropertyInitializedToZero() {
    Die die = new Die();

    assertEquals(0, die.value);
  }
}
