package scroller;

public class Game
{
  private Grid grid;
  private int userRow;
  private int msElapsed;
  private int timesGet;
  private int timesAvoid;
  
  public Game()
  {
    grid = new Grid(5, 10);
    userRow = 0;
    msElapsed = 0;
    timesGet = 0;
    timesAvoid = 0;
    updateTitle();
    grid.setImage(new Location(userRow, 0), "assets/user.gif");
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
      grid.setImage(new Location(userRow, 0), "assets/user.gif");

    } else if(key == 40) {
      if(userRow == 4)
        return;

      grid.setImage(new Location(userRow, 0), null);
      userRow += 1;
      grid.setImage(new Location(userRow, 0), "assets/user.gif");
    }

  }
  
  public void populateRightEdge()
  {
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