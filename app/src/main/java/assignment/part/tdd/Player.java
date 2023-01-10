package assignment.part.tdd;

import java.util.Scanner;

public class Player {
  private UserInterface ui;
  private Scanner scan;
  private DiceGame diceGame;

  public Player(UserInterface ui, Scanner scan, DiceGame diceGame) {
    this.ui = ui;
    this.scan = scan;
    this.diceGame = diceGame;
  }

  public void playGame() {
    this.ui.printWelcome();
    boolean running = true;

    while (running) {
      GameEvent gameEvent = this.ui.printMenu(scan);
      switch (gameEvent) {
        case PLAY:
          if (this.diceGame.playGame()) {
            this.ui.printWinningMessage();
          } else {
            this.ui.printLosingMessage();
          }
          break;
        case QUIT:
          this.ui.printQuittingMessage();
          running = false;
          break;

        default:
          break;
      }
    }
  }
}
