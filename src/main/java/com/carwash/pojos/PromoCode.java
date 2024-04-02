package com.carwash.pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoCode {
    private String code;
    private String description;
    private double discountPercentage;
}
