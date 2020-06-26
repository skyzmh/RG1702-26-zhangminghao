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

public class CommentsBAction {
    private Sort sort;
    private News news;
    private Comments comments;
    private int id;
    private int sortId;

    String sql ;
    private Connection conn;
    private PreparedStatement stmt;
    private PreparedStatement sortstmt;
    private ResultSet rs;

    List<Comments> commlist=new ArrayList<Comments>();
    List<Sort> sortlist=new ArrayList<Sort>();
    List<Comments> commentslist=new ArrayList<Comments>();

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public List<Comments> getCommlist() {
        return commlist;
    }

    public void setCommlist(List<Comments> userlist) {
        this.commlist = commlist;
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

    // 评论查询
    public String CommList () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();


        sql = "select * from comments;";

//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        rs = stmt.executeQuery();
//
//        while(rs.next()){
//            Comments comm = new Comments();
//
//            comm.setId(rs.getInt("id"));
//            comm.setAuthor(rs.getString("author"));
//            comm.setContent(rs.getString("content"));
//            comm.setZan(rs.getString("zan"));
//            comm.setNewsId(rs.getInt("newsId"));
//
//            commlist.add(comm);
//        }
//        
//        session.put("commlist", commlist);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		Transaction ts = hbnSession.beginTransaction();
		
		commlist=hbnSession.createSQLQuery(sql).addEntity(Comments.class).list();
        session.put("commlist",this.commlist);
        hbnSession.getTransaction().commit();
        if(true){

            return "list";
        }
        else
            return "error";
    }


    /*删除评论*/
    public String CommDelete () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        
        sql = "delete from comments where id = "+id+";";
//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        stmt.execute(sql);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		Transaction ts = hbnSession.beginTransaction();
		
		hbnSession.createSQLQuery(sql);

        hbnSession.getTransaction().commit();

        String temp = CommList();
        return temp;

    }


    /*模糊查询评论*/
    public String CommFind () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        sql = "select * from comments where content like '%"+comments.getContent()+"%';";

//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        rs = stmt.executeQuery();
//
//        while(rs.next()){
//            Comments comm = new Comments();
//
//            comm.setId(rs.getInt("id"));
//            comm.setAuthor(rs.getString("author"));
//            comm.setContent(rs.getString("content"));
//            comm.setZan(rs.getString("zan"));
//            comm.setNewsId(rs.getInt("newsId"));
//
//            commlist.add(comm);
//        }
//        session.put("commlist", commlist);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		Transaction ts = hbnSession.beginTransaction();
		
		commlist=hbnSession.createSQLQuery(sql).addEntity(Comments.class).list();
        session.put("commlist",commlist);
        hbnSession.getTransaction().commit();
        if(true){

            return "list";
        }
        else
            return "error";
    }
}
