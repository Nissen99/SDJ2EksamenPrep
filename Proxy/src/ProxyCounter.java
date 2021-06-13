public class ProxyCounter implements Counter
{

  private RealCounter realCounter;
  public ProxyCounter(SharedRessource sharedRessource)
  {
    this.realCounter = new RealCounter(sharedRessource);
  }

  @Override public synchronized void increment()
  {
    realCounter.increment();
  }

  @Override public synchronized int getValue()
  {
    return realCounter.getValue();
  }
}
