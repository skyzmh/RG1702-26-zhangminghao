package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import bean.Comments;
import bean.News;
import bean.Sort;
import dao.DBconn;

public class CommentsQAction {
	private News news;
	private Comments comments;

	private String sql;
    private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
//	HttpServletResponse response = ServletActionContext.getResponse();
	PrintWriter out=null;
	
	List<News> newslist=new ArrayList<News>();
	List<Comments> commentslist=new ArrayList<Comments>();
	
	
	
    public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public List<News> getNewslist() {
		return newslist;
	}

	public void setNewslist(List<News> newslist) {
		this.newslist = newslist;
	}

	public List<Comments> getCommentslist() {
		return commentslist;
	}

	public void setCommentslist(List<Comments> commentslist) {
		this.commentslist = commentslist;
	}



	//����������������ҳ
    public String CommentsAdd() throws SQLException, ClassNotFoundException, IOException {
    	
	   	ActionContext actionContext = ActionContext.getContext();   
	    Map session = actionContext.getSession();  
	    
		
		//��������
	    int newsId = comments.getNewsId();
    	String content = comments.getContent();
    	String author = comments.getAuthor();

		if (content==null||content.length()==0) {
//			response.setContentType("text/html;charset=UTF-8");
//
//			response.setCharacterEncoding("UTF-8");//��ֹ��������Ϣ��������
//			out = response.getWriter();
			out.print("<script>alert('��Ǹ,��������յ�����Ŷ')</script>");
		    out.print("<script>window.location.href='/news/NewsDetails?id="+newsId+"'</script>");
//		    out.flush();
		    out.close();
//			return "error";
			return "CommentsAdd";
		} else {
			String sql = "INSERT INTO comments(content,author,newsId) VALUES ('"+content+"', '"+author+"', "+newsId+")";
			conn = DBconn.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.execute(sql);
			
			//��ѯ������ŵ�����
			sql = "select * from comments where newsId ="+newsId+" order by id desc;";
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
			return "CommentsAdd";
			
		}
    }
	

}
