package com.min.shop.service;

import com.min.shop.domain.item.Book;
import com.min.shop.domain.item.Item;
import com.min.shop.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void saveItem() {
        //given
        Item item = new Book();
        item.setName("정처기");

        //when
        itemService.saveItem(item);

        //then
        assertEquals(item, itemRepository.findOne(item.getId()));

    }

}