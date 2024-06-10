package com.example.book_management.resolvers;


import com.example.book_management.services.BookService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.book_management.model.Book;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    private final BookService bookService;

    @Autowired
    public MutationResolver(BookService bookService) {
        this.bookService = bookService;
    }

    public Book addBook(String title, String author, String description) {
        Book book = new Book(title, author, description); // Create a new Book object
        return bookService.addBook(book);
    }

    public Book updateBook(Long id, String title, String author, String description) {
        Book existingBook = bookService.getBookById(id);
        if (existingBook == null) {
            throw new IllegalArgumentException("Book not found with ID: " + id);
        }
        existingBook.setTitle(title);
        existingBook.setAuthor(author);
        existingBook.setDescription(description);
        return bookService.updateBook(id, existingBook);
    }

    public boolean deleteBook(Long id) {
        bookService.deleteBook(id);
        return true;
    }
}

