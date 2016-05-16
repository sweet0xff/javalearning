package org.xxx.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.xxx.model.entity.persist.Classtype;
import org.xxx.model.entity.persist.Students;
import org.xxx.model.entity.persist.StudentsClasstype;

/**
 * A data access object (DAO) providing persistence and search support for
 * Students entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.xxx.model.entity.persist.Students
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class StudentsDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StudentsDAO.class);
	// property constants
	public static final String SNAME = "sname";
	public static final String SSEX = "ssex";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}
	

	//获取所有学生
	public List<StudentsClasstype> doFindAllStudents(){
		List<StudentsClasstype> slist = new ArrayList<StudentsClasstype>();
		List<Object[]> list = getCurrentSession()
			               .createQuery("from Students s inner join s.classtype order by s.sid ")
			               .list();
		for (Object[] o : list) {
			Students students  = (Students) o[0];
			Classtype classtype = (Classtype) o[1];
			StudentsClasstype sc= new StudentsClasstype();
			sc.setStudents(students);
			sc.setClasstype(classtype);

			slist.add(sc);
		}
		return slist;
	}
	
	//查找
	public Students doFindStudentsById(Integer sid){
		Students students = (Students) getCurrentSession()
							.createQuery("from Students where sid = ?")
							.setInteger(0, sid).uniqueResult();
		return students;
	}
	
	//更新
	public boolean doUpdateStudents(Students vo){
		Integer i = getCurrentSession()
		.createQuery("update Students s set s.sname = ?, s.ssex = ?,s.classtype.cid = ? where sid = ?")
		.setString(0, vo.getSname())
		.setString(1, vo.getSsex())
		.setInteger(2, vo.getClasstype().getCid())
		.setInteger(3, vo.getSid())
		.executeUpdate();
		if(1 == i){
			return true;
		}
		return false;
	}

	//添加
//	public boolean doInsertStudents(Students vo){
//		Integer i= getCurrentSession()
//				.createSQLQuery("insert into students values(?,?,?)")
//				.setString(0, vo.getSname())
//				.setString(1, vo.getSsex())
//				.setInteger(2, vo.getClasstype().getCid())
//				.executeUpdate();
//		
//		if( 1 == i){
//			return true;
//		}
//		return false;
//	}

	public void save(Students transientInstance) {
		log.debug("saving Students instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

//	public boolean doDelete(Integer sid){
//		int i = getCurrentSession()
//				.createQuery("from Students where sid =?")
//				.setInteger(0, sid)
//				.executeUpdate();
//		if(1 == i){
//			return true;
//		}
//		return false;
//	}
	public void delete(Students persistentInstance) {
		log.debug("deleting Students instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Students findById(java.lang.Integer id) {
		log.debug("getting Students instance with id: " + id);
		try {
			Students instance = (Students) getCurrentSession().get(
					"org.xxx.model.entity.persist.Students", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Students> findByExample(Students instance) {
		log.debug("finding Students instance by example");
		try {
			List<Students> results = (List<Students>) getCurrentSession()
					.createCriteria("org.xxx.model.entity.persist.Students")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Students instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Students as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Students> findBySname(Object sname) {
		return findByProperty(SNAME, sname);
	}

	public List<Students> findBySsex(Object ssex) {
		return findByProperty(SSEX, ssex);
	}

	public List findAll() {
		log.debug("finding all Students instances");
		try {
			String queryString = "from Students";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Students merge(Students detachedInstance) {
		log.debug("merging Students instance");
		try {
			Students result = (Students) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Students instance) {
		log.debug("attaching dirty Students instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Students instance) {
		log.debug("attaching clean Students instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StudentsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StudentsDAO) ctx.getBean("StudentsDAO");
	}
}