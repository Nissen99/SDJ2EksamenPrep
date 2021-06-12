public class Eater implements Runnable
{
  private CookieJar cookieJar;
  private int amount;

  public Eater(CookieJar cookieJar, int amount)
  {
    this.cookieJar = cookieJar;
    this.amount = amount;
  }

  @Override public void run()
  {
    for (int i = 0; i < amount; i++)
    {
      cookieJar.eat();
    }

  }
}
