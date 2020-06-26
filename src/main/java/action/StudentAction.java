package action;

import com.opensymphony.xwork2.ActionContext;
import dao.HbnUtils;
import org.hibernate.Session;
import po.Admin;
import po.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentAction {
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

    public String StudentLogin(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        String name = student.getName();
        String pass = student.getPassword();
        String sql = "select * from student where name = '"+name+"' and password = '"+pass+"'";
        Session hbnSession = HbnUtils.getSession();
        hbnSession.beginTransaction();
        Student student = (Student) hbnSession.createSQLQuery(sql).addEntity(Student.class).uniqueResult();
        hbnSession.getTransaction().commit();
        if(student != null){
            session.put("user",student);
            session.put("identity","学生");
            return "success";
        }
        else
            return "error";
    }

    public String StuList(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        String sql="select * from student";
        Session hbnSession= HbnUtils.getSession();
        hbnSession.beginTransaction();
        studentList=hbnSession.createSQLQuery(sql).addEntity(Student.class).list();
        session.put("studentList",this.studentList);
        hbnSession.getTransaction().commit();
        if(studentList!=null){
            return"success";
        }
        else
            return"error";

    }
    public String StuAdd(){
        try {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            Session hbnSession= HbnUtils.getSession();
            hbnSession.beginTransaction();
            hbnSession.save(student);
            hbnSession.getTransaction().commit();
            return"success";
        } catch (Exception e) {
            e.printStackTrace();
            return"error";
        }
    }

    public String StuUpdate(){
        try {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            Session hbnSession= HbnUtils.getSession();
            hbnSession.beginTransaction();
            hbnSession.saveOrUpdate(student);
            hbnSession.getTransaction().commit();
            return"success";
        } catch (Exception e) {
            e.printStackTrace();
            return"error";
        }
    }
    public String StuDelete(){
        try {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            Session hbnSession= HbnUtils.getSession();
            hbnSession.beginTransaction();
            hbnSession.delete(student);
            hbnSession.getTransaction().commit();
            return"success";
        } catch (Exception e) {
            e.printStackTrace();
            return"error";
        }
    }

    public String StuSearch(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        String name = student.getName();
        System.out.println(name);
        String sql="select * from student where name like '%"+name+"%'";
        Session hbnSession= HbnUtils.getSession();
        hbnSession.beginTransaction();
        studentList=hbnSession.createSQLQuery(sql).addEntity(Student.class).list();
        session.clear();
        session.put("studentList",this.studentList);
        hbnSession.getTransaction().commit();
        if(studentList!=null){
            return"success";
        }
        else
            return"error";
    }
}
