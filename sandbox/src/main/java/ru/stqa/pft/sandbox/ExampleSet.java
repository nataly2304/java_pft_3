package ru.stqa.pft.sandbox;

import java.util.HashMap;
import java.util.Map;

public class ExampleSet {

  public static class A {
    String value;

    public A(String value) {
      this.value = value;
    }

    @Override
    public int hashCode() {
      if(value.equals("ad"))
        return 1;
      if(value.equals("bd"))
        return 2;
      if(value.equals("cd"))
        return 3;
      return super.hashCode();
    }

    @Override
    public String toString() {
      return value;
    }
  }

  public static void main(String[] args) {
    Map<A, String> s = new HashMap<>();
    s.put(new A("ad"), "a");
    s.put(new A("bd"), "a");
    s.put(new A("cd"), "a");
    System.out.println(s);


  }
}
