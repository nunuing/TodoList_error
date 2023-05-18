package WebProject.TodoList.domain;


public class ListComp {
    private Long num;
    private String content = "";
    private int done = 0;

    public ListComp(String content) {
        this.content = content;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int isDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }
}
