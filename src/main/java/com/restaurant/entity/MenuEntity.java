package com.restaurant.entity;



import java.util.Objects;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="MENU_TB")
public class MenuEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	@Column(name="M_NAME")
	@NotBlank
	private String name;
	@NotBlank
    private String description;
	@NotBlank
    private String image;
	@NotBlank
    private String price;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	//@JoinColumn(name = "order")
     private OrderEntity order;

    

    public MenuEntity() {
		super();
	}

	public MenuEntity(Long id, String name, String description, String image, String price, OrderEntity order) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.order = order;
	}
	
	public MenuEntity(Long id, String name, String description, String image, String price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;

	}

	@Override
	public String toString() {
		return "MenuEntity [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image
				+ ", price=" + price + ", order=" + order + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, image, name, order, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuEntity other = (MenuEntity) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(image, other.image) && Objects.equals(name, other.name)
				&& Objects.equals(order, other.order) && price == other.price;
	}
	
	
}

	