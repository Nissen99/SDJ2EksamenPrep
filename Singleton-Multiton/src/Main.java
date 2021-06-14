public class Main
{
  public static void main(String[] args)
  {
  HardWorker hardWorker = new HardWorker();

  Thread t1 = new Thread(hardWorker);

  t1.start();
  }
}
