package com.example.sber.customer.service;

import com.example.sber.customer.dao.CustomerEntity;
import com.example.sber.customer.dao.CustomerRepository;
import com.example.sber.customer.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor                  //генерирует конструктор с необходимыми аргументам: public DefaultBookService(BookRepository bookRepository) {
                                                                                                              // this.bookRepository = bookRepository;}
public class DefaultCustomerService {
    private final CustomerRepository customerRepository;

    public Customer getCustomerById(Long id) {           //прочитать запись из БД по первичному ключу id
        CustomerEntity customerEntity = customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Клиент не найден: id = " + id));

        return new Customer(
                customerEntity.getId(),
                customerEntity.getFirstName(),
                customerEntity.getLastName(),
                customerEntity.getCustomerNumber(),
                customerEntity.getStatus());
    }


    public List<Customer> getAllBooks() {          //прочитать все записи из БД и вернуть их в виде списка
        Iterable<CustomerEntity> iterable = customerRepository.findAll();

        ArrayList<Customer> customers = new ArrayList<>();
        for (CustomerEntity customerEntity : iterable) {
            customers.add(new Customer(
                    customerEntity.getId(),
                    customerEntity.getFirstName(),
                    customerEntity.getLastName(),
                    customerEntity.getCustomerNumber(),
                    customerEntity.getStatus());
        }

        return customers;
    }


    public void addBook(Customer customer) {             //сохранить объект в БД
        CustomerEntity customerEntity = new CustomerEntity(null,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getCustomerNumber(),
                customer.getStatus());
        customerRepository.save(customerEntity);
    }



//    public Customer getCustomerByFirstNameAndLastName(String firstName, String lastName) {
//        CustomerEntity customerEntity = customerRepository
//                .findByFirstNameAndLastName(String firstName, String lastName)
//                .orElseThrow(() -> new CustomerNotFoundException("Клиент не найден: id = " + id));
//
//        return new Customer(customerEntity.getId(),
//                customerEntity.getFirstName(),
//                customerEntity.getLastName(),
//                customerEntity.getCustomerNumber(),
//                customerEntity.getStatus());
//    }
}
