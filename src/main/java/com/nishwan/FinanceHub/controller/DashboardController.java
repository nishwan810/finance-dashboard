package com.nishwan.FinanceHub.controller;

import com.nishwan.FinanceHub.DTOs.CategoryDTO;
import com.nishwan.FinanceHub.DTOs.SummaryDTO;
import com.nishwan.FinanceHub.model.Finance;
import com.nishwan.FinanceHub.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/summary")
    public ResponseEntity<SummaryDTO> getSummary() {

        return ResponseEntity.ok(
                dashboardService.getSummary()
        );
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDTO>> getCategoryExpense() {

        return ResponseEntity.ok(
                dashboardService.getCategoryExpense()
        );
    }

    @GetMapping("/recent")
    public ResponseEntity<List<Finance>> getRecentRecords() {

        return ResponseEntity.ok(
                dashboardService.getRecentRecords()
        );
    }
}