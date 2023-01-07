package assignment.part.tdd;

public class DiceGame {
  Die dieOne;
  Die dieTwo;

  public DiceGame(Die dieOne, Die dieTwo) {
    this.dieOne = dieOne;
    this.dieTwo = dieTwo;
  }

  public boolean playGame() {
    this.dieOne.rollDie();
    this.dieTwo.rollDie();

    return dieOne.getValue() + dieTwo.getValue() == 7;
  }
}
