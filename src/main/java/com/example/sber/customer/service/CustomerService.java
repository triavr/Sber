package com.example.sber.customer.service;


import com.example.sber.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getBookById(Long id);    // получить клиента по id
    List<Customer> getAllCustomers();     // получить список всех клиентов
    void addBook(Customer book);     // добавить клиента
}
