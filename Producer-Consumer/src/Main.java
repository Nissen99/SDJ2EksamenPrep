public class Main
{
  public static void main(String[] args)
  {
    CookieJar counter = new CookieJar( 100);

    Baker baker1 = new Baker(counter, 300);
    Eater eater1 = new Eater(counter, 300);

    Baker baker2 = new Baker(counter, 300);
    Eater eater2 = new Eater(counter, 300);


    Thread t1 = new Thread(baker1);
    Thread t2 = new Thread(baker2);
    Thread t3 = new Thread(eater1);
    Thread t4 = new Thread(eater2);

    t1.start();
    t2.start();
    t3.start();
    t4.start();


  }
}
