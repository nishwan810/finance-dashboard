package com.nishwan.FinanceHub.service;

import com.nishwan.FinanceHub.DTOs.CategoryDTO;
import com.nishwan.FinanceHub.DTOs.SummaryDTO;
import com.nishwan.FinanceHub.model.Finance;
import com.nishwan.FinanceHub.repo.FinanceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final FinanceRepo financeRepo;

    public SummaryDTO getSummary() {

        Double income = financeRepo.getTotalIncome();
        Double expense = financeRepo.getTotalExpense();

        if (income == null) income = 0.0;
        if (expense == null) expense = 0.0;

        Double net = income - expense;

        return new SummaryDTO(income, expense, net);
    }

    public List<CategoryDTO> getCategoryExpense() {

        List<Object[]> data = financeRepo.getCategoryWiseExpense();

        List<CategoryDTO> result = new ArrayList<>();

        for (Object[] row : data) {

            String category = (String) row[0];
            Double total = (Double) row[1];

            result.add(new CategoryDTO(category, total));
        }

        return result;
    }

    public List<Finance> getRecentRecords() {
        return financeRepo.findTop5ByOrderByDateDesc();
    }
}