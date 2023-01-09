package assignment.part.tdd;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
  UserInterface ui;
  Player player;
  DiceGame diceGame;
  Die dieOne;
  Die dieTwo;
  Scanner scan = new Scanner(System.in, "utf-8");

  @BeforeEach
  void setUp() {
    player = new Player(ui, scan, diceGame);
    ui = new UserInterface();
    dieOne = new Die();
    dieTwo = new Die();
    diceGame = new DiceGame(dieOne, dieTwo);
  }

  @Test
  void mainMethodShouldCallPlayerPlayGame() {
    App.main(null);
    verify(this.player, times(1)).playGame();
  }
}
