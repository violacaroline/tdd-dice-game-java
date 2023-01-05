package assignment.part.tdd;

public enum GameEvent {
  PLAY;

  public static GameEvent findEnumValue(String enumValueName) {
    GameEvent value = null;
  
    for (GameEvent gameEvent : values()) {
      if (gameEvent.name().equalsIgnoreCase(enumValueName)) {
        value = gameEvent;
      }
    }
  
    return value;
  }
}

