import javax.servlet.http.Cookie;

class A {

  Cookie cookie = new Cookie("name", "value");

  void foo(Cookie cookie) {
    int age = cookie.getMaxAge();
  }

  void bar() {
    Cookie cookie = new Cookie("name", "value");
    cookie.setSecure(true);
  }
  void baz() {
    Cookie cookie = new Cookie("name", "value"); // Noncompliant [[sc=12;ec=18]] {{Add the "secure" attribute to this cookie}}
  }
  void qix() {
    Cookie cookie = new Cookie("name", "value"); // Noncompliant {{Add the "secure" attribute to this cookie}}
    cookie.setSecure(false);
  }

  private static Map<String, String> getCookies(HttpHeaders headers) {
    Map<String, String> output = new HashMap();
    if (headers != null) {
      Iterator var2 = headers.getCookies().keySet().iterator();

      while(var2.hasNext()) {
        String key = (String)var2.next();
        Cookie cookie = (Cookie)headers.getCookies().get(key);
        output.put(key, cookie.getValue());
      }
    }

    return output;
  }


}
