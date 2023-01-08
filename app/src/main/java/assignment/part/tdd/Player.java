package assignment.part.tdd;

import java.util.Scanner;

public class Player {

  public void playGame(UserInterface ui, Scanner scan, DiceGame diceGame) {
    ui.printWelcome();
    ui.printMenu(scan);
  }
}
