package bean;


import javax.persistence.*;
@Entity
@Table(name = "sort")
public class Sort {
	private int id;
	private String sortName;
	private String sortLevel;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortLevel() {
		return sortLevel;
	}
	public void setSortLevel(String sortLevel) {
		this.sortLevel = sortLevel;
	}
	
	
}
