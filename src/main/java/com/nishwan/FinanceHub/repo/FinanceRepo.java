package com.nishwan.FinanceHub.repo;

import com.nishwan.FinanceHub.model.Finance;
import com.nishwan.FinanceHub.model.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FinanceRepo extends JpaRepository<Finance, Integer> {


    List<Finance> findByType(RecordType type);


    List<Finance> findByCategory(String category);


    List<Finance> findByDateBetween(Date start, Date end);


    List<Finance> findByTypeAndCategory(RecordType type, String category);


    List<Finance> findByTypeAndDateBetween(
            RecordType type,
            Date start,
            Date end
    );



    @Query("SELECT SUM(f.amount) FROM Finance f WHERE f.type = 'INCOME'")
    Double getTotalIncome();

    // total expense
    @Query("SELECT SUM(f.amount) FROM Finance f WHERE f.type = 'EXPENSE'")
    Double getTotalExpense();

    // category wise expense
    @Query("""
            SELECT f.category, SUM(f.amount)
            FROM Finance f
            WHERE f.type = 'EXPENSE'
            GROUP BY f.category
            """)
    List<Object[]> getCategoryWiseExpense();

    // recent records
    List<Finance> findTop5ByOrderByDateDesc();


}
