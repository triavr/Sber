package com.example.sber.customer.dao;

import com.example.sber.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {         //создаем репозиторий для загрузки и сохранения записей в эту таблицу

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);


}
