public class CarStrategy implements NavigationStrategy
{
  @Override public void calculate(int start, int finish)
  {
    for (int i = start; i < finish; i++)
    {
      if (i % 2 == 0){
        System.out.println("turn left: " + i);
      }else {
        System.out.println("turn right: " + i);
      }
    }
  }
}
