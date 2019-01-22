package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    String somebody = "world";
    hello(somebody);

    double l = 5;
    System.out.println("Площадь квадрата со стороной " + l + " равна " + area(l));

    double a = 5;
    double b = 6;
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " равна " + area(a, b));
  }

  public  static  void  hello(String somebody){
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(double l){
    return l * l;
  }

  public static double area(double a, double b){
    return a * b;
  }
}