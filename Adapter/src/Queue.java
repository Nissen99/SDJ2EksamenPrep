import java.util.ArrayList;

public class Queue implements StringQueue
{

  private ArrayList<String> queue = new ArrayList<>();


  @Override public void enqueue(String element)
  {
    queue.add(element);
  }

  @Override public String dequeue()
  {
    return queue.remove(0);
  }

  @Override public int size()
  {
    return queue.size();
  }

  @Override public int indexOf(String element)
  {
  return queue.indexOf(element);
  }

  @Override public boolean isEmpty()
  {
    return queue.isEmpty();
  }

  @Override public boolean contains(String element)
  {
    return queue.contains(element);
  }

  @Override public String first()
  {
    return queue.get(0);
  }
}
