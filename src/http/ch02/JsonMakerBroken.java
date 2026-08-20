package http.ch02;

import java.util.ArrayList;
import java.util.List;

public class JsonMakerBroken {

    public static void main(String[] args) {

        String name = "홍\"길동\"";
        int age = 21;
        List<String> subjects = new ArrayList<>();
        subjects.add("수학");
        subjects.add("물리");
        subjects.add("C:\\java\\workspace");

        // 위 데이터를 메서드 호출하여 json 형식의 문자열로 변환하는 기능을 호출
        String result = toJson(name, age, subjects);

        System.out.println(result);


    }

    // 학생 정보를 JSON 문자열로 조립하는 메서드 구현
    public static String toJson(String name, int age, List<String> subjects) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\t\"name\" : \"").append(name).append("\",\n");
        sb.append("\t\"age\" : ").append(age).append(",\n");
        sb.append("\t\"subjects\" : [\n");
        String comma = "";
        for (String sub : subjects) {
            sb.append(comma).append("\t\t\"").append(sub).append("\"");
            comma = ",\n";
        }
        sb.append("\n\t]");
        sb.append("\n}");

        return sb.toString();
    }


}
