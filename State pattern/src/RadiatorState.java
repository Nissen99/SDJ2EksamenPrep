public interface RadiatorState
{



  void turnUp(Radiator radiator) throws InterruptedException;

  void turnDown(Radiator radiator);

  int getPower();
}
