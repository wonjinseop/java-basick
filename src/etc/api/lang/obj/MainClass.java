package etc.api.lang.obj;

public class MainClass {
    
    public static void main(String[] args) {
    
        Person kim = new Person("김춘식", 30);
        Person hong = new Person("홍길동", 25);
        
        // 객체 타입의 변수를 출력하거나 값을 얻을 때는
        // 뒤에 자동으로 .toString()이 붙어서 진행됩니다. (Object가 물려주는 메서드)
        System.out.println(kim);
        System.out.println(hong);
        
        if (kim.equals(hong)) {
            System.out.println("이름과 나이가 같네요~");
        } else {
            System.out.println("이름이 다를수도, 나이가 다를수도, 둘 다 다를수도...");
        }
        
        // finalize는 gc를 호출하는 순서가 보장되지 않기 때문에
        // 사용이 권장되지 않습니다.
//        hong = null;
//        kim = null;
//        System.gc(); // 가비지 컬렉터 호출. (부른다고 바로 안 올수도 있습니다;;)
        
        Person park = new Person("박복제인간", 100);
//        Person clonePerson = park;
        
        try {
            Person clonPerson = (Person) park.clone();
            System.out.println("복사된 객체 정보: " + clonPerson);
            park.setName("박영희");
            System.out.println(park);
            System.out.println(clonPerson);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
}
