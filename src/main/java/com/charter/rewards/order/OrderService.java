package com.charter.rewards.order;

import com.charter.rewards.Util;
import com.charter.rewards.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public void addOrder(Order order) {
        customerRepository.save(order.getCustomer());
        order.setRewards(Util.calcRewardsPerTx(order.getAmount()));
        orderRepository.save(order);
    }

    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    public List<Order> getAllOrdersPerCustomer(int customerId) {
        return orderRepository.findByCustomerCustomerId(customerId);
    }

    public double getTotalRewardsPerCustomer(int customerId) {
        return this.getAllOrdersPerCustomer(customerId).stream().map(Order::getRewards)
                .reduce(0.0, Double::sum);
    }

    public List<OrderRepository.RewardsDto> getRewardsPerMonthPerCustomer(int customerId) {
        return orderRepository.findByYearAndMonth(customerId);
    }


}
