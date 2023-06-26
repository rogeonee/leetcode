
// Elena Savkina
// 79790747
// COSC 111 L02
// Scroller game "Hungry Croc" where you should eat the pizza and avoid broccoli ,
// the game  is over when you eat 5 broccoli
package scroller;
public class Game
{
  private Grid grid;
  private int userRow;
  private int msElapsed;
  private int timesGet;
  private int timesAvoid;

  private String user = "assets/croc0_rmbg.png";
  private String get = "assets/pizza_rmbg.png";
  private String avoid = "assets/broc_rmbg.png";
  
  public Game()
  {
    grid = new Grid(5, 10);
    userRow = 0;
    msElapsed = 0;
    timesGet = 0;
    timesAvoid = 0;
    updateTitle();
    grid.setImage(new Location(userRow, 0), user);
  }
  
  public void play()
  {
    while (!isGameOver())
    {
      grid.pause(100);
      handleKeyPress();
      if (msElapsed % 300 == 0)
      {
        scrollLeft();
        populateRightEdge();
      }
      updateTitle();
      msElapsed += 100;
    }
  }
  
  public void handleKeyPress() {
    int key = grid.checkLastKeyPressed();
    if(key == 38) {
      if(userRow == 0)
        return;

      grid.setImage(new Location(userRow, 0), null);
      userRow -= 1;
      grid.setImage(new Location(userRow, 0), user);

    } else if(key == 40) {
      if(userRow == 4)
        return;

      grid.setImage(new Location(userRow, 0), null);
      userRow += 1;
      grid.setImage(new Location(userRow, 0), user);
    }

  }
  
  public void populateRightEdge() {
    for (int row = 0; row < grid.getNumRows(); row++) {
        int random = (int) (Math.random() * 10);
        /*
         * 0 == G
         * From 1 to 2 == A
         * From 3 to 9 == empty space
         */
        if (random == 0)
            grid.setImage(new Location(row, grid.getNumCols() - 1), get);
        else if (random > 0 && random < 3)
            grid.setImage(new Location(row, grid.getNumCols() - 1), avoid);
        else
            grid.setImage(new Location(row, grid.getNumCols() - 1), null);
    }
  }
  
  public void scrollLeft() {
    String prevImg = grid.getImage(new Location(userRow, 1));

    for (int row = 0; row < grid.getNumRows(); row++) {
        for (int col = 1; col < grid.getNumCols(); col++) {
            String img = grid.getImage(new Location(row, col));
            grid.setImage(new Location(row, col - 1), img);
        }
        grid.setImage(new Location(row, grid.getNumCols() - 1), null);
    }

    // Restore user image
    grid.setImage(new Location(userRow, 0), user);

    // Check for collision with the image at the user's last location
    handleCollision(new Location(userRow, 1), prevImg);
  }

  public void handleCollision(Location loc, String prevImg) {
    if (prevImg != null) {
        if (prevImg == get) {
            timesGet++;
        } else if (prevImg == avoid) {
            timesAvoid++;
        }
    }
  }
  
  public int getScore() {
    return timesGet;
  }
  
  public void updateTitle() {
    grid.setTitle("Hungry Croc | Broc eaten: " + timesAvoid + " | Pizza eaten: " + timesGet);

    if(timesAvoid == 5)
      grid.setTitle("Game over! You ate " + timesGet + " pizzas!");
  }
  
  public boolean isGameOver() {
    if(timesAvoid == 5)
      return true;
    
    return false;
  }
  
  public static void test()
  {
    Game game = new Game();
    game.play();
  }
  
  public static void main(String[] args)
  {
    test();
  }
}