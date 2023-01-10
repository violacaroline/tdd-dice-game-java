package assignment.part.tdd;

import java.util.Scanner;

public class Player {
  private UserInterface ui;
  private Scanner scan;
  private DiceGame diceGame;
  private boolean running;

  public Player(UserInterface ui, Scanner scan, DiceGame diceGame) {
    this.ui = ui;
    this.scan = scan;
    this.diceGame = diceGame;
  }

  public void playGame() {
    this.ui.printWelcome();
    this.running = true;

    while (running) {
      GameEvent gameEvent = this.ui.printMenu(scan);
      performGameEvent(gameEvent);
    }
  }

  // SKAPA METOD FÖR SWITCH!! KANSKE SPY, PROTECTED/ARV - LOOP CLASS - INNER CLASS
  public void performGameEvent(GameEvent gameEvent) {
    switch (gameEvent) {
      case PLAY:
        displayWinningOrLosingMessage(this.diceGame.playGame());
        break;
      case QUIT:
        this.ui.printQuittingMessage();
        this.running = false;
        break;
      default:
        break;
    }
  }

  public void displayWinningOrLosingMessage(boolean gameRound) {
    if (gameRound) {
      this.ui.printWinningMessage();
    } else {
      this.ui.printLosingMessage();
    }
  }
}
