public class Starter
{
  public static void main(String[] args) throws InterruptedException
  {

    Radiator radiator = new Radiator();

    System.out.println(radiator.getPower());

    radiator.turnUp();

    System.out.println(radiator.getPower());

    radiator.turnUp();

    System.out.println(radiator.getPower());

    radiator.turnUp();

    System.out.println(radiator.getPower());

    Thread.sleep(2000);


Thread.sleep(5000);

    System.out.println(radiator.getPower());



  }
}
