public class SharedResource
{
  private int i = 0;
  private int activeReaders = 0;
  private int waitingReaders = 0;
  private boolean activeWriter = false;


  public void write(){
  i++;
  }

  public int read(){
    return i;
  }

  public synchronized void acquireWrite(){
    while (activeWriter || activeReaders > 0 || waitingReaders > 0){
      try
      {
        wait();
      }
      catch (InterruptedException ignored)
      {}
    }

    activeWriter = true;
  }

  public synchronized void releaseWrite(){
    activeWriter = false;
    notifyAll();
  }

  public synchronized void acquireRead(){
    waitingReaders++;

    while (activeWriter){
      try
      {
        wait();
      }
      catch (InterruptedException ignored)
      {}
    }
    activeReaders++;
    waitingReaders--;
   }

   public synchronized void releaseRead(){
     activeReaders--;
    if (activeReaders == 0){
      notifyAll();
    }
   }

}
