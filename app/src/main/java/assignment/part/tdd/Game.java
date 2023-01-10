package assignment.part.tdd;

public class Game {
  private Player player;

  public Game(Player player) {
    this.player = player;
  }

  public void startGame() {
    this.player.playGame();
  }
}
