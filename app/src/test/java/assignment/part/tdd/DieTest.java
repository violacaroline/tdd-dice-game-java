package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DieTest {
  private Die die;
  private int minValue;
  private int maxValue;

  @BeforeEach
  void setUpDie() {
    this.die = new Die();
    this.minValue = 1;
    this.maxValue = 6;
  }
  
  @Test
  void dieShouldHaveValuePropertyInitializedToANumberBetween1And6() {
    assertTrue(this.die.getValue() >= this.minValue && this.die.getValue() <= this.maxValue);
  }

  @Test
  void dieRollMethodShouldSetValuePropertyToAnIntBetween1And6() {
    int randomDieValue = this.die.rollDie();

    assertTrue(randomDieValue >= this.minValue && randomDieValue <= this.maxValue);
  }
}
