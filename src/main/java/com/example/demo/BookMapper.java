package com.example.demo;

import com.example.demo.generated.types.Book;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {
  @Select("SELECT id, name, page_count, author_id FROM book WHERE id=#{id}")
  Book getById(Integer id);
  @Select("SELECT id, name, page_count, author_id FROM book")
  List<Book> findAll();
}

