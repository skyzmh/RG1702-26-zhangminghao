package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;

import bean.Comments;
import bean.News;
import bean.User;
import bean.Sort;
import dao.DBconn;

public class UserBAction {
    private Sort sort;
    private News news;
    private User user;
    private Comments comments;
    private int id;
    private int sortId;

    String sql ;
    private Connection conn;
    private PreparedStatement stmt;
    private PreparedStatement sortstmt;
    private ResultSet rs;

    List<User> userlist=new ArrayList<User>();
    List<Sort> sortlist=new ArrayList<Sort>();
    List<Comments> commentslist=new ArrayList<Comments>();

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public List<Sort> getSortlist() {
        return sortlist;
    }

    public void setSortlist(List<Sort> sortlist) {
        this.sortlist = sortlist;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public List<Comments> getCommentslist() {
        return commentslist;
    }

    public void setCommentslist(List<Comments> commentslist) {
        this.commentslist = commentslist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // 用户查询
    public String UserList () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        sql = "select * from user;";
//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        rs = stmt.executeQuery();
//
//        while(rs.next()){
//            User user = new User();
//
//            user.setId(rs.getInt("id"));
//            user.setName(rs.getString("name"));
//            user.setPass(rs.getString("pass"));
//            user.setImg(rs.getString("img"));
//            user.setPrivileges(rs.getInt("privileges"));
//
//            userlist.add(user);
//        }
//        session.put("userlist", userlist);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		Transaction ts = hbnSession.beginTransaction();

		userlist=hbnSession.createSQLQuery(sql).addEntity(User.class).list();
        session.put("userlist",this.userlist);
        hbnSession.getTransaction().commit();
        
        if(true){

            return "list";
        }
        else
            return "error";
    }

    public String UserDelete () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        sql = "delete from user where id = "+user.getId()+";";
//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        stmt.execute(sql);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		Transaction ts = hbnSession.beginTransaction();

		hbnSession.createSQLQuery(sql);

        hbnSession.getTransaction().commit();

        String temp = UserList();

        return temp;
    }

    /*模糊查询用户*/
    public String UserFind () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        sql = "select * from `user` where name like '%"+user.getName()+"%';";

//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        rs = stmt.executeQuery();
//
//        while(rs.next()){
//            User user = new User();
//
//            user.setId(rs.getInt("id"));
//            user.setName(rs.getString("name"));
//            user.setPass(rs.getString("pass"));
//            user.setImg(rs.getString("img"));
//            user.setPrivileges(rs.getInt("privileges"));
//
//            userlist.add(user);
//        }
//        session.put("userlist", userlist);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		Transaction ts = hbnSession.beginTransaction();

		userlist=hbnSession.createSQLQuery(sql).addEntity(User.class).list();
        session.put("userlist",this.userlist);
        hbnSession.getTransaction().commit();
        
        if(true){

            return "list";
        }
        else
            return "error";
    }
}
