package boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="tickets")
public class Ticket implements Serializable  {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45)
	private String name;
	@Column 
	private int ref;
	@Column (length=45)
	private String bank;
	@Column (length=45)
	private String counter;
	public Ticket(String name, int ref, String bank, String counter) {
		super();
		this.name = name;
		this.ref = ref;
		this.bank = bank;
		this.counter = counter;
	}
	public Ticket() {
		this("",0,"","");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	
	public String getCounter() {
		return counter;
	}
	public void setCounter(String counter) {
		this.counter = counter;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", name=" + name + ", ref=" + ref + ", bank=" + bank + ", counter=" + counter + "]";
	}
	
	
	
	
	
}
