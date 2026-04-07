package com.nishwan.FinanceHub.controller;

import com.nishwan.FinanceHub.model.Finance;
import com.nishwan.FinanceHub.model.RecordType;
import com.nishwan.FinanceHub.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/finances")
@CrossOrigin
public class FinanceController {

    @Autowired
    private FinanceService financeservice;


    @GetMapping("/filter")
    public ResponseEntity<List<Finance>> filterFinance(

            @RequestParam(required = false) RecordType type,

            @RequestParam(required = false) String category,

            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date start,

            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date end
    ) {

        return ResponseEntity.ok(
                financeservice.filterFinance(type, category, start, end)
        );
    }

    @GetMapping
    public ResponseEntity<List<Finance>> getFinance(){
        return new ResponseEntity<>(financeservice.getAllFinance(), HttpStatus.OK);
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<Finance> getFinancebyId(@PathVariable int id){

        Finance finance = financeservice.getFinanceById(id);

        if(finance != null)
            return  new ResponseEntity<>(finance, HttpStatus.OK);
        else
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> addFinance(@RequestBody Finance finance){

        Finance savedFinance =financeservice.addFinance(finance);

        return  new ResponseEntity<>(savedFinance, HttpStatus.CREATED);


    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> patchFinance(
            @PathVariable int id,
            @RequestBody Finance finance) {

        try {

            Finance updatedFinance = financeservice.patchFinance(id, finance);

            return ResponseEntity.ok(updatedFinance);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteFinance(@PathVariable int id){

        Finance finance = financeservice.getFinanceById(id);
        if(finance!=null){
            financeservice.deleteFinance(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }





}
