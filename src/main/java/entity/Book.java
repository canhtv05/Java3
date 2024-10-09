package entity;

public class Book {
    // dùng lớp wrapper cho dễ thao tác hay còn gọi là kiểu object
    private Integer id;
    private String category;
    private String title;
    private Integer quantity;

    // alt + insert
    // or
    // chuot phai -> generator

    public Book() {
    }

    // chon nhieu shift + mui ten xuong

    public Book(Integer id, String category, String title, Integer quantity) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

