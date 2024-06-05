package com.example.demo;

import com.example.demo.generated.types.Author;
import com.example.demo.generated.types.Book;
import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;


@Controller
public class BookController {

  private final BookMapper bookMapper;
  private final AuthorMapper authorMapper;

  public BookController(BookMapper bookMapper, AuthorMapper authorMapper) {
    this.bookMapper = bookMapper;
    this.authorMapper = authorMapper;
  }

  @QueryMapping
  public Book bookById(@Argument Integer id) {
    return bookMapper.getById(id);
  }

  @QueryMapping
  public List<Book> bookAll() {
    return bookMapper.findAll();
  }

  @SchemaMapping(typeName = "Book", field = "author")
  public Author author(Book book) {
    return authorMapper.getByBookId(book.getId());
  }


}
