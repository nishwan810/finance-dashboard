package com.nishwan.FinanceHub.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDTO {
    private String category;
    private Double total;
}
