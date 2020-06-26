package action;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import com.opensymphony.xwork2.ActionContext;   
import com.opensymphony.xwork2.ActionSupport;


import bean.User;
import dao.DBconn;
import dao.HbnUtils;   

public class UserQAction {    
    private User user;
    
    private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// ×¢²á
    public String register() throws ClassNotFoundException, SQLException{
    	String u = user.getName();
    	String p = user.getPass();
    	ActionContext actionContext = ActionContext.getContext();
    	Map session = actionContext.getSession();
		if (u==null||u.length()==0||p==null||p.length()==0) {
			
			return "error";
		} else {
			String sql = "INSERT INTO user( `name`, `pass`) VALUES ('"+u+"', '"+p+"')";
//			conn = DBconn.getConnection();
//			stmt = conn.prepareStatement(sql);
//			stmt.execute(sql);
			
			ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
			SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
			Session hbnSession = sf.openSession();
			Transaction ts = hbnSession.beginTransaction();

	        User user = (User) hbnSession.createSQLQuery(sql).addEntity(User.class).uniqueResult();
	        hbnSession.getTransaction().commit();
	        
			session.put("user",user); 
			return "reg";
			
		}
    }

    // µÇÂ¼
    public String login () throws SQLException, ClassNotFoundException{
    		
    	String u = user.getName();
    	String p = user.getPass();
    	String sql = "select * from user where name = '"+u+"' and pass = '"+p+"'";
//		conn = DBconn.getConnection();
//		stmt = conn.prepareStatement(sql);
//		rs = stmt.executeQuery();
		
    	
    	ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		Transaction ts = hbnSession.beginTransaction();

        User user = (User) hbnSession.createSQLQuery(sql).addEntity(User.class).uniqueResult();
        hbnSession.getTransaction().commit();
        
    	if(user != null){
    		ActionContext actionContext = ActionContext.getContext();   
    	    Map session = actionContext.getSession();   
    	    String img = user.getImg();
    	    if (img==null||img.length()==0){
    	    	
    	    	img ="./res/static/images/info-img.png";//Ä¬ÈÏÍ·Ïñ
    	    	user.setImg(img);
    	    }
    	    else{
    	    	
    	    	
    	    	user.setImg("./res/file/"+img);
    	    }
    	    user.setId(user.getId());
    	    session.put("user",user); 
			return "log";
    	}
		else 
			return "error";
    }
}