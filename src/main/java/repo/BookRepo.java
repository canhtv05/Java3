package repo;

import entity.Book;
import jdbc.DatabaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookRepo {
    // ket noi voi db
    private DatabaseConnect dbc = new DatabaseConnect("book", "sa", "123456");

    // tao cac obj thao tac voi db  vì dùng nhiều nên làm v cho đỡ lặp code
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Connection conn = null;

    // alt + shift + f // format code

    public BookRepo() {
        try {
            conn = dbc.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getAll() {
        ArrayList<Book> books = new ArrayList<>();

        // kết nối và thao tác như java 2
        // sử dụng dấu """ // nội dung """ để thao tác với db ko cần xuống dòng mà phải +  chuỗi
        String sql = """
                    SELECT id, category, title, quantity FROM dbo.Book;
                """;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // executeQuery dùng để run câu lệnh while
            while (rs.next()) {
                // như này cho dễ hiểu :v
                // hình như éo được :v

                // phần này cũng vậy , cái phần column label đấy ta có thể dùng cách index được
                Integer id = rs.getInt(1);
                String category = rs.getString(2);
                String title = rs.getString(3);
                Integer quantity = rs.getInt(4);
                books.add(new Book(id, category, title, quantity));
            }

            return books;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // nếu k có list or k có rs.next  thì return
        return null;
    }

    public void addBook(Book book) {
        // id tu tang nen la k can nhap
        String sql = "INSERT INTO dbo.Book (category, title, quantity) values (?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, book.getCategory());
            ps.setString(2, book.getTitle());
            ps.setInt(3, book.getQuantity());
            // executeUpdate dùng để insert , update, delete
            // cta có thể sử dụng câu lệnh execute trong mọi trường hợp k cần update hay query gì
            // thieu me values :V

            // ko validate nhe
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Book getBookById(Integer id) {
        // tìm book dùng steeam().filter để lọc những book có id == id và tìm thăngd đầu tiên nếu k tìm tháy return về null
        // ở đây là object nên k sô ssanh == được dùng so sánh object
        return getAll().stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteBook(Integer id) {
        String sql = "DELETE FROM dbo.Book WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            // thôi kẹ hàm void cũng đc :v k cần check kĩ
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book book) {
        String sql = "UPDATE dbo.Book SET title = ?, quantity = ? WHERE id = ?";
        try {
            // khi sử dụng kiểu wrapper hay object thì tad dùng như này cho nhanh đỡ phải nhớ
            ps = conn.prepareStatement(sql);
            ps.setObject(1, book.getTitle());
            ps.setObject(2, book.getQuantity());
            ps.setObject(3, book.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
