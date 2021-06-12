public class Seat
{
  private String seatNo;


  public String getSeatNo()
  {
    return seatNo;
  }

  public void setSeatNo(String seatNo)
  {
    this.seatNo = seatNo;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Seat)){
      return false;
    }
    Seat is = (Seat) obj;
    return is.getSeatNo().equals(seatNo);
  }
}
