package com.bridgelabz.DTO.quantity;

import lombok.Data;

@Data
public class QuantityInputDTO {
    private QuantityDTO thisQuantityDTO;
    private QuantityDTO thatQuantityDTO;
}