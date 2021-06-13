package es.deusto.spq.jdo;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vehiculo {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	protected long id;

	protected String name = null;

	protected String description = null;

	protected long price = 0;

	public Vehiculo(long id, String name, String description, long price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
	
	
}
