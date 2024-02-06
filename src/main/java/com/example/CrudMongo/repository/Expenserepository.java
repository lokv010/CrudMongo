package com.example.CrudMongo.repository;

import com.example.CrudMongo.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface Expenserepository  extends MongoRepository<Expense,String> {


}
