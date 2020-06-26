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
import bean.Sort;
import bean.User;
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

    // ��Ŀ���Ų�ѯ
    public String SortList () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        Sort sort = new Sort();
        if(sortId == 0){
            sql = "select * from news where newsClassId = 1";
        }
        else{
            sql = "select * from news where newsClassId = "+sortId+"";
        }
//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        rs = stmt.executeQuery();
//
//        while(rs.next()){
//            News news = new News();
//
//            news.setId(rs.getInt("id"));
//            news.setAuthor(rs.getString("author"));
//            news.setContent(rs.getString("content"));
//            news.setCreateTime(rs.getString("createTime"));
//            news.setNewsClassId(rs.getInt("newsClassId"));
//            news.setNewsType(rs.getInt("newsType"));
//            news.setTitle(rs.getString("title"));
//
//            newslist.add(news);
//        }
//        session.put("newslist", newslist);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		Transaction ts = hbnSession.beginTransaction();

        newslist=hbnSession.createSQLQuery(sql).addEntity(News.class).list();
        session.put("newslist",this.newslist);
        hbnSession.getTransaction().commit();

        //��ѯ��Ŀ
        sql = "select * from sort";
//        stmt = conn.prepareStatement(sql);
//        rs = stmt.executeQuery();
//
//        while(rs.next()){
//            sort = new Sort();
//            sort.setId(rs.getInt("id"));
//            sort.setSortName((rs.getString("sortName")));
//            sortlist.add(sort);
//        }
//        session.put("sortlist",sortlist);
        
        ts = hbnSession.beginTransaction();
        sortlist=hbnSession.createSQLQuery(sql).addEntity(Sort.class).list();
        session.put("sortlist",this.sortlist);
        hbnSession.getTransaction().commit();

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
//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        rs = stmt.executeQuery();
//        while(rs.next()){
//            News news = new News();
//
//            news.setId(rs.getInt("id"));
//            news.setAuthor(rs.getString("author"));
//            news.setContent(rs.getString("content"));
//            news.setCreateTime(rs.getString("createTime"));
//            news.setNewsClassId(rs.getInt("newsClassId"));
//            news.setNewsType(rs.getInt("newsType"));
//            news.setTitle(rs.getString("title"));
//
//            newslist.add(news);
//        }
//        session.put("newslist", newslist);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		
		Transaction ts = hbnSession.beginTransaction();
        newslist=hbnSession.createSQLQuery(sql).addEntity(News.class).list();
        session.put("newslist",this.newslist);
        hbnSession.getTransaction().commit();

        //��ѯ��Ŀ
        sql = "select * from sort";
//        stmt = conn.prepareStatement(sql);
//        rs = stmt.executeQuery();
//
//        while(rs.next()){
//            Sort sort = new Sort();
//            sort.setId(rs.getInt("id"));
//            sort.setSortName((rs.getString("sortName")));
//            sortlist.add(sort);
//        }
//        session.put("sortlist",sortlist);
        
        hbnSession.beginTransaction();
        sortlist=hbnSession.createSQLQuery(sql).addEntity(Sort.class).list();
        session.put("sortlist",this.sortlist);
        hbnSession.getTransaction().commit();
        if(true){

            return "list";
        }
        else
            return "error";
    }

    /*ɾ������*/
    public String NewsDelete () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        //��ѯ����
        sql = "delete from news where id = "+id+";";
//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        stmt.execute(sql);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		
		Transaction ts = hbnSession.beginTransaction();
        hbnSession.createSQLQuery(sql);

        hbnSession.getTransaction().commit();


        String temp = NewsList();
        return temp;
    }
    /*������Ŀ*/
    public String SortAdd () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        sql = "insert into sort(`sortName`) values('" + sort.getSortName() + "')";
//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        stmt.execute(sql);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		
		Transaction ts = hbnSession.beginTransaction();
        hbnSession.createSQLQuery(sql);

        hbnSession.getTransaction().commit();

        String temp = SortList();
        return temp;

    }

    /*������Ŀ*/
    public String SortUpdate () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        //��ѯ����
        sql = "update sort set sortName='" + sort.getSortName() + "' where id = "+ sort.getId() +";";
//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        stmt.execute(sql);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		
		Transaction ts = hbnSession.beginTransaction();
        hbnSession.createSQLQuery(sql);

        hbnSession.getTransaction().commit();

        String temp = SortList();
        return temp;

    }

    /*ɾ������*/
    public String SortDelete () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();

        Map session = actionContext.getSession();
        //��ѯ����
        sql = "delete from sort where id = "+id+";";
