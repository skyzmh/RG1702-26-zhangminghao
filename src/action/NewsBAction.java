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

public class NewsBAction {
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

    // 栏目新闻查询
    public String SortList () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

//    	Class.forName("com.mysql.cj.jdbc.Driver");  ////驱动程序名
//    	String url = "jdbc:mysql://39.106.22.85:32810/news?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true"; //数据库名
//		Connection conn = DriverManager.getConnection(url, "root","root");  //连接状态

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

            newslist.add(news);
        }
        session.put("newslist", newslist);

        //查询栏目
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



    // 所有新闻查询
    public String NewsList () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();


        //查询新闻

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

            newslist.add(news);
        }
        session.put("newslist", newslist);

        //查询栏目
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

    /*删除新闻*/
    public String NewsDelete () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        //查询新闻
        sql = "delete from news where id = "+id+";";
        conn = DBconn.getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.execute(sql);

        String temp = NewsList();
        return temp;
    }
    /*新增栏目*/
    public String SortAdd () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        //查询新闻
        sql = "insert into sort(`sortName`) values('" + sort.getSortName() + "')";
        conn = DBconn.getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.execute(sql);

        String temp = SortList();
        return temp;

    }

    /*更新栏目*/
    public String SortUpdate () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        //查询新闻
        sql = "update sort set sortName='" + sort.getSortName() + "' where id = "+ sort.getId() +";";
        conn = DBconn.getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.execute(sql);

        String temp = SortList();
        return temp;

    }

    /*删除分类*/
    public String SortDelete () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();

        Map session = actionContext.getSession();
        //查询新闻
        sql = "delete from sort where id = "+id+";";
        conn = DBconn.getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.execute(sql);
        String temp = SortList();
        return temp;

    }

    /*新增新闻*/
    public String NewsAdd () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        //查询新闻
        sql = "insert into news (`newsClassId`, `title`, `content`, `createTime`) values(" + news.getNewsClassId() + ", '"+news.getTitle()+"', '"+news.getContent()+"', '2019-12-27')";
        conn = DBconn.getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.execute(sql);
        String temp = NewsList();
        return temp;

    }



    //进入新闻详情页
    public String allnews () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        //查询新闻详情
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
            session.put("news", news);
        }

        //查询这个新闻的评论
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

            return "thisNews";
        }
        else
            return "error";

    }



    /*模糊查询新闻*/
    public String NewsFind () throws SQLException, ClassNotFoundException {


        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        sql = "select * from news where title like '%"+news.getTitle()+"%' or content like '%"+news.getTitle()+"%';";
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

            newslist.add(news);
        }
        session.put("newslist", newslist);
        if(true){

            return "list";
        }
        else
            return "error";
    }


    /*模糊查询分类*/
    public String SortFind () throws SQLException, ClassNotFoundException {


        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        sql = "select * from sort where sortName like '%"+sort.getSortName()+"%';";
        conn = DBconn.getConnection();
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
}
