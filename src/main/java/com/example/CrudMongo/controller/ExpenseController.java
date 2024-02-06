package com.example.CrudMongo.controller;

import com.example.CrudMongo.model.Expense;
import com.example.CrudMongo.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("addExpense")
    public ResponseEntity addExpense(@RequestBody Expense expense){
        this.expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("update")
    public ResponseEntity updateExpense(@RequestBody Expense expense){
        expenseService.updateExpense(expense);
       return ResponseEntity.status(HttpStatus.OK).build();
    }

   @GetMapping("/getAll")
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
   }
@DeleteMapping("/del/{id}")
   public ResponseEntity<Object> deleteByID(@PathVariable String id){
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.OK).build();
   }
}
