package boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="seqs")
public class Seq implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column (length=45)
	private String sequence;
	@Column(length=45)
	private String propertyKey;
	@Column(length=45)
	private String propertyVal;
	private boolean uniq;
	public Seq(String sequence, String propertyKey, String propertyVal, boolean uniq) {
		super();
		this.sequence = sequence;
		this.propertyKey = propertyKey;
		this.propertyVal = propertyVal;
		this.uniq = uniq;
	}
	public Seq() {
		this("","","",false);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getPropertyKey() {
		return propertyKey;
	}
	public void setPropertyKey(String propertyKey) {
		this.propertyKey = propertyKey;
	}
	public String getPropertyVal() {
		return propertyVal;
	}
	public void setPropertyVal(String propertyVal) {
		this.propertyVal = propertyVal;
	}
	public boolean isUniq() {
		return uniq;
	}
	public void setUniq(boolean uniq) {
		this.uniq = uniq;
	}
	@Override
	public String toString() {
		return "Seq [id=" + id + ", sequence=" + sequence + ", propertyKey=" + propertyKey + ", propertyVal="
				+ propertyVal + ", uniq=" + uniq + "]";
	}
	
	
	


	
	
	
}
