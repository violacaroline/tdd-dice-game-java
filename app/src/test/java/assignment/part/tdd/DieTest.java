package assignment.part.tdd;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DieTest {
  private Die dieSUT;
  private int minValue;
  private int maxValue;

  @BeforeEach
  void setUpDie() {
    this.dieSUT = new Die();
    this.minValue = 1;
    this.maxValue = 6;
  }
  
  @Test
  void dieShouldHaveValuePropertyInitializedToANumberBetween1And6() {
    assertTrue(this.dieSUT.getValue() >= this.minValue && this.dieSUT.getValue() <= this.maxValue);
  }

  @Test
  void dieRollMethodShouldSetValuePropertyToAnIntBetween1And6() {
    int randomDieValue = this.dieSUT.getValue();

    assertTrue(randomDieValue >= this.minValue && randomDieValue <= this.maxValue);
  }
}
