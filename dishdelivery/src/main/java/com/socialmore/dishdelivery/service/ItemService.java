package com.socialmore.dishdelivery.service;

import java.util.List;

import com.socialmore.dishdelivery.entity.Admin;
import com.socialmore.dishdelivery.entity.Category;
import com.socialmore.dishdelivery.entity.Item;
import com.socialmore.dishdelivery.entity.User;
import com.socialmore.dishdelivery.exception.ItemNotFoundException;
import com.socialmore.dishdelivery.payloads.itemdto;

public interface  ItemService {

    public Item addItem(itemdto itemdto , Admin admin)  throws  ItemNotFoundException;

    public Item updateItem( Integer itemId ,itemdto itemdto)  throws ItemNotFoundException;

    public Item viewItem (Integer itemId) throws ItemNotFoundException;

    public Item removeItem(Integer itemId) throws ItemNotFoundException;

    public List<Item> viewAllItemsByCategory(Category category) throws ItemNotFoundException;

    public List<Item> viewAllItemsByName(String name) throws ItemNotFoundException;





}
