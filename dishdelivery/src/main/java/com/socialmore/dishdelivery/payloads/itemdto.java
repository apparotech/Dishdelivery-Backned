package com.socialmore.dishdelivery.payloads;

import com.socialmore.dishdelivery.enuk.CategoryName;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class itemdto {
    
    private Integer itemId;

    @NotNull(message = "Please Enter item Name...")
    @Size(min = 3, max=20)
    private String itemName;

    //private String Category category;
    private CategoryName categoryName;

    @NotNull(message = "Please Enter quantity...")
    @Min(1)
    private Integer quantity;

    @DecimalMin("1.00")
    private Double cost;
    
}
