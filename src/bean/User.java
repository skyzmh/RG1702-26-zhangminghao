package bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
	private int id;
    private String name;
    private String pass;
    private int privileges;
    private String img;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getPrivileges() {
		return privileges;
	}
	public void setPrivileges(int privileges) {
		this.privileges = privileges;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
    

    
    
}