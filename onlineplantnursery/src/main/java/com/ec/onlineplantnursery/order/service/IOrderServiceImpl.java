package com.ec.onlineplantnursery.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.order.entity.Order;
import com.ec.onlineplantnursery.order.repository.OrderRepositoryImpl;

@Service
public class IOrderServiceImpl implements IOrderService{

	@Autowired
	OrderRepositoryImpl ord;
	
	

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return ord.updateOrder(order);
	}

	@Override
	public Order deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		return ord.deleteOrder(orderId);
	}

	@Override
	public Order viewOrder(int orderId) {
		// TODO Auto-generated method stub
		return ord.viewOrder(orderId);
	}

	@Override
	public List<Order> viewAllOrders() {
		// TODO Auto-generated method stub
		return ord.viewAllOrders();
	}

	@Override
	public Order addOrder(Order order, int cid,int pid) {
		// TODO Auto-generated method stub
		return ord.addOrder(order, cid,pid);
	}

}
