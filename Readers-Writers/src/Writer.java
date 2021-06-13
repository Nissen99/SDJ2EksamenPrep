public class Writer implements Runnable
{

  private SharedResource sharedResource;

  public Writer(SharedResource sharedResource)
  {
    this.sharedResource = sharedResource;
  }

  @Override public void run()
  {
    while (true){
      sharedResource.acquireWrite();
      sharedResource.write();
      sharedResource.releaseWrite();
      try
      {
        Thread.sleep(200);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
