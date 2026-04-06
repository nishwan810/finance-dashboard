package com.nishwan.FinanceHub.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SummaryDTO {
    private Double totalIncome;
    private Double totalExpense;
    private Double netBalance;

}
