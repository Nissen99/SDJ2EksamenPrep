public class Start
{
  public static void main(String[] args)
  {
    SharedResource sharedResource = new SharedResource();

    for (int i = 0; i < 50; i++)
    {
      Reader reader = new Reader(sharedResource, i);
      Thread t1 = new Thread(reader);
      t1.start();
    }

    for (int i = 0; i < 1; i++)
    {
      Writer writer = new Writer(sharedResource);
      Thread t1 = new Thread(writer);
      t1.start();
    }

  }
}
