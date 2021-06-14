import java.io.*;

public class Logger
{

  private static Logger instance;

  public static Logger getInstance() {
    if (instance == null) {
      instance = new Logger();
    }
    return instance;
  }

  private File file;

  private Logger() {
    file = new File("logfile.txt");
  }

  public void log(String txt) {
    try {
      Writer out = new BufferedWriter(new FileWriter(file));
      out.append(txt);
      out.flush();
      out.close();
      System.out.println("Something logged");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
