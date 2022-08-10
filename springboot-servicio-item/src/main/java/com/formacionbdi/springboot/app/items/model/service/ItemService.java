package com.formacionbdi.springboot.app.items.model.service;

import com.formacionbdi.springboot.app.items.model.entity.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findAll();

    public Item findById(Long id, Integer cantidad);
}
