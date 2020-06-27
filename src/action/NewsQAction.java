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
import bean.Sort;
import dao.DBconn;

public class NewsQAction {
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
	
	List<News> newslist=new ArrayList<News>();
	List<Sort> sortlist=new ArrayList<Sort>();
	List<Comments> commentslist=new ArrayList<Comments>();

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public List<News> getNewslist() {
		return newslist;
	}

	public void setNewslist(List<News> newslist) {
		this.newslist = newslist;
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

	// ��Ŀ���Ų�ѯ
    public String NewsSort () throws SQLException, ClassNotFoundException {
    	
		ActionContext actionContext = ActionContext.getContext();   
		Map session = actionContext.getSession();   
		             	
//    	Class.forName("com.mysql.cj.jdbc.Driver");  ////����������
//    	String url = "jdbc:mysql://39.106.22.85:32810/news?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true"; //���ݿ��� 
//		Connection conn = DriverManager.getConnection(url, "root","root");  //����״̬

		Sort sort = new Sort();
		if(sortId == 0){
			sql = "select * from news where newsClassId = 1";
		}
		else{
			sql = "select * from news where newsClassId = "+sortId+"";
		}
		conn = DBconn.getConnection();
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();

		while(rs.next()){
			News news = new News();
			
			news.setId(rs.getInt("id"));
			news.setAuthor(rs.getString("author"));
			news.setContent(rs.getString("content"));
			news.setCreateTime(rs.getString("createTime"));
			news.setNewsClassId(rs.getInt("newsClassId"));
			news.setNewsType(rs.getInt("newsType"));
			news.setTitle(rs.getString("title"));
			news.setImg(rs.getString("img"));
			
			newslist.add(news);		
		}
		session.put("newslist", newslist); 
		
		//��ѯ��Ŀ
		sql = "select * from sort";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();

		while(rs.next()){	
			sort = new Sort();
			sort.setId(rs.getInt("id"));	
			sort.setSortName((rs.getString("sortName")));
			sortlist.add(sort);		
		}
		session.put("sortlist",sortlist); 
		
    	if(true){

			return "list";
    	}
		else 
			return "error";
    }    
    
    

	// �������Ų�ѯ
    public String NewsList () throws SQLException, ClassNotFoundException {
    	
		ActionContext actionContext = ActionContext.getContext();   
		Map session = actionContext.getSession(); 
		
		
		//��ѯ����

		sql = "select * from news ";
		conn = DBconn.getConnection();
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()){
			News news = new News();
			
			news.setId(rs.getInt("id"));
			news.setAuthor(rs.getString("author"));
			news.setContent(rs.getString("content"));
			news.setCreateTime(rs.getString("createTime"));
			news.setNewsClassId(rs.getInt("newsClassId"));
			news.setNewsType(rs.getInt("newsType"));
			news.setTitle(rs.getString("title"));
			news.setImg(rs.getString("img"));
			
			newslist.add(news);		
		}
		session.put("newslist", newslist); 
		
		//��ѯ��Ŀ
		sql = "select * from sort";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();

		while(rs.next()){	
			Sort sort = new Sort();
			sort.setId(rs.getInt("id"));	
			sort.setSortName((rs.getString("sortName")));
			sortlist.add(sort);		
		}
		session.put("sortlist",sortlist); 
    	if(true){

			return "list";
    	}
		else 
			return "error";
    }
    
    //������������ҳ
    public String NewsDetails () throws SQLException, ClassNotFoundException {
    	
	   	ActionContext actionContext = ActionContext.getContext();   
	    Map session = actionContext.getSession();   
		
	    //��ѯ��������
	   	sql = "select * from news where id ="+id+"";
		conn = DBconn.getConnection();
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		while(rs.next()){
			News news = new News();
			news.setId(rs.getInt("id"));
			news.setAuthor(rs.getString("author"));
			news.setContent(rs.getString("content"));
			news.setCreateTime(rs.getString("createTime"));
			news.setNewsClassId(rs.getInt("newsClassId"));
			news.setNewsType(rs.getInt("newsType"));
			news.setTitle(rs.getString("title"));
			news.setImg(rs.getString("img"));
			
			session.put("news", news);
		}
		
		//��ѯ������ŵ�����
		sql = "select * from comments where newsId ="+id+"";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()){	
			Comments comments = new Comments();

			comments.setAuthor(rs.getString("author"));
			comments.setContent(rs.getString("content"));
			comments.setId(rs.getInt("id"));
			comments.setNewsId(rs.getInt("newsId"));
			comments.setZan(rs.getString("zan"));
			
			commentslist.add(comments);		
		}
		session.put("commentslist",commentslist); 
		if(true){
						
			return "details";
		}
		else 
			return "error";
		
	   }
    
 // add
    public String NewsSer () throws SQLException, ClassNotFoundException {
    	ActionContext actionContext = ActionContext.getContext();   
		Map session = actionContext.getSession();   
		             	
//    	Class.forName("com.mysql.cj.jdbc.Driver");  ////����������
//    	String url = "jdbc:mysql://39.106.22.85:32810/news?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true"; //���ݿ��� 
//		Connection conn = DriverManager.getConnection(url, "root","root");  //����״̬

//		Sort sort = new Sort();
		String k = news.getTitle();
		if(k == null){
			sql = "select * from news where newsClassId = 1";
		}
		else{
			sql = "select * from news where title like '%"+k+"%'";
		}
		conn = DBconn.getConnection();
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();

		while(rs.next()){
			News news = new News();
			
			news.setId(rs.getInt("id"));
			news.setAuthor(rs.getString("author"));
			news.setContent(rs.getString("content"));
			news.setCreateTime(rs.getString("createTime"));
			news.setNewsClassId(rs.getInt("newsClassId"));
			news.setNewsType(rs.getInt("newsType"));
			news.setTitle(rs.getString("title"));
			news.setImg(rs.getString("img"));
			
			newslist.add(news);		
		}
		session.put("newslist", newslist); 
		
		//��ѯ��Ŀ
		sql = "select * from sort";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();

		while(rs.next()){	
			sort = new Sort();
			sort.setId(rs.getInt("id"));	
			sort.setSortName((rs.getString("sortName")));
			sortlist.add(sort);		
		}
		session.put("sortlist",sortlist); 
		
    	if(true){

			return "NewsSer";
    	}
		else 
			return "error";
    }
}
