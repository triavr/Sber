package com.example.sber.customer.model;

import lombok.Value;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Value               //добавит в наш класс getters, конструктор, пометит все поля класса private final, добавит методы hashCode, equals и toString
public class Customer {

     Long id;

     String firstName;

     String lastName;

     Long customerNumber;

     String status;

/////////////////////////
     //////////////////////////
          ////////////////////////////

}
