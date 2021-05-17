package com.capg.store.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Store")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockId;
	@NotEmpty(message = "The name of the stock cannot be null")
	@Size(min = 3, max = 15, message = "Invalid stock Name")
	@Pattern(regexp="^[A-Za-z]*",message = "Invalid Input")
	private String stockName;
	@Positive(message = "The price cannot be negative")
	private int stockPrice;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Transaction_type", referencedColumnName = "transactionType")
	private Transaction transaction;

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(int stockId,
			@NotEmpty(message = "The name of the stock cannot be null") @Size(min = 3, max = 15, message = "Invalid stock Name") @Pattern(regexp = "^[A-Za-z]*", message = "Invalid Input") String stockName,
			@Positive(message = "The price cannot be negative") int stockPrice, Transaction transaction) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.transaction = transaction;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", stockPrice=" + stockPrice
				+ ", transaction=" + transaction + "]";
	}

	
	

}