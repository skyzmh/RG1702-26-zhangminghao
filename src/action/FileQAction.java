package action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.News;
import bean.User;
import dao.DBconn;

public class FileQAction {
		private User user;
	    private Connection conn;
		private PreparedStatement stmt;
		private ResultSet rs;
	
	//�����ϴ��ļ��Ĳ���  ʹ��struts2��ܽ��� �ļ��ϴ� ���յĲ��������� upload
		private File upload;
		//��̬��ȡ�ϴ��ļ������� ����ȡ�ļ��ϴ���ԭʼ����   ��Ԫ��name���Ե�ֵ+FileName
		private String uploadFileName;
		//ָ��Ŀ¼
		private String directory;
		public File getUpload() {
			return upload;
		}
		public void setUpload(File upload) {
			this.upload = upload;
		}
		public String getUploadFileName() {
			return uploadFileName;
		}
		public void setUploadFileName(String uploadFileName) {
			this.uploadFileName = uploadFileName;
		}
		public String getDirectory() {
			return directory;
		}
		public void setDirectory(String directory) {
			this.directory = directory;
		}
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String execute() throws IOException{	
			ServletContext servletContext = ServletActionContext.getServletContext();
			String realPath = servletContext.getRealPath("/res/file/"+"/"+uploadFileName);
			System.out.println("���·��="+realPath);	
			//��һ��������ʾ ǰ̨  ������ԭʼ�ļ����ڶ��������Ǵ洢�ļ������·��
			FileUtils.copyFile(upload, new File(realPath));
			return "FileUploade";
		}
		
		public String FileUploade() throws IOException, ClassNotFoundException, SQLException{	
			ActionContext actionContext = ActionContext.getContext();
	    	Map session = actionContext.getSession();
	    	
			ServletContext servletContext = ServletActionContext.getServletContext();
			String realPath = servletContext.getRealPath("/res/file/"+"/"+uploadFileName);
			System.out.println("���·��="+realPath);	
			//��һ��������ʾ ǰ̨  ������ԭʼ�ļ����ڶ��������Ǵ洢�ļ������·��
			FileUtils.copyFile(upload, new File(realPath));
			String sql = "UPDATE user SET `img` = '"+uploadFileName+"' WHERE `id` = "+user.getId()+"";
//			conn = DBconn.getConnection();
//			stmt = conn.prepareStatement(sql);
//			stmt.execute(sql);
//			
			 user.setId(user.getId());
	    	 user.setImg("./res/file/"+uploadFileName);
	    	 user.setName(user.getName());
//	    	 session.put("user",user); 
			
	    	 ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
	 		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
	 		Session hbnSession = sf.openSession();
	 		Transaction ts = hbnSession.beginTransaction();

	 		user = (User) hbnSession.createSQLQuery(sql).addEntity(User.class).uniqueResult();
	         session.put("user",user);
	         hbnSession.getTransaction().commit();
	         
	    	return "FileUploade";
		}
}
