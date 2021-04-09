public class Math extends Thread {
  int[] array;
  int beginIndex;
  int endIndex;
  long sum = 0;

  public Math(int[] array, int beginIndex, int endIndex, ThreadGroup threadGroup, int count) {
    super(threadGroup, "Thread " + count);
    this.array = array;
    this.beginIndex = beginIndex;
    this.endIndex = endIndex;
  }


  @Override
  public void run() {
    int copyBegin = beginIndex;
    for (; copyBegin < endIndex; copyBegin++) {
      sum += array[copyBegin];
      Program.plus(array[copyBegin]);
    }
    System.out.println(Thread.currentThread().getName().replaceAll("-", " ") + ": from " +  beginIndex + " to " + endIndex + " sum is " + sum);
  }
}
