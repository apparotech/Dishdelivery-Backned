package com.socialmore.dishdelivery.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmore.dishdelivery.entity.Category;
import com.socialmore.dishdelivery.entity.Item;
import com.socialmore.dishdelivery.exception.ItemNotFoundException;
import com.socialmore.dishdelivery.payloads.itemdto;
import com.socialmore.dishdelivery.repository.ItemRepository;
import com.socialmore.dishdelivery.service.ItemService;

@Service
public class ItemServiceImpl implements  ItemService {
    

    @Autowired

    private ItemRepository itemRepository;

    @Override
    public Item addItem(itemdto itemdto) throws ItemNotFoundException {
        if(itemdto == null) throw new ItemNotFoundException("Please add valid Item Details...");

         Item item = new Item();
         item.setItemName(itemdto.getItemName());
         item.setQuantity(itemdto.getQuantity());
         item.setCost(itemdto.getCost());

         Category category = new Category();
         category.setCategoryName(itemdto.getCategoryName());
         item.setCategory(category);

         Item savedItem = itemRepository.save(item);
         return  savedItem;

    }

    @Override
    public Item updateItem(Integer itemId ,itemdto itemdto) throws ItemNotFoundException {
      Optional<Item> existingItemOpt = itemRepository.findById(itemId);
      if(!existingItemOpt.isPresent()) {
        throw new ItemNotFoundException("Item with ID " + itemId + " not found.");
      }

      Item existingItem = existingItemOpt.get();
       existingItem.setItemName(itemdto.getItemName());
       existingItem.setQuantity(itemdto.getQuantity());
       existingItem.setCost(itemdto.getCost());

       Category category = new Category();

       category.setCategoryName(itemdto.getCategoryName());
       existingItem.setCategory(category);

       return  itemRepository.save(existingItem);




    }


    public Item viewItem(Integer itemId) throws  ItemNotFoundException {

        Optional<Item>  optional = itemRepository.findById(itemId);

        if(optional.isPresent()) {
            Item savedItem = optional.get();
			
			return savedItem;
        }

    else {

        throw new ItemNotFoundException("No such Item in List....");
    }


    
    

}

    @Override
    public Item removeItem(Integer itemId) throws ItemNotFoundException {
        
        Optional<Item> optional = itemRepository.findById(itemId);
		
		if(optional.isPresent()) {
			
			Item existedItem = optional.get();
			
			itemRepository.delete(existedItem);
			
			return existedItem;
		}
		else {
			throw new ItemNotFoundException("No Such Item to be Removed...... Please add it First");
		}
    }

    @Override
    public List<Item> viewAllItemsByCategory(Category category) throws ItemNotFoundException {
       // throw new UnsupportedOperationException("Not supported yet.");

       List<Item> listByCategory = new ArrayList<>();

       List<Item> itemList = itemRepository.findAll();

       for(Item item :  itemList ) {

        if(item.getCategory().equals(category)) {
            listByCategory.add(item);
        }
       }

       if(listByCategory.isEmpty()) throw new ItemNotFoundException("No such Item with this category name = "+category.getCategoryName()+" exist");

		return listByCategory;
    }

    @Override
    public List<Item> viewAllItemsByName(String name) throws ItemNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet.");

        List<Item> itemList = itemRepository.findByItemName(name);
        if(itemList.isEmpty())throw new ItemNotFoundException("Item with this name not exist....."); 

        return itemList;
    }


    
  
}
