public class MainNotSafe
{
  public static void main(String[] args)
  {
    SharedRessource sharedRessource = new SharedRessource();

    Counter real = new RealCounter(sharedRessource);

    Incrementer incrementer = new Incrementer(real);
    Incrementer incrementer2 = new Incrementer(real);

    new Thread(incrementer).start();
    new Thread(incrementer2).start();
  }
}
