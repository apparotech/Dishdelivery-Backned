package com.socialmore.dishdelivery.entity;

import com.socialmore.dishdelivery.enuk.CategoryName;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Category {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer categoryId;
    
    @Enumerated(EnumType.STRING)
    private CategoryName categoryName;
}
