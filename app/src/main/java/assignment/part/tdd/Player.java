package assignment.part.tdd;

import java.util.Scanner;

public class Player {

  public void playGame(UserInterface ui, Scanner scan, DiceGame diceGame) {
    ui.printWelcome();

    do {
      
    } while (ui.printMenu(scan) != GameEvent.QUIT);
  }
}
