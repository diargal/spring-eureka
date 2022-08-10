package com.formacionbdi.springboot.app.item.model.service;

import com.formacionbdi.springboot.app.item.model.entity.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findAll();

    public Item findById(Long id, Integer cantidad);
}
