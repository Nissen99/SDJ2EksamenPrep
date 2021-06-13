public class BikeStrategy implements NavigationStrategy
{
  @Override public void calculate(int start, int finish)
  {
    for (int i = start; i < finish; i++)
    {
      System.out.println("turn left or right i dont know: " + i);

    }
  }
}
