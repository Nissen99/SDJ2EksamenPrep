public class Reader implements Runnable
{

  private SharedResource sharedResource;
  private int number;

  public Reader(SharedResource sharedResource, int number)
  {
    this.sharedResource = sharedResource;
    this.number = number;
  }

  @Override public void run()
  {
    while (true){
      sharedResource.acquireRead();
      System.out.println(number + " Read: " + sharedResource.read());
      sharedResource.releaseRead();
      try
      {
        Thread.sleep((int) Math.random() * 100);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
