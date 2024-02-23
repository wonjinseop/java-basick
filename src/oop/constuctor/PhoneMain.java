package oop.constuctor;

public class PhoneMain {

    public static void main(String[] args) {

        Phone basic = new Phone();
        basic.showSpec();

        System.out.println("-------------------------------------");

        Phone galaxy = new Phone("갤럭시 s24");
        galaxy.showSpec();

        System.out.println("-------------------------------------");

        Phone IPhone = new Phone("아이폰 15", "스페이스 그레이");
        IPhone.showSpec();

    }

}
















