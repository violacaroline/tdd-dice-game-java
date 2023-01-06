package assignment.part.tdd;

import java.util.Random;

public class Die {
  private int value = 0;

  public int getValue() {
    return this.value;
  }

  public int roll() {
    Random random = new Random();

    return random.nextInt(1 + 6) + 1;
  }
}
