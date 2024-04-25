class A {
  
  void method1() {
    if(getTrue() || getFalse()){};
    if(getTrue() && getFalse()){};
    if(getTrue() | getFalse()){}; // Noncompliant [[sc=15;ec=16]] {{Correct this "|" to "||".}}
    if(getTrue() & getFalse()){}; // Noncompliant {{Correct this "&" to "&&".}}
    if(Boolean.TRUE | Boolean.FALSE){}; // Noncompliant
    if(Boolean.TRUE & Boolean.FALSE){}; // Noncompliant
    if(getInt1() | getInt0()){};
    if(getInt1() & getInt0()){};
    if(unknown1 & unknown2){};
  }

  boolean getTrue() {
    return true;
  }
  
  boolean getFalse() {
    return false;
  }
  
  int getInt1() {
    return 1;
  }
  
  int getInt0() {
    return 0;
  }

}