//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        stmt.execute(sql);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		
		Transaction ts = hbnSession.beginTransaction();
        hbnSession.createSQLQuery(sql);

        hbnSession.getTransaction().commit();
        
        String temp = SortList();
        return temp;

    }

    /*��������*/
    public String NewsAdd () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        //��ѯ����
        sql = "insert into news (`newsClassId`, `title`, `content`, `createTime`) values(" + news.getNewsClassId() + ", '"+news.getTitle()+"', '"+news.getContent()+"', '2019-12-27')";
//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        stmt.execute(sql);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		
		Transaction ts = hbnSession.beginTransaction();
        hbnSession.createSQLQuery(sql);

        hbnSession.getTransaction().commit();
        
        String temp = NewsList();
        return temp;

    }



    //������������ҳ
    public String allnews () throws SQLException, ClassNotFoundException {

        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        //��ѯ��������
        sql = "select * from news where id ="+id+"";
//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        rs = stmt.executeQuery();
//
//        while(rs.next()){
//            News news = new News();
//            news.setId(rs.getInt("id"));
//            news.setAuthor(rs.getString("author"));
//            news.setContent(rs.getString("content"));
//            news.setCreateTime(rs.getString("createTime"));
//            news.setNewsClassId(rs.getInt("newsClassId"));
//            news.setNewsType(rs.getInt("newsType"));
//            news.setTitle(rs.getString("title"));
//            session.put("news", news);
//        }
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		Transaction ts = hbnSession.beginTransaction();
		
		News news = (News) hbnSession.createSQLQuery(sql).addEntity(News.class).uniqueResult();
		session.put("news", news);
        hbnSession.getTransaction().commit();
        

        //��ѯ������ŵ�����
        sql = "select * from comments where newsId ="+id+"";
//        stmt = conn.prepareStatement(sql);
//        rs = stmt.executeQuery();
//        while(rs.next()){
//            Comments comments = new Comments();
//
//            comments.setAuthor(rs.getString("author"));
//            comments.setContent(rs.getString("content"));
//            comments.setId(rs.getInt("id"));
//            comments.setNewsId(rs.getInt("newsId"));
//            comments.setZan(rs.getString("zan"));
//
//            commentslist.add(comments);
//        }
//        session.put("commentslist",commentslist);
        
        ts = hbnSession.beginTransaction();
		commentslist=hbnSession.createSQLQuery(sql).addEntity(Comments.class).list();
        session.put("commentslist",this.commentslist);
        hbnSession.getTransaction().commit();
        if(true){

            return "thisNews";
        }
        else
            return "error";

    }



    /*ģ����ѯ����*/
    public String NewsFind () throws SQLException, ClassNotFoundException {


        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        sql = "select * from news where title like '%"+news.getTitle()+"%' or content like '%"+news.getTitle()+"%';";
//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        rs = stmt.executeQuery();
//        while(rs.next()){
//            News news = new News();
//
//            news.setId(rs.getInt("id"));
//            news.setAuthor(rs.getString("author"));
//            news.setContent(rs.getString("content"));
//            news.setCreateTime(rs.getString("createTime"));
//            news.setNewsClassId(rs.getInt("newsClassId"));
//            news.setNewsType(rs.getInt("newsType"));
//            news.setTitle(rs.getString("title"));
//
//            newslist.add(news);
//        }
//        session.put("newslist", newslist);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		
		Transaction ts = hbnSession.beginTransaction();
        newslist=hbnSession.createSQLQuery(sql).addEntity(News.class).list();
        session.put("newslist",this.newslist);
        hbnSession.getTransaction().commit();
        
        if(true){

            return "list";
        }
        else
            return "error";
    }


    /*ģ����ѯ����*/
    public String SortFind () throws SQLException, ClassNotFoundException {


        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        sql = "select * from sort where sortName like '%"+sort.getSortName()+"%';";
//        conn = DBconn.getConnection();
//        stmt = conn.prepareStatement(sql);
//        rs = stmt.executeQuery();
//        while(rs.next()){
//            sort = new Sort();
//            sort.setId(rs.getInt("id"));
//            sort.setSortName((rs.getString("sortName")));
//            sortlist.add(sort);
//        }
//        session.put("sortlist",sortlist);
        
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session hbnSession = sf.openSession();
		
		Transaction ts = hbnSession.beginTransaction();
		sortlist=hbnSession.createSQLQuery(sql).addEntity(Sort.class).list();
        session.put("sortlist",this.sortlist);
        hbnSession.getTransaction().commit();
        
        if(true){

            return "list";
        }
        else
            return "error";
    }
}