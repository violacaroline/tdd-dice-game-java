package assignment.part.tdd;

import java.util.Scanner;

/**
 * Represents the user interface.
 */
public class UserInterface {
  /**
   * Prints Welcome message.
   */
  void printWelcome() {
    System.out.println("Welcome!");
  }

  /**
   * Prints Menu.
   */
  GameEvent printMenu(Scanner scan) {
    System.out.println("Trying to print menu etc..");
    String choice = scan.nextLine();

    if (choice.equalsIgnoreCase("p")) {
      return GameEvent.PLAY;
    } else if (choice.equalsIgnoreCase("q")) {
      return GameEvent.QUIT;
    }

    return GameEvent.NOTHING;
  }

  /**
   * Prints You Won message.
   */
  void printWinningMessage() {
    System.out.println("You Won!");
  }

  /**
   * Prints You Lost message.
   */
  void printLosingMessage() {
    System.out.println("You Lost..");
  }
}
