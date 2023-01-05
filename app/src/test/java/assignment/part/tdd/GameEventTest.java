package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GameEventTest {
  @Test
  void gameEventEnumShouldHavePlayValue() {
    GameEvent value = GameEvent.findEnumValue("PLAY");

    assertEquals(GameEvent.PLAY, value);
  }

}
