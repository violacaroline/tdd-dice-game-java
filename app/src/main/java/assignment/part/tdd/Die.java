package assignment.part.tdd;

import java.util.Random;

public class Die {
  private int value;

  public Die() {
    rollDie();
  }

  public int getValue() {
    return this.value;
  }

  public void rollDie() {
    Random random = new Random();
    int min = 1;
    int max = 7;

    this.value = random.nextInt(max - min) + min;
  }
}
