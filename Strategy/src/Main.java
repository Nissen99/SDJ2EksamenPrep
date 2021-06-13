public class Main
{
  public static void main(String[] args)
  {
    Navigator navigator = new Navigator(1, 17);

    navigator.setStrategy(new BikeStrategy());
    navigator.calculate();

    navigator.setStrategy(new CarStrategy());
    navigator.calculate();
  }
}
