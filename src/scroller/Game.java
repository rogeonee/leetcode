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

        if (random == 0 || random == 1)
            grid.setImage(new Location(row, grid.getNumCols() - 1), get);
        else if (random > 1 && random < 5)
            grid.setImage(new Location(row, grid.getNumCols() - 1), avoid);
        else
            grid.setImage(new Location(row, grid.getNumCols() - 1), null);
    }
  }
  
  public void scrollLeft()
  {
  }
  
  public void handleCollision(Location loc)
  {
  }
  
  public int getScore()
  {
    return 0;
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