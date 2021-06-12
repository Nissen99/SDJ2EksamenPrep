import java.util.ArrayList;

public class CookieJar
{

  private int max;
  private ArrayList<String> cookies;

  public CookieJar(int max){
    cookies = new ArrayList<>();
    this.max = max;
  }

  public synchronized void eat()
  {
    while (cookies.size() <= 0){
      try
      {
        wait();
      }catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    cookies.remove(0);
    System.out.println("-Amount of cookies: " + cookies.size());
    notifyAll();
  }

  public synchronized void makeCookie()
  {
    while (cookies.size() >= max){
      try
      {
        wait();
      }catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    cookies.add("Cookie");
    System.out.println("-Amount of cookies: " + cookies.size());
    notifyAll();
  }
}
