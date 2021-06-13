public class Incrementer implements Runnable
{

  private Counter counter;

  public Incrementer(Counter counter)
  {
    this.counter = counter;
  }

  @Override public void run()
  {
    for (int i = 0; i < 1000000; i++)
    {
      counter.increment();
    }
    System.out.println("Value: " + counter.getValue());
  }
}
