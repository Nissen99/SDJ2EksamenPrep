import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest
{

  @Test
  public void testGetLoggers() {

    Logger logger1 = Logger.getInstance();
    Logger logger2 = Logger.getInstance();

    System.out.println(logger1.toString());
    System.out.println(logger2.toString());

    assertEquals(logger1, logger2);
  }

}