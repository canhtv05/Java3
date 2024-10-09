package controller;

import entity.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.BookService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BookServlet", value = {
        "/books",
        //thêm 1 đường dẫn nào mớ thì vt vào đaya và switch case
        // thêm dấu / vào trước nếu k là sai đường dẫn
        "/book/read",
        "/book/add",
        "/book/delete",
        "/book/edit",
        "/book/update",
})
public class BookServlet extends HttpServlet {
    private BookService service = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        // lấy chính là cái value

        // lấy đường dẫn của servlet
        // có nhiều đường dẫn (uri) dùng switch
        // chỉnh sửa ở phần value vì đây là phần chứa đường dẫn và file servlet này
        // là file chính thao tác và xử lý tác vụ trong jv3
        switch (path) {
            case "/books": {
                listBook(request, response);
                // phần cấu hình khi tạo file servlet hay dbconnect thì tí t đẩy lên trên github
                // đây là cách cấu hình
                break;
            }
            case "/book/read": {
                // tạo cái này để à làm này đã :v
                // vì servlet lấy path ở phần value nên nó sẽ lọt vào đây
                // khi lấy được đường dẫn đó thì lại dẫn nó sang tới form add book
                readForm(request, response);
                break;
            }

            // bây giờ phải lấy được dữ liêu từ bên form kia
            case "/book/add": {
                addBook(request, response);
                break;
            }
            case "/book/delete": {
                deleteBook(request, response);
                break;
            }
            case "/book/edit": {
                editBook(request, response);
                break;
            }
            case "/book/update": {
                updateBook(request, response);
                break;
            }
            // giờ lấy được id của edit cái
            // switch phai co default
            // setting run file
            //ô dia tìm lỗi cái đã :v
            // à do nãy vừa xóa file index.jsp đầu tiên nên nó lần đầu thì sẽ run file index trước ở đây k có nên nó k tìm thấy
            default: {
            }
        }
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // bây giờ form nó vùa gửi yêu cầu vào lọt vào case thì ta lại phải láy dữ liệu nó tương tự nhu thêm mới
        Book book = readDataToForm(request);

        // giừo sửa thôi
        service.updateBook(book);
        //hiện duplicate
        // lại chuyển nó về form chính a page home
        response.sendRedirect("/books");
    }

    private Book readDataToForm(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String category = request.getParameter("category");
        String title = request.getParameter("title");
        //ctrl + d : duplicate: trung lap
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));

        // return ve object book
        return new Book(id, category, title, quantity);
    }

    private void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lại chuyển đến jsp để thao tác thôi
        // lấy thằng book đó đã vì phải lấy được nó mới edit nó được
        Integer id = Integer.parseInt(request.getParameter("id"));
        Book book = service.getBookById(id);

        // bây giờ muốn form upadte láy được dữ leieuj thfi phải setAttribute nhề
        request.setAttribute("book", book);
        request.getRequestDispatcher("/view/updateBook.jsp").forward(request, response);
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // muốn xóa thì phải tìm index của nó xem nó là index nào
        // lấy id khi click vao the a
        Integer id = Integer.parseInt(request.getParameter("id"));

        service.deleteBook(id);
        // à hình như k cần lấy book :v
        //xóa xong lại chuyển đến trang home
        response.sendRedirect("/books");

    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // lấy dữ liệu từ form bằng getparam
        // getParameter nó sẽ trả vêf string nên parse nó về integer
        // cái id lấy ở đâu ?? thì nó lấy ở cái name của ô input
        Book book = readDataToForm(request);
        // tạo book mới bên repo
        service.addBook(book);

        // sau khi thêm thành công thì chuyển lại hướng nó về phần home page bằng sendRedirect
        // vì trong đây có phương thức  post  ở form nên ta phải thêm phương thức đó vào phần doPost
        response.sendRedirect("/books");
    }

    private void readForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/addBook.jsp").forward(request, response);
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // quen chua tao entity :v
        // tạo lớp service thực hiện các yêu cầu từ servlet xong sau đó từ service thao tác với repository
        // tao arraylist or list để lưu danh sách vì list la danh sách
        // khởi tạo service bôok thao tác với
        ArrayList<Book> books = service.getAll();
        // bấm vào bóng đèn đỏ nó tự tạo

        // khi lấy được listbook thì dùng nó để chuyển tới file jsp để thao tác
        request.setAttribute("books", books); // dùng để lấy dữ liệu của books với tên là  "books"
        // lấy xong thì di chuyển nó sang file jsp
        // request là mình gửi đi còn response là dữ liệu nhận về
        // tạo câu lệnh này để nó biết file jsp ở đâu
        // forward nó sẽ điều hướng tới đó
        // them exeption (ngoại lệ)
        request.getRequestDispatcher("/view/listBook.jsp").forward(request, response);
        // tạo directory ở phần webapp có tên là view trong đó có file là listbook.jsp
        // mà phần code java thì tạo package ở trong phần java
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        addBook(request, response);
        // nhưu này viết nhiều nên chỉ cần viết
        doGet(request, response);
        // cho nhanh :)))
    }
}