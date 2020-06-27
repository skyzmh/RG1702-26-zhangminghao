package action;
import java.util.Map;
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

	// 注册
    public String register() throws ClassNotFoundException, SQLException{
    	String u = user.getName();
    	String p = user.getPass();
    	ActionContext actionContext = ActionContext.getContext();
    	Map session = actionContext.getSession();
		if (u==null||u.length()==0||p==null||p.length()==0) {
			
			return "error";
		} else {
			String sql = "INSERT INTO user( `name`, `pass`) VALUES ('"+u+"', '"+p+"')";
			conn = DBconn.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.execute(sql);
			session.put("user",user); 
			return "reg";
			
		}
    }

    // 登录
    public String login () throws SQLException, ClassNotFoundException{
    	
//    	Class.forName("com.mysql.cj.jdbc.Driver");  ////驱动程序名
//    	String url = "jdbc:mysql://39.106.22.85:32810/student?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true"; //数据库名 
//		Connection conn = DriverManager.getConnection(url, "root","root");  //连接状态
//		
    	String u = user.getName();
    	String p = user.getPass();
    	String sql = "select * from user where name = '"+u+"' and pass = '"+p+"'";
		conn = DBconn.getConnection();
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		
//		while(rs.next()){
//			System.out.println(rs.getString("username"));
//		}
		
    	if(rs.next()){
    		ActionContext actionContext = ActionContext.getContext();   
    	    Map session = actionContext.getSession();   
    	    String img = rs.getString("img");
    	    if (img==null||img.length()==0){
    	    	
    	    	img ="./res/static/images/info-img.png";//默认头像
    	    	user.setImg(img);
    	    }
    	    else{
    	    	
    	    	
    	    	user.setImg("./res/file/"+img);
    	    }
    	    user.setId(rs.getInt("id"));
    	    session.put("user",user); 
			return "log";
    	}
		else 
			return "error";
    }
}