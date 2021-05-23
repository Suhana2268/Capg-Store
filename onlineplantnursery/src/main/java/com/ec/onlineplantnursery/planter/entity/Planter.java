package com.ec.onlineplantnursery.planter.entity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ec.onlineplantnursery.customer.entity.Customer;
import com.ec.onlineplantnursery.order.entity.Order;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.seed.entity.Seed;

@Entity
@Table(name = "Planter")
public class Planter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planterId;
	private float planterheight;
	private int planterCapacity;
	private int drinageHoles;
	private int planterColor;
	private String planterShape;
	private int planterStock;
	private int planterCost;

	
	/**@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Order_Info", nullable = false)
    private Order order;**/

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Plant_info", referencedColumnName = "plantId")
	private Plant plant;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Seed_Info", referencedColumnName = "seedId")
	private Seed seed;


	public Planter() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Planter(Integer planterId, float planterheight, int planterCapacity, int drinageHoles, int planterColor,
			String planterShape, int planterStock, int planterCost, Plant plant, Seed seed,int type) {
		super();
		this.planterId = planterId;
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
		if(type==3) {this.plant = plant;
		this.seed = seed;
		}
		else if(type==2) {
			this.seed=seed;
		}
		else {
			this.plant=plant;
		}
	}

	

	public Planter(Integer planterId, float planterheight, int planterCapacity, int drinageHoles, int planterColor,
			String planterShape, int planterStock, int planterCost, Plant plant) {
		super();
		this.planterId = planterId;
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
		this.plant = plant;
	}

	

	public Planter(Integer planterId, float planterheight, int planterCapacity, int drinageHoles, int planterColor,
			String planterShape, int planterStock, int planterCost, Seed seed) {
		super();
		this.planterId = planterId;
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
		this.seed = seed;
	}


	public Integer getPlanterId() {
		return planterId;
	}


	public void setPlanterId(Integer planterId) {
		this.planterId = planterId;
	}


	public float getPlanterheight() {
		return planterheight;
	}


	public void setPlanterheight(float planterheight) {
		this.planterheight = planterheight;
	}


	public int getPlanterCapacity() {
		return planterCapacity;
	}


	public void setPlanterCapacity(int planterCapacity) {
		this.planterCapacity = planterCapacity;
	}


	public int getDrinageHoles() {
		return drinageHoles;
	}


	public void setDrinageHoles(int drinageHoles) {
		this.drinageHoles = drinageHoles;
	}


	public int getPlanterColor() {
		return planterColor;
	}


	public void setPlanterColor(int planterColor) {
		this.planterColor = planterColor;
	}


	public String getPlanterShape() {
		return planterShape;
	}


	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}


	public int getPlanterStock() {
		return planterStock;
	}


	public void setPlanterStock(int planterStock) {
		this.planterStock = planterStock;
	}


	public int getPlanterCost() {
		return planterCost;
	}


	public void setPlanterCost(int planterCost) {
		this.planterCost = planterCost;
	}


	public Plant getPlant() {
		return plant;
	}


	public void setPlant(Plant plant) {
		this.plant = plant;
	}


	public Seed getSeed() {
		return seed;
	}


	public void setSeed(Seed seed) {
		this.seed = seed;
	}


	@Override
	public String toString() {
		return "Planter [planterId=" + planterId + ", planterheight=" + planterheight + ", planterCapacity="
				+ planterCapacity + ", drinageHoles=" + drinageHoles + ", planterColor=" + planterColor
				+ ", planterShape=" + planterShape + ", planterStock=" + planterStock + ", planterCost=" + planterCost
				+ ", plant=" + plant + ", seed=" + seed + "]";
	}


	
	
}
