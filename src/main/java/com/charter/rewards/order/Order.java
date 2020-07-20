package com.charter.rewards.order;

import com.charter.rewards.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER_ACCOUNT")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;
    @Column(name = "AMOUNT")
    private double amount;
    @ManyToOne
    @JoinColumn(name = "CUSTOMERID")
    private Customer customer;
    @Column(name = "REWARDS")
    private double rewards;
    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    private Date createdDate;
}
