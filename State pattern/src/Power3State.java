public class Power3State implements RadiatorState
{

  private final int POWER = 3;

  private Radiator radiator;
  private Thread t1;


  public Power3State(Radiator radiator){


      t1 = new Thread(this::runThread);
      t1.setDaemon(true);

      t1.start();
      this.radiator = radiator;

  }

  private void runThread(){

    try
    {
      t1.sleep(5000);
      turnDown(radiator);
    }
    catch (InterruptedException e)
    {
    }
  }

  @Override public void turnUp(Radiator radiator)
  {
  }

  @Override public void turnDown(Radiator radiator)
  {
    t1.interrupt();
    radiator.setPowerState(new Power2State());

  }

  @Override public int getPower()
  {
    return POWER;
  }


}
