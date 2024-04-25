class A {
  public static int staticValue = 0;
  private static final int CONST = staticValue++; // Compliant
  private int value;
  private static int[] staticArray;
  private static boolean stopdown = false;

  public void nonCompliantAssignments() {
    staticValue = value + 1; // Noncompliant [[sc=5;ec=16]] {{Make the enclosing method "static" or remove this set.}}
    staticValue += value; // Noncompliant {{Make the enclosing method "static" or remove this set.}}
    staticValue++; // Noncompliant {{Make the enclosing method "static" or remove this set.}}
    ++staticValue; // Noncompliant {{Make the enclosing method "static" or remove this set.}}
    A.staticValue++; // Noncompliant {{Make the enclosing method "static" or remove this set.}}
    this.staticValue--; // Noncompliant {{Make the enclosing method "static" or remove this set.}}
    A myA = new A();
    myA.staticValue = 1; // Noncompliant {{Make the enclosing method "static" or remove this set.}}
    myA.staticArray[0] = 1; // Noncompliant {{Make the enclosing method "static" or remove this set.}}
    myA.toString();
    A.stopdown= true; // Noncompliant {{Make the enclosing method "static" or remove this set.}} asiv added
    class InnerClass {
      InnerClass() {
        staticValue++; // Noncompliant {{Make the enclosing method "static" or remove this set.}}
      }
    }
  }
  public void setStopdown(boolean stopdown) {
    A.stopdown = stopdown;// Noncompliant {{Make the enclosing method "static" or remove this set.}} asiv added
  }

  private class InnerClassWithNonCompliantAssignment {
    void foo() {
      staticValue++; // Noncompliant {{Make the enclosing method "static" or remove this set.}}
    }
  }

  public synchronized void synchronizedMethod() {
    staticValue++; // Compliant
  }

  public static void compliantStaticMethod() {
    staticValue++; // Compliant
  }

  public void compliantCode() {
    value++; // Compliant

    A myA = new A();
    myA.value = value++; // Compliant

    int variable;
    variable = staticValue; // Compliant

    synchronized (new Object()) {
      staticValue++; // Compliant
      staticValue = value + 1; // Compliant
    }

    MyUnknownClass.staticField = value; // Compliant
  }
}

class B {
  private static int value;

  private static Comparable<Object> myComparator;

  static {
    myComparator = new Comparable<Object>() { // Compliant

      @Override
      public int compareTo(Object o) {
        value = 0; // Compliant
        return 0;
      }
    };
  }

  private void foo() {
    synchronized (new Object()) {
      Comparable<Object> cmp = new Comparable<Object>() {

        @Override
        public int compareTo(Object o) {
          value = 0; // Compliant
          return 0;
        }
      };
    }

  }
}
public class OuterClass {
  public static int staticValue = 0;
  private static final int CONST = staticValue++; // Compliant
  private int value;
  private static int[] staticArray;
  private final static boolean onbFlag = false;
  private static int  ass;
  private static int bss=1;
  //构造方法中完成初始化
  OuterClass()
  {
    ass=1;//compliant
    bss=2;//compliant
    init();
  }
  private void init(){
    ass =2;
    bss =1;
  }
  // 内部类
  public class InnerClass {
    public int staticArray=1;
    public void innerMethod() {
      staticValue++; // Noncompliant {{Make the enclosing method "static" or remove this set.}}
      System.out.println("This is a method in the inner class.");
      staticArray=2;//compliant
    }
  }


  // 外部类的方法，用于创建并调用内部类
  public void outerMethod() {
    // 创建内部类的实例
    InnerClass innerInstance = new InnerClass();
    // 调用内部类的方法
    innerInstance.innerMethod();
    boolean onbFlag = false;
    if (true)
    {
        onbFlag = true;//compliant
    }
    www.staticValue = 1;//compliant
  }
  public void foo(String staticValue) {
    staticValue="1";//compliant
    if (onbFlag=true)//noncomplaint
    {
      System.out.println("This is a method in the inner class.");
    }
  }
}

