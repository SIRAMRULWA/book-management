package com.example.book_management.services;


import com.example.book_management.model.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book addBook(Book book);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}

