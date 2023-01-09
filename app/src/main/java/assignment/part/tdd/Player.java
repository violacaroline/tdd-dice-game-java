package assignment.part.tdd;

import java.util.Scanner;

public class Player {
  private UserInterface ui;
  private Scanner scan;
  private DiceGame diceGame;

  public Player (UserInterface ui, Scanner scan, DiceGame diceGame) {
    this.ui = ui;
    this.scan = scan;
    this.diceGame = diceGame;
  }

  public void playGame() {
    this.ui.printWelcome();
    this.ui.printLosingMessage();

    do {
      if (this.diceGame.playGame()) {
        this.ui.printWinningMessage();
      }      
    } while (this.ui.printMenu(scan) != GameEvent.QUIT);

    this.ui.printQuittingMessage();
  }
}
