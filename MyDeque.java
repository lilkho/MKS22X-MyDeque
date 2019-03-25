public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start=4;end=4;
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
    String ans = "[";
    for (int i=start;i<start+size-1;i++) {
      ans+=data[i%data.length]+",";
    }
    return ans+data[end]+"]";
  }
  public String toStringDebug(){
    String ans = "{";
    for (int i=0;i<data.length-1;i++) {
        ans+=data[i]+",";
    }
    return ans+data[data.length-1]+"}";
  }
  public void addFirst(E element){
    if (start<0) {
      int newStart = data.length+start;
      data[newStart]=element;
      start=newStart;
    } else if (data[start]==null) {
      data[start]=element;
      start--;
    } else {
      data[start-1]=element;
      start--;
    }
    size++;
  }
  public void addLast(E element){
    if (end+1>=data.length){
      //resize();
      //data[end+1]=element;
      int newEnd = (data.length)%(start+size);
      data[newEnd]=element;
      end=newEnd-1;
    } else if (data[end]==null) {
      data[end]=element;
      end--;
    } else {
      data[end+1]=element;
    }
    end++;
    size++;
  }
  public E removeFirst(){
    E first = getFirst();
    start++;
    size--;
    return first;
  }
  public E removeLast(){
    E last = getLast();
    if (start>end) end=data.length-end;
    else end--;
    size--;
    return last;
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }
  @SuppressWarnings("unchecked")
  public void resize(){
    E[] newA = (E[])new Object[data.length*2];
    for (int i=0;i<data.length;i++) {
      newA[i]=data[i];
    }
    data = newA;
  }
  public static void main(String[] args) {
    MyDeque<Integer> m = new MyDeque<Integer>();
    for (int i=0;i<8;i++) m.addLast(i+4);
    System.out.println(m);
    System.out.println(m.toStringDebug());
    System.out.println(m.getLast());
    System.out.println(m.getFirst());
    System.out.println(m.removeLast());
    System.out.println(m+"/");
    MyDeque<Integer> m2 = new MyDeque<Integer>();
    for (int i=0;i<7;i++) m2.addFirst(i+4);
    System.out.println(m2);
    System.out.println(m2.toStringDebug());
    System.out.println(m2.getLast());
    System.out.println(m2.getFirst());
    System.out.println(m2.removeFirst());
    System.out.println(m2);
  }
}
