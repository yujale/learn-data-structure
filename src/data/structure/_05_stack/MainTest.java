package data.structure._05_stack;

public class MainTest {

    public static void main(String[] args) {
      testIsEmpty();
      System.out.println("===================================");
      testSize();
      System.out.println("===================================");
      testPeek();
      System.out.println("===================================");
      testPush();
      System.out.println("===================================");
      testPop();
      System.out.println("===================================");
      testClear();
      System.out.println("===================================");
    }
  
    public static void testIsEmpty() {
      NewStack<Integer> stack = new NewStack<>();
      System.out.println(stack.isEmpty());
      Integer size = stack.push(1);
      System.out.println(size);
    }
  
    public static void testSize() {
      NewStack<Integer> stack = new NewStack<>();
      System.out.println(stack.size());
      Integer size = stack.push(1);
      System.out.println(size);
    }
  
    public static void testPeek() {
      NewStack<Integer> stack = new NewStack<>();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      System.out.println(stack.peek());
    }
  
    public static void testPush() {
      NewStack<Integer> stack = new NewStack<>();
      stack.push(1);
      stack.push(2);
      stack.push(4);
      System.out.println(stack.peek());
    }
  
    public static void testPop() {
      NewStack<Integer> stack = new NewStack<>();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      System.out.println(stack.pop());
      System.out.println(stack.peek());
    }
  
  
    public static void testClear() {
      NewStack<Integer> stack = new NewStack<>();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.clear();
      System.out.println(stack.size());
    }
  }
