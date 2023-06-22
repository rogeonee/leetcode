package scroller;

public class Game
{
  private Grid grid;
  private int userRow;
  private int msElapsed;
  private int timesGet;
  private int timesAvoid;

  private String user = "assets/user.gif";
  private String get = "assets/get.gif";
  private String avoid = "assets/avoid.gif";
  
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
    //System.out.println(key);
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
        if (prevImg == "assets/get.gif") {
            timesGet++;
            //System.out.println("Get: " + timesGet);
        } else if (prevImg == "assets/avoid.gif") {
            timesAvoid++;
            //System.out.println("Avoid: " + timesAvoid);
        }
    }
  }
  
  public int getScore()
  {
    return timesGet - timesAvoid;
  }
  
  public void updateTitle()
  {
    grid.setTitle("Game:  " + getScore());
  }
  
  public boolean isGameOver()
  {
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