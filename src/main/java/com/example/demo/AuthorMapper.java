package com.example.demo;

import com.example.demo.generated.types.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthorMapper {
  @Select("SELECT author.id, author.first_name, author.last_name FROM book INNER JOIN author ON author.id = book.author_id WHERE book.id=#{id}")
  Author getByBookId(Integer id);
}
