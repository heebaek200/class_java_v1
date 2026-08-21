package http.ch06;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    private long userId;
    private long id;
    private String title;
    private boolean completed;

}

/** JSON 형식:
 {
 "userId": 1,
 "id": 1,
 "title": "delectus aut autem",
 "completed": false
 }
 */