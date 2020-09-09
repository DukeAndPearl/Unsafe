package concurrent.entity;

public class Book {

    private String name;

    public Book() {
        this.name = "See, I'm here";
    }

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    };
}
