package com.icwd.hiber;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import com.icwd.hiber.entities.Student;
import com.icwd.hiber.util.Hibernateutil;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

i

public class StudentService {

	private SessionFactory sessionFactory=Hibernateutil.getSessionFactory();
	//save
	public void saveStudent(Student student ) {
		
		try(Session session = sessionFactory.openSession()) {
			
			Transaction beginTransaction= session.beginTransaction();
			
			session.persist(student);
			beginTransaction.commit();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//get by id 
	
	public Student getById(Long studentId) {
		
		try(Session session = sessionFactory.openSession()) {
			Student student=session.get(Student.class,studentId);
			return student;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	//update
	
	public Student updateStudent(long studentId,Student student) {
		
		try(Session session = sessionFactory.openSession()) {
			Transaction transaction= session.beginTransaction();
		Student oldStudent=session.get(Student.class,studentId);
		
		if(oldStudent!=null) {
			oldStudent.setName(student.getName());
			oldStudent.setFathername(student.getFathername());
			
			//.....update any other info
			
			oldStudent=	session.merge(oldStudent);
			
			
		}
		
		transaction.commit();
		return oldStudent;
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//delete  student
	
	public void DeleteStudent(long studentId) {
		
		try(Session session = sessionFactory.openSession()){
			Transaction transaction= session.beginTransaction();
			
			Student student=	session.get(Student.class,studentId);
			
			if(student!=null) {
				session.remove(student);
			}
			transaction.commit();
		}
	}
	
	//HQL[JPA]-->native query
	//database independent
	
	//get all student using hql
	
	public List<Student> getAllStudentsHQL(){
		try(Session session = sessionFactory.openSession()) {
			String getHQL ="from Student";
			Query<Student> query=session.createQuery(getHQL,Student.class);
			return query.list();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//get student by name
	
	public Student getStudentByNameHQL(String name) {
		
		try(Session session = sessionFactory.openSession()) {
			
			String getByNameHql="from Student where name=:studentName";
			
			Query<Student> query=session.createQuery(getHQL,Student.class);
			 
			query.setParameter("studentName",name);
			return query.uniqueResult();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//queries using criteria api
	public List<Student> getStudentsByCollegeCriteria(String college){
		try(Session session = sessionFactory.openSession()) {
			
			HibernateCriteriaBuilder  criteriaBuilder = session.getCriteriaBuilder();
			
		CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
			
	Root<Student> root=	query.from(Student.class);
		
	query
	.select(root)
	.where( 
			criteriaBuilder.equal(root.get("college"), college));
	
	Query<Student> query2 =session.createQuery(query);
	
	
	return query2.getResultList();
	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<Student> getStudentWithPagination( int pageNo, int pageSize){
		
		try(Session session = sessionFactory.openSession()){
			
			String pagiQuery="from Student";
			Query<Student> query =session.createQuery(pagiQuery,Student.class);
			
			query.setFirstResult((pageNo -1)*pageSize);
			
			query.setMaxResults(pageSize);
			return query.list();
			
			
		}
		
		
	}
	
}
