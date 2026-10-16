package design.builder;

public class MainTest1 {
    public static void main(String[] args) {
        // 빌더 패턴으로 클래스 생성해보기
        Burger burger1 = new Burger.Builder()
                .bread("참깨빵")
                .patty("소고기패티")
                .sauce("케찹")
                .build();

        System.out.println(burger1);


        Burger burger2 = new Burger.Builder()
                .patty("치킨")
                .bread("호밀빵")
                .build();

        System.out.println(burger2);


        // 과제
        Person person1 = Person.builder()
                .firstName("희백")
                .lastName("이")
                .gender(Person.Gender.MALE)
                .build();

        System.out.println(person1);
    }
}
