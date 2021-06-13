public class Navigator
{

  private NavigationStrategy strategy;
  private int start;
  private int finish;



  public Navigator(int start, int finish)
  {
    this.start = start;
    this.finish = finish;
  }

  public void setStrategy(NavigationStrategy strategy)
  {
    this.strategy = strategy;
  }

  public void calculate(){
 strategy.calculate(start, finish);
  }




  public void setStart(int start)
  {
    this.start = start;
  }

  public void setFinish(int finish)
  {
    this.finish = finish;
  }
}
