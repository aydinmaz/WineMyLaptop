package it.finsoft.winebook.model;

public class Wine {
	private Long id;
	private String name;
	private int quantity;
	private int total;
	private int reserved;
	private int available;

	public Wine() {
		super();
	}

	public Wine(String name, int quantity, int total, int reserved, int available) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.total = total;
		this.reserved = reserved;
		this.available = available;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}