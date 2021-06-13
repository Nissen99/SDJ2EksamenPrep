public class Radiator
{

  private RadiatorState radiatorState = new OffState();



  public void setPowerState(RadiatorState radiatorState){
    this.radiatorState = radiatorState;
  }

  public void turnUp() throws InterruptedException
  {
    radiatorState.turnUp(this);
  }

  public void turnDown(){
    radiatorState.turnDown(this);
  }

  public int getPower(){
    return radiatorState.getPower();
  }

}
