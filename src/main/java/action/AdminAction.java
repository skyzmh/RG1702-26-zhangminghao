package action;

import com.opensymphony.xwork2.ActionContext;
import dao.HbnUtils;
import org.hibernate.Session;
import po.Admin;
import po.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdminAction {
    private Admin admin;
    private Student student;
    List<Student> studentList = new ArrayList<Student>();

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String AdminLogin(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        String name = admin.getName();
        String pass = admin.getPassword();
        String sql = "select * from admin where name = '"+name+"' and password = '"+pass+"'";
        Session hbnSession = HbnUtils.getSession();
        hbnSession.beginTransaction();
        Admin admin = (Admin) hbnSession.createSQLQuery(sql).addEntity(Admin.class).uniqueResult();
        hbnSession.getTransaction().commit();
        if(admin != null){
            session.put("user",admin);
            if(admin.getRoot().equals("root")){
                session.put("identity","超级管理员");
            }
            else {
                session.put("identity","普通管理员");
            }
            return "success";
        }
        else
            return "error";
    }

    public String findAl1(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        String hql="from Student";
        Session hbnSession= HbnUtils.getSession();
        hbnSession.beginTransaction();
        studentList=hbnSession.createQuery(hql).list();
        session.put("stulist",this.studentList);
        hbnSession.getTransaction().commit();
        if(studentList!=null){
            return"success";
        }
        else
            return"error";
    }
}