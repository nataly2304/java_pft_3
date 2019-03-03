package ru.stqa.pft.sandbox;

public class Equation {
  private final double a;
  private final double b;
  private final double c;
  private int n;

  public Equation(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;

    double d = b * b - 4 * a * c;

    if (a != 0){
      //свернутая форма
      if (d > 0){
        n = 2;
      } else if (d == 0){
        n = 1;
      } else {
        n = 0;
      }
    } else if (b != 0){
      System.out.println("Это вырожденное уравнение");
      n = 1;
      } else if (c != 0){
        n = 0;
      } else {
        n = -1;
    }


//    if (a == 0){
//      if (b == 0){
//        if (c == 0){
//          n = -1;
//        } else {
//          n = 0;
//        }
//      } else {
//        System.out.println("Это вырожденное уравнение");
//        n = 1;
//      }
//    } else {
//      //свернутая форма
//      if (d > 0){
//        n = 2;
//      } else if (d == 0){
//        n = 1;
//      } else {
//        n = 0;
//      }
//    }


    //неполная форма
//    if (d > 0){
//      n = 2;
//    }
//    if (d == 0){
//      n = 1;
//    }
//    if (d < 0){
//      n = 0;
//    }

      //Вложенная форма
//    if (d > 0) {
//      n = 2;
//    } else {
//      if (d == 0) {
//        n = 1;
//      } else {
//        n = 0;
//      }
//    }




  }

  public int rootNumber(){
    return n;
  }
}
