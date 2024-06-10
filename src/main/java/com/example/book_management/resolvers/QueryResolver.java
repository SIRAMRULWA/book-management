package com.example.book_management.resolvers;

import com.example.book_management.model.Book;
import com.example.book_management.services.BookService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private final BookService bookService;

    @Autowired
    public QueryResolver(BookService bookService) {
        this.bookService = bookService;
    }

    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    public Book getBookById(Long id) {
        return bookService.getBookById(id);
    }
}

