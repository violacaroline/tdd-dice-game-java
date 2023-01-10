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
    System.out.println("You rolled: " + dieOne.getValue());

    this.dieTwo.rollDie();
    System.out.println("You rolled: " + dieTwo.getValue());

    boolean isSeven = dieOne.getValue() + dieTwo.getValue() == 7;

    return isSeven;
  }
}
