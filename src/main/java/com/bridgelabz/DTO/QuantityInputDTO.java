package com.bridgelabz.DTO;

import com.bridgelabz.DTO.QuantityDTO;
import lombok.Data;

@Data
public class QuantityInputDTO {
    private QuantityDTO thisQuantityDTO;
    private QuantityDTO thatQuantityDTO;
}