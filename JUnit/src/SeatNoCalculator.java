public class SeatNoCalculator
{


  private String hallNo;
  private int currentSeatNo;
  private int maxSeatsInRow;
  private int maxRows;

  public SeatNoCalculator(String hallNo, int maxSeatsInRow, int maxRows) {
    if (hallNo == null || maxSeatsInRow==0 || maxRows == 0){
      throw new IllegalArgumentException("Max rows or maxSeats in row is 0 or hallNo = null");
    }
    this.maxRows = maxRows;
    this.maxSeatsInRow = maxSeatsInRow;
    this.hallNo = hallNo;
    currentSeatNo = 100;
  }


  public String calculateSeatNo(){
    currentSeatNo++;

    if (availableSpaceInRow()){
      return hallNo + currentSeatNo;
    }
    else if (lastSpaceAndNotLastRow()){
      int returnNumber = currentSeatNo;
      currentSeatNo = rowSwitch();
      return hallNo + returnNumber;
    }
    else if (lastSpaceInLastRow()){
      return hallNo + currentSeatNo;
      //next will throw exception
    } else {
      throw new IllegalStateException("Hall full, cant add more seats");
    }
  }

  public int getMaxSeatsInRow()
  {
    return maxSeatsInRow;
  }

  public int getMaxRows()
  {
    return maxRows;
  }

  private int rowSwitch()
  {
    return currentSeatNo + 100 - maxSeatsInRow;
  }

  private boolean lastSpaceInLastRow()
  {
    return
        currentSeatNo % 100 == maxSeatsInRow && maxRows == currentSeatNo / 100;
  }

  private boolean lastSpaceAndNotLastRow()
  {
    return
        currentSeatNo % 100 == maxSeatsInRow && maxRows > currentSeatNo / 100;
  }

  private boolean availableSpaceInRow()
  {
    return currentSeatNo % 100 < maxSeatsInRow;
  }

}
