package com.min.shop.domain;

import com.min.shop.domain.item.Book;
import com.min.shop.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
