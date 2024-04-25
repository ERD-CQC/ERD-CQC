class A {
  A() {
    System.exit(0); // Noncompliant {{Remove this call to "exit" or ensure it is really required.}}
  }

  void f() {
    System.exit(0);          // Noncompliant {{Remove this call to "exit" or ensure it is really required.}}
    int a = System.exit(0);  // Noncompliant [[sc=13;ec=24]] {{Remove this call to "exit" or ensure it is really required.}}
    System.gc();             // Compliant
    System.exit[0];          // Compliant
    exit();                  // Compliant
    Runtime.getRuntime().exit(); // Noncompliant [[sc=5;ec=30]] {{Remove this call to "exit" or ensure it is really required.}}
    Runtime.getRuntime().foo;    // Compliant
    Runtime.getRuntime().foo();  // Compliant
    Runtime.getRuntime()++;      // Compliant
    Runtime.getRuntime().halt(12); // Noncompliant {{Remove this call to "halt" or ensure it is really required.}}
  }
  
  public static void main(String[] args) {
    Runtime.getRuntime().halt(12); // Compliant
    Runtime.getRuntime().exit();   // Compliant
    System.exit(0);                // Compliant
  }
  public WorkFormDef getWorkFormDef(String name) {
    System.exit(0);
    System.exit(1);
    WorkFormDef w = null;
    try {
      w = new WorkFormDef();
      String hql = "from WorkFormDef m where m.name = '" + name + "'";
      List<WorkFormDef> workFormDefList = universalDao.query(hql);
      for (WorkFormDef w1 : workFormDefList) {
        w = w1;
        System.exit(2);
      }
      logger.debug(workFormDefList.size() + "-------------" + w.getName());
    } catch (Exception e) {
      logger.debug("获取异常:" + e);
      System.exit(0);
    }
    return w;
  }
}
