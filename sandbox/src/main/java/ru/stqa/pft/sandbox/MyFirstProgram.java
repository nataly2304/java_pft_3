package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    String somebody = "world";
    hello(somebody);

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

    Rectangle r = new Rectangle(5,6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.area());

    Point p1 = new Point(0, 0);
    Point p2 = new Point(1, 1);
    System.out.println("Расстояние между двумя точками с координатами (" + p1.x + ", " + p1.y + ") и (" + p2.x + ", " + p2.y + ") равно " + p1.distance(p2));

  }

  public  static  void  hello(String somebody){
    System.out.println("Hello, " + somebody + "!");
  }
}