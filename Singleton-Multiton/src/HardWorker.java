public class HardWorker implements Runnable
{
  @Override public void run()
  {
    while (true){
      Logger.getInstance().log("I did some hard work");
      try
      {
        Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
