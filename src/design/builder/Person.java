package design.builder;

// 과제 : 빌더 패턴 만들어보기
// 나는 롬복 방식의 Person.builder()....build()로 만들어 보고 싶은데... 대충 예상은 간다만
public class Person {

    public enum Gender {
        MALE, FEMALE
    }

    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private int height;
    private int weight;

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.age = builder.age;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private Gender gender;
        private int age;
        private int height;
        private int weight;

        private Builder() {}

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Builder height(int height) {
            this.height = height;
            return this;
        }
        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

}
