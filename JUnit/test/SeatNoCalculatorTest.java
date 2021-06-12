import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SeatNoCalculatorTest
{

  SeatNoCalculator seatNoCalculator;

  @BeforeEach
  public void setup(){
    seatNoCalculator = new SeatNoCalculator("T", 5, 6);
  }

  @Test
  public void constructorSetsMaxSeatsInRow(){
    assertEquals(5, seatNoCalculator.getMaxSeatsInRow());
    assertEquals(6, seatNoCalculator.getMaxRows());
  }

  @Test
  public void constructorThrowsExceptionWhen0Input(){
      assertThrows(IllegalArgumentException.class, () -> new SeatNoCalculator("T", 0, 0));
  }

  @Test
  public void constructorThrowsExceptionWhenHallNoIsNull(){
    assertThrows(IllegalArgumentException.class, () -> new SeatNoCalculator(null, 5, 6));
  }

  @Test
  public void constructorThrowsExceptionWhen1Input(){
  SeatNoCalculator seatNoCalculator1 = new SeatNoCalculator("T", 1, 1);
    assertEquals(1, seatNoCalculator1.getMaxSeatsInRow());
    assertEquals(1, seatNoCalculator1.getMaxRows());
  }

  @Test
  public void calculateSeatNo(){
    assertEquals("T101", seatNoCalculator.calculateSeatNo());
    assertEquals("T102", seatNoCalculator.calculateSeatNo());

  }

  @Test
  public void calculateSeatNoShouldCalculateRowChange(){
    for (int i = 0; i < 4; i++)
    {
      seatNoCalculator.calculateSeatNo();
    }

    assertEquals("T105", seatNoCalculator.calculateSeatNo());
    assertEquals("T201", seatNoCalculator.calculateSeatNo());
  }

  @Test
  public void calculateSSeatNoShouldThrowExceptionWhenHallFull(){
    for (int i = 0; i < seatNoCalculator.getMaxRows()*seatNoCalculator.getMaxSeatsInRow(); i++)
    {
      seatNoCalculator.calculateSeatNo();
    }

    assertThrows(IllegalStateException.class, () -> seatNoCalculator.calculateSeatNo());
  }

}
