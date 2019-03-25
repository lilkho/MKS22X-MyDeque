import java.util.*;

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
    String ans = "{";
    for (int i=start;i<start+size-1;i++) {
      ans+=data[i%data.length]+" ";
    }
    return ans+data[end]+"}";
  }
  public String toStringDebug(){
    String ans = "{";
    for (int i=0;i<data.length-1;i++) {
        ans+=data[i]+",";
    }
    return ans+data[data.length-1]+"}";
  }
  public void addFirst(E element){
    if (element==null) throw new NullPointerException();
    if (size+1>data.length) resize();
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
    if (element==null) throw new NullPointerException();
    if (size+1>data.length) resize();
    if (end+1>=data.length) {
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
    if (size==0) throw new NoSuchElementException();
    E first = getFirst();
    if (start+1==data.length) start=0;
    else start++;
    size--;
    return first;
  }
  public E removeLast(){
    if (size==0) throw new NoSuchElementException();
    E last = getLast();
    if (end-1<0) end=data.length-1;
    else end--;
    size--;
    return last;
  }
  public E getFirst(){
    if (size==0) throw new NoSuchElementException();
    return data[start];
  }
  public E getLast(){
    if (size==0) throw new NoSuchElementException();
    return data[end];
  }
  @SuppressWarnings("unchecked")
  public void resize(){
    E[] newA = (E[])new Object[data.length*data.length];
    int x=start;
    for (int i=newA.length/2;x<start+size;i++) {
      newA[i]=data[x%data.length];
      x++;
    }
    start=newA.length/2;
    end=newA.length/2+size-1;
    data = newA;
  }
  public static void main(String[] args) {
    MyDeque<Integer> m = new MyDeque<Integer>();
    for (int i=0;i<11;i++) m.addLast(i+4);
    System.out.println(m);
    //System.out.println(m.toStringDebug());
    System.out.println(m.getLast());
    System.out.println(m.getFirst());
    System.out.println(m.removeLast());
    System.out.println(m+"/");
    MyDeque<Integer> m2 = new MyDeque<Integer>();
    for (int i=0;i<11;i++) m2.addFirst(i+4);
    System.out.println(m2);
    //System.out.println(m2.toStringDebug());
    System.out.println(m2.getLast());
    System.out.println(m2.getFirst());
    System.out.println(m2.removeFirst());
    System.out.println(m2);
  }
}
