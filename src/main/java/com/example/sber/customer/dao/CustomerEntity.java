package com.example.sber.customer.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data                        // добавляет getters и setters
@NoArgsConstructor           // конструкторы без параметров
@AllArgsConstructor          // конструкторы c параметрами
@Entity
@Table(name = "customers")       // название таблицы в базе данных
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String firstName;

    String lastName;

    Long customerNumber;

    String status;

    //    @ManyToOne(cascade= CascadeType.ALL)
//    private Address customerAddress;
//
//    @OneToOne(cascade=CascadeType.ALL)
//    private Contact contactDetails;
//
//    @Temporal(TemporalType.TIME)
//    private Date createDateTime;
//
//    @Temporal(TemporalType.TIME)
//    private Date updateDateTime;
}
