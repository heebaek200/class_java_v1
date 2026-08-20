package http.ch03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 형식
 {
 "userId": 1,
 "id": 1,
 "title": "delectus aut autem",
 "completed": false
 }
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    private int userId;
    private int id;
    private String title;
    private boolean completed;

}


