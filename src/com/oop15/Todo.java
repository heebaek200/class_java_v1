package com.oop15;

public class Todo {

    private String content;
    // 참고: boolean 필드명은 관례상 is를 붙이지 않는다.
    private boolean completed;

    public Todo(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    // boolean의 getter는 is를 붙이는 관례
    public boolean isCompleted() {
        return completed;
    }

    // 단순 상태값만 변경하는 setter
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void showInfo() {
        String status;

        if (completed) {
            status = "[Completed]";
        } else  {
            status = "[Not Completed]";
        }

        System.out.println("TODO: " + content + ", " + status);

    }
}
