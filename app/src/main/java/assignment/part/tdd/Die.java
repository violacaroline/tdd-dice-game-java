package assignment.part.tdd;

import java.util.Random;

public class Die {
  private int value = 1;

  public Die() {
    this.value = rollDie();
  }

  public int getValue() {
    return this.value;
  }

  public int rollDie() {
    Random random = new Random();
    int min = 1;
    int max = 6;

    return random.nextInt(min + max) + min;
  }
}
