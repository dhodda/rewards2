package com.charter.rewards.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/orders")
    public List<Order> getAll() {
        return orderService.getAll();
    }
    @GetMapping("/{customerId}/orders")
    public List<Order> getAll(@PathVariable int customerId) {
        return orderService.getAllOrdersPerCustomer(customerId);
    }
    @GetMapping("/{customerId}/totalrewards")
    public double getTotalRewardsPerCustomer(@PathVariable int customerId) {
        return orderService.getTotalRewardsPerCustomer(customerId);
    }

    @GetMapping("/{customerId}/permonth")
    public List<OrderRepository.RewardsDto> getRewardsPerMonthPerCustomer(@PathVariable int customerId) {
        return orderService.getRewardsPerMonthPerCustomer(customerId);
    }

}
