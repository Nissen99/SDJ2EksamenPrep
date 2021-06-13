public class RealCounter implements Counter
{


  private SharedRessource sharedRessource;

  public RealCounter(SharedRessource sharedRessource)
  {
    this.sharedRessource = sharedRessource;
  }

  @Override public void increment()
  {
  sharedRessource.increment();
  }

  @Override public int getValue()
  {
    return sharedRessource.getValue();
  }
}
