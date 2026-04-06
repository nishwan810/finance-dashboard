package com.nishwan.FinanceHub.service;

import com.nishwan.FinanceHub.model.Finance;
import com.nishwan.FinanceHub.model.RecordType;
import com.nishwan.FinanceHub.repo.FinanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FinanceService {

    @Autowired
    private FinanceRepo financeRepo;


    public List<Finance> getAllFinance() {
        return financeRepo.findAll();
    }

    public Finance getFinanceById(int id) {
        return  financeRepo.findById(id).get();
    }

    public Finance addFinance(Finance finance) {

        return financeRepo.save(finance);
    }


    public Finance patchFinance(int id, Finance finance) {

        Finance existing = financeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Finance not found with id " + id));

        if (finance.getAmount() != null) {
            existing.setAmount(finance.getAmount());
        }

        if (finance.getCategory() != null) {
            existing.setCategory(finance.getCategory());
        }

        if (finance.getDescription() != null) {
            existing.setDescription(finance.getDescription());
        }

        if (finance.getDate() != null) {
            existing.setDate(finance.getDate());
        }

        if (finance.getType() != null) {
            existing.setType(finance.getType());
        }

        return financeRepo.save(existing);
    }

    public void deleteFinance(int id) {

        financeRepo.deleteById(id);
    }

    public List<Finance> filterFinance(
            RecordType type,
            String category,
            Date start,
            Date end
    ) {

        if (type != null && category != null) {
            return financeRepo.findByTypeAndCategory(type, category);
        }

        if (type != null && start != null && end != null) {
            return financeRepo.findByTypeAndDateBetween(type, start, end);
        }

        if (type != null) {
            return financeRepo.findByType(type);
        }

        if (category != null) {
            return financeRepo.findByCategory(category);
        }

        if (start != null && end != null) {
            return financeRepo.findByDateBetween(start, end);
        }

        return financeRepo.findAll();
    }
}
