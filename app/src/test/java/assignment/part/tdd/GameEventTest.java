package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GameEventTest {
  @Test
  void gameEventEnumShouldHavePlayValue() {
    GameEvent value = GameEvent.findEnumValue("PLAY");

    assertEquals(GameEvent.PLAY, value);
  }

  @Test
  void gameEventEnumShouldHaveQuitValue() {
    GameEvent value = GameEvent.findEnumValue("QUIT");

    assertEquals(GameEvent.QUIT, value);
  }


  @Test
  void gameEventEnumShouldHaveNothingValue() {
    GameEvent value = GameEvent.findEnumValue("NOTHING");

    assertEquals(GameEvent.NOTHING, value);
  }
}
