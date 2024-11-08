package com.socialmore.dishdelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmore.dishdelivery.entity.Category;
import com.socialmore.dishdelivery.entity.Item;
import com.socialmore.dishdelivery.exception.ItemNotFoundException;
import com.socialmore.dishdelivery.payloads.itemdto;
import com.socialmore.dishdelivery.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
    
    @Autowired
    private ItemService itemService;


    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody itemdto itemdto) {
         try {
            Item  savedItem = itemService.addItem(itemdto);
             return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
         } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

         }}



         @PutMapping("update/{itemId}")

         public ResponseEntity<Item> updateItem(@PathVariable Integer itemId, @RequestBody itemdto itemdto ) {

            try {
                Item updatedItem = itemService.updateItem(itemId, itemdto);
                return new ResponseEntity<>(updatedItem, HttpStatus.OK);
            } catch ( ItemNotFoundException e) {

                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }}

            @GetMapping("/view/{itemId}")
            public ResponseEntity<Item> viewItemHandler(@PathVariable Integer itemId) {
                Item existedItem = itemService.viewItem(itemId);
                return new ResponseEntity<Item>(existedItem, HttpStatus.OK);

               

            }

            @DeleteMapping("/remove/{itemId}")
             public ResponseEntity<Item> removeItemHandler(@PathVariable Integer itemId) {

                Item deletedItem = itemService.removeItem(itemId);

                return new ResponseEntity<Item>(deletedItem, HttpStatus.OK);
             }


            @PostMapping("/getByCategory")

            public ResponseEntity<List<Item>> viewAllItemsByCategoryHandler(@RequestBody Category category){
		
                List<Item> listItem = itemService.viewAllItemsByCategory(category);
                
                return new ResponseEntity<>(listItem, HttpStatus.ACCEPTED);
         }

         @PostMapping("/getByName/{name}")
	    public ResponseEntity<List<Item>> viewAllItemsByNameHandler(@PathVariable("name") String itemName){
		
		List<Item> listItem = itemService.viewAllItemsByName(itemName);
		
		return new ResponseEntity<>(listItem, HttpStatus.ACCEPTED);
		
	}


        }
       

        
    

