package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main (String[] args){
/*    String[] langs = new String[4];
    langs[0] = "Java";
    langs[1] = "C#";
    langs[2] = "Python";
    langs[3] = "PHP";*/

    String[] langs = {"Java", "C#","Python", "PHP"};

    List<String> langs2 = new ArrayList<String>();
    langs2.add("Java");
    langs2.add("C#");
    langs2.add("PHP");

    List<String> langs3 = Arrays.asList("Java", "C#","Python", "PHP");

    List langs4 = Arrays.asList("Java", "C#","Python", "PHP");

    System.out.println("\r" + "Массивы");

    for (int i = 0; i < langs.length; i++){
      System.out.println("Я хочу выучить " + langs[i]);
    }

    System.out.println("\r" + "Списки");

    for (int i = 0; i < langs2.size(); i++){
      System.out.println("Я хочу выучить " + langs2.get(i));
    }

    System.out.println("\r" + "Массивы");

    for (String l : langs) {
      System.out.println("Я хочу выучить " + l);
    }

    System.out.println("\r" + "Списки");

    for (String l : langs2) {
      System.out.println("Я хочу выучить " + l);
    }

    System.out.println("\r" + "Списки");

    for (String l : langs3) {
      System.out.println("Я хочу выучить " + l);
    }

    System.out.println("\r" + "Списки без указания типа");

    for (Object l : langs4) {
      System.out.println("Я хочу выучить " + l);
    }
  }
}
