package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GameEventTest {
  /**
   * GameEvent Enum should have a PLAY value.
   */
  @Test
  void gameEventEnumShouldHavePlayValue() {
    GameEvent value = GameEvent.PLAY;

    assertEquals(GameEvent.PLAY, value);
  }
}
