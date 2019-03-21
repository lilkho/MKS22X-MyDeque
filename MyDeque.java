public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start=0;end=0;
    size=0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    start=0;end=0;
    size=0;
  }

  public int size(){
    return size;
  }
  public String toString(){
    String ans = "{";
    if (start<=end) {
      for (int i=start;i<end-start;i++) {
          ans+=data[i]+",";
      }
      return ans+data[end]+"}";
    } else {
      return ans;
    }
  }
  public void addFirst(E element){
    if (data[start]==null) data[start]=element;
    else if (start-1>=0) {

    } else {

    }
    start--;
    size++;
  }
  public void addLast(E element){
    if (data[end]==null) {
      data[end]=element;
      end--;
    }
    else if (end+1<data.length){
      data[end+1]=element;
    } else {
      data[(end+1)%(size+1)]=element;
    }
    end++;
    size++;
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

  public static void main(String[] args) {
    MyDeque<Integer> m = new MyDeque<Integer>();
    m.addLast(1);
    m.addLast(2);
    System.out.println(m);
  }
}
