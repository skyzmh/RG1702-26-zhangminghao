package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    // ���۲�ѯ
    public String CommList () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

//    	Class.forName("com.mysql.cj.jdbc.Driver");  ////����������
//    	String url = "jdbc:mysql://39.106.22.85:32810/news?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true"; //���ݿ���
//		Connection conn = DriverManager.getConnection(url, "root","root");  //����״̬

        sql = "select * from comments;";

        conn = DBconn.getConnection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        while(rs.next()){
            Comments comm = new Comments();

            comm.setId(rs.getInt("id"));
            comm.setAuthor(rs.getString("author"));
            comm.setContent(rs.getString("content"));
            comm.setZan(rs.getString("zan"));
            comm.setNewsId(rs.getInt("newsId"));

            commlist.add(comm);
        }
        session.put("commlist", commlist);
        if(true){

            return "list";
        }
        else
            return "error";
    }


    /*ɾ������*/
    public String CommDelete () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        //��ѯ����
        sql = "delete from comments where id = "+id+";";
        conn = DBconn.getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.execute(sql);

        String temp = CommList();
        return temp;

    }


    /*ģ����ѯ����*/
    public String CommFind () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        sql = "select * from comments where content like '%"+comments.getContent()+"%';";

        conn = DBconn.getConnection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        while(rs.next()){
            Comments comm = new Comments();

            comm.setId(rs.getInt("id"));
            comm.setAuthor(rs.getString("author"));
            comm.setContent(rs.getString("content"));
            comm.setZan(rs.getString("zan"));
            comm.setNewsId(rs.getInt("newsId"));

            commlist.add(comm);
        }
        session.put("commlist", commlist);
        if(true){

            return "list";
        }
        else
            return "error";
    }
}
