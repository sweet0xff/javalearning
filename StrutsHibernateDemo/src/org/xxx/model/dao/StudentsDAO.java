package org.xxx.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xxx.model.entity.persist.Classtype;
import org.xxx.model.entity.persist.Students;
import org.xxx.model.entity.vo.Students_Classtype;

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
public class StudentsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StudentsDAO.class);
	// property constants
	public static final String SNAME = "sname";
	public static final String SSEX = "ssex";
	
	public List<Students_Classtype> doFindAllStudents(){
		int pageSize=3;
		int pageNo=1;
		List<Students_Classtype> slist= new ArrayList<Students_Classtype>();
		String hql= "from Students s inner join s.classtype c order by s.sid ";
		Query query = getSession().createQuery(hql);

//		query.setFirstResult((pageNo-1)*pageSize);
//		query.setMaxResults(pageSize);
		List<Object[]> list = query.list();
		
		for (Object[] objects : list) {
			Students_Classtype sc = new Students_Classtype();
			sc.setStudent((Students)objects[0]);
			sc.setClasstype((Classtype)objects[1]);
			slist.add(sc);
		}
		return slist;
		
//		List<?> list = query.list();
		
//		for (int i = 0; i< slist.size(); i++) {
//			Object[] obj = (Object[]) list.get(i);
//			Students s =(Students) obj[0];
//			Classtype c =(Classtype) obj[1];
//			Students_Classtype vo = new Students_Classtype();
//			vo.setStudent(s);
//			vo.setClasstype(c);
//			slist.add(vo);
//		}
			
	}

	public Students doFindStudentById(Integer sid){
		Students student = new Students();
		
		String hql = "from Students where sid = ?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, sid);
		student= (Students) query.uniqueResult();
		if(student != null){
			return student;
		}
		return null;
	}
	
	public boolean doUpdateStudent(Students vo){
		boolean flag = false;
		String hql = "update Students s set s.sname = ?, s.ssex = ?,s.classtype.cid = ? where sid = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, vo.getSname());
		query.setString(1, vo.getSsex());
		query.setInteger(2, vo.getClasstype().getCid());
		query.setInteger(3, vo.getSid());
		Integer i = query.executeUpdate();
		getSession().beginTransaction().commit();
		
		if(1 == i){
			flag= true;
		};
		return flag;
		
	}
	
	public void save(Students transientInstance) {
		log.debug("saving Students instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Students persistentInstance) {
		log.debug("deleting Students instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Students findById(java.lang.Integer id) {
		log.debug("getting Students instance with id: " + id);
		try {
			Students instance = (Students) getSession().get(
					"org.xxx.model.entity.persist.Students", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Students instance) {
		log.debug("finding Students instance by example");
		try {
			List results = getSession()
					.createCriteria("org.xxx.model.entity.persist.Students")
					.add(Example.create(instance)).list();
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
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySname(Object sname) {
		return findByProperty(SNAME, sname);
	}

	public List findBySsex(Object ssex) {
		return findByProperty(SSEX, ssex);
	}

	public List findAll() {
		log.debug("finding all Students instances");
		try {
			String queryString = "from Students";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Students merge(Students detachedInstance) {
		log.debug("merging Students instance");
		try {
			Students result = (Students) getSession().merge(detachedInstance);
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
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Students instance) {
		log.debug("attaching clean Students instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}