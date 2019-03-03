package ru.stqa.pft.sandbox;

import java.util.Objects;

public class Equality {
  public static void main(String args[]){
    String s1 = "firefox 2.0";
    String s2 = s1; //"firefox 2.0" or "fire" + "fox 2.0"
    String s3 = new String(s1); //"firefox " + Math.sqrt(4.0)

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
    System.out.println(Objects.equals(s1, s2));

    System.out.println(s1 == s3);
    System.out.println(s1.equals(s3));
    System.out.println(Objects.equals(s1, s3));
  }
}
