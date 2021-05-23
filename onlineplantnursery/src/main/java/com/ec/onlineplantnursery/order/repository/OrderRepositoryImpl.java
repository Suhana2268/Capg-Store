package com.ec.onlineplantnursery.order.repository;

import java.time.LocalDate;
import java.util.List;


import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.onlineplantnursery.customer.entity.Customer;
import com.ec.onlineplantnursery.customer.repository.ICustomerRepositoryImpl;
import com.ec.onlineplantnursery.customer.service.ICustomerServiceImpl;
import com.ec.onlineplantnursery.order.entity.Order;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.IPlantRepositoryImpl;
import com.ec.onlineplantnursery.plant.repository.PlantRepository;
import com.ec.onlineplantnursery.plant.service.IPlantServiceImpl;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.repository.IPlanterRepositoryImpl;
import com.ec.onlineplantnursery.planter.service.IPlanterServiceImpl;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.ISeedRepositoryImpl;
import com.ec.onlineplantnursery.seed.service.ISeedServiceImpl;

public class OrderRepositoryImpl implements IOrderRepository{
	
	@Autowired
	OrderRepository orderRep;
	
	
	@Autowired
	IPlantServiceImpl planRep;
	@Autowired
	ICustomerServiceImpl custRep;
	@Autowired
	IPlanterServiceImpl planterRep;
	@Autowired
	ISeedServiceImpl seedRepo;
	
	
	@Override
	public Order addOrder(Order order, int cid, int pid) {
		Customer cust= custRep.viewCustomer(cid);
		order.setCustomer(cust);
		Planter planter1 = planterRep.viewPlanter(pid);
		order.setPlanter(planter1);
		
		orderRep.save(order);
		return order;
		// TODO Auto-generated method stub
		
		/*
		 * List<Seed> sList = seedRepo.viewAllSeeds(); Plant p1 = null; Seed s1 = null;
		 * LocalDate date = LocalDate.now(); Planter planter1 = null; Customer c1 =
		 * null; double cost = 0; Order ord = null; for(Customer cust : cList) {
		 * if(cust.getCustomerId() == cid) { if(type.equals("plant")) { for(Plant p :
		 * pList) { if(p.getPlantId() == pid) { c1 = cust; cost += p.getPlantCost(); p1
		 * = p; System.out.println(p1); System.out.println(c1);
		 * 
		 * } for(Planter pl : plList) { if(pl.getPlanterId() == plId) { pl.setPlant(p1);
		 * cost += pl.getPlanterCost(); planter1 = pl; System.out.println(planter1); } }
		 * 
		 * 
		 * }
		 * 
		 * } ord = new Order(1, date, type, quantity, cost , c1, planter1); } else
		 * if(type.equals("seed")) {
		 * 
		 * for(Seed s : sList) { if(s.getSeedId() == pid) { c1 = cust; cost +=
		 * s.getSeedsCost(); s1 = s;
		 * 
		 * } for(Planter pl : plList) { if(pl.getPlanterId() == plId) { pl.setSeed(s);
		 * cost += pl.getPlanterCost(); planter1 = pl; } }
		 * 
		 * } ord = new Order(1, date, type, quantity, cost , c1, planter1);
		 * 
		 * }
		 * 
		 * } Order ord1 = ord; System.out.print(ord1); orderRep.save(ord1);
		 * 
		 * return ord1;
		 */
		}
	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		int id = order.getBookingOrderId();
		Optional<Order> or = orderRep.findById(id);
		if(or.isPresent()) {
			Order ord = or.get();
			ord.setCustomer(order.getCustomer());
			//ord.setOrderDate(order.getOrderDate());
			ord.setQuantity(order.getQuantity());
			ord.setTotalCost(order.getTotalCost());
			ord.setBookingOrderId(order.getBookingOrderId());
			ord.setTransactionMode(order.getTransactionMode());
			return orderRep.save(ord);
		}
		return null;
	}


	@Override
	@Transactional
	public Order deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		Order o1 = null;
		List<Order> oList = viewAllOrders();
		for(Order order : oList) {
			if(order.getBookingOrderId() == orderId) {
				isDeleted = true;
				o1 = order;
			}
		}
		orderRep.delete(o1);
		return o1;
	}

	@Override
	public Order viewOrder(int orderId) {
		// TODO Auto-generated method stub
		return orderRep.findById(orderId).get();
	}

	@Override
	public List<Order> viewAllOrders() {
		// TODO Auto-generated method stub
		return orderRep.findAll();
	}
	
	
	
}
