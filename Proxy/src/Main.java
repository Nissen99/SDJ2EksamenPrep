public class Main
{
  public static void main(String[] args)
  {
    SharedRessource sharedRessource = new SharedRessource();

    Counter proxy = new ProxyCounter(sharedRessource);

    Incrementer incrementer = new Incrementer(proxy);
    Incrementer incrementer2 = new Incrementer(proxy);

    new Thread(incrementer).start();
    new Thread(incrementer2).start();
  }
}
