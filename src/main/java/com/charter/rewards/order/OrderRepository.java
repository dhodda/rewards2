package com.charter.rewards.order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, String> {
    @Query(value = "SELECT SUM(REWARDS) AS REWARDS,  MONTHNAME(CREATED_DATE) AS MONTH FROM ORDER_ACCOUNT WHERE CUSTOMERID=?1 GROUP BY MONTHNAME(CREATED_DATE)", nativeQuery = true)
    List<RewardsDto> findByYearAndMonth(int customerId);
    List<Order> findByCustomerCustomerId(int customerId);

    interface RewardsDto {
        String getRewards();
        String getMonth();

    }
}