package com.example.CrudMongo.service;

import com.example.CrudMongo.model.Expense;
import com.example.CrudMongo.repository.Expenserepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private final Expenserepository expenserepository;

    public ExpenseService(Expenserepository expenserepository) {
        this.expenserepository = expenserepository;
    }


    public void addExpense(Expense expense){
        expenserepository.insert(expense);
    }
    public void updateExpense(Expense expense){
        Expense savedExpence=expenserepository.findById(expense.getId())
                .orElseThrow(()->new RuntimeException("Cannot find expense with given id"));
        savedExpence.setExpenseName(expense.getExpenseName());
        savedExpence.setExpenseAmount(expense.getExpenseAmount());
        savedExpence.setExpenseCategory(expense.getExpenseCategory());

        expenserepository.save(expense);
    }
    public void deleteExpense(String id){
        expenserepository.deleteById(id);
    }

    public List<Expense> getAllExpenses(){
      return expenserepository.findAll();
    }
}
