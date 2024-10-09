package service;

import entity.Book;
import repo.BookRepo;

import java.util.ArrayList;

public class BookService {
    // tao file repo
    private BookRepo repo = new BookRepo();

    public ArrayList<Book> getAll() {
        return repo.getAll();
    }

    public void addBook(Book book) {
        repo.addBook(book);
    }

    public Book getBookById(Integer id) {
        return repo.getBookById(id);
    }

    public void deleteBook(Integer id) {
        repo.deleteBook(id);
    }

    public void updateBook(Book book) {
        repo.updateBook(book);
    }
}
