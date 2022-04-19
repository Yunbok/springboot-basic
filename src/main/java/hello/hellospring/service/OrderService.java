package hello.hellospring.service;

import hello.hellospring.domain.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
