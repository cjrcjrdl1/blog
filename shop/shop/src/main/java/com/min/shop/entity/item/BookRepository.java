package com.min.shop.entity.item;

import com.min.shop.entity.item.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
