package com.restaurant.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer",
"handler"})
@Table(name="order_e")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotBlank
    private String billNo;
    private int quantity;
	@NotBlank
    private String orderedTime;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    @JsonIgnore
    private List<MenuEntity> menu;
    
    
    

    public OrderEntity() {
		super();
	}

	public OrderEntity(Long id, String billNo, int quantity, String orderedTime) {
		super();
		this.id = id;
		this.billNo = billNo;
		this.quantity = quantity;
		this.orderedTime = orderedTime;
	}

	public void setMenu(List<MenuEntity> menu) {
		this.menu = menu;
	}

	public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

	public void setOrderedTime(String orderedTime) {
		this.orderedTime = orderedTime;
	}

	public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(Timestamp orderedTime) {
        this.orderedTime = orderedTime.toString();
    }

	@Override
	public int hashCode() {
		return Objects.hash(billNo, id, menu, orderedTime, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderEntity other = (OrderEntity) obj;
		return Objects.equals(billNo, other.billNo) && id == other.id && Objects.equals(menu, other.menu)
				&& Objects.equals(orderedTime, other.orderedTime) && quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", billNo=" + billNo + ", menu=" + menu + ", quantity=" + quantity
				+ ", orderedTime=" + orderedTime + "]";
	}


}