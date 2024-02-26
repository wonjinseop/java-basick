package oop.encap.good;

public class MainClass {

    public static void main(String[] args) {

    MyBirth my = new MyBirth();
//    my.year = 1992; (x)
    my.setYear(1992);
    my.setMonth(2);
    my.setDay(28);

    my.birthInfo();


    }

}
