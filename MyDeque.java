public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
  }

  public int size(){
    return 0;
  }
  public String toString(){
    return "";
  }
  public void addFirst(E element){

  }
  public void addLast(E element){

  }
  public E removeFirst(){
    return data[0];
  }
  public E removeLast(){
    return data[0];
  }
  public E getFirst(){
    return data[0];
  }
  public E getLast(){
    return data[0];
  }

}
