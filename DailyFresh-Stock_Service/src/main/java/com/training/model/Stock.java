package com.training.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
public class Stock {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "item_id", nullable = false)
	    private Item item;

	    @ManyToOne
	    @JoinColumn(name = "location_id", nullable = false)
	    private Location location;

	    @ManyToOne
	    @JoinColumn(name = "city_id", nullable = false)
	    private City city;

	    private Integer availableQuantity;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Item getItem() {
			return item;
		}

		public void setItem(Item item) {
			this.item = item;
		}

		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}

		public City getCity() {
			return city;
		}

		public void setCity(City city) {
			this.city = city;
		}

		public Integer getAvailableQuantity() {
			return availableQuantity;
		}

		public void setAvailableQuantity(Integer availableQuantity) {
			this.availableQuantity = availableQuantity;
		}

		@Override
		public String toString() {
			return "Stock [id=" + id + ", item=" + item + ", location=" + location + ", city=" + city
					+ ", availableQuantity=" + availableQuantity + "]";
		}

		public Stock(Long id, Item item, Location location, City city, Integer availableQuantity) {
			super();
			this.id = id;
			this.item = item;
			this.location = location;
			this.city = city;
			this.availableQuantity = availableQuantity;
		}

		public Stock() {
			super();
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Stock other = (Stock) obj;
			return Objects.equals(id, other.id);
		}
	    
	    
}
