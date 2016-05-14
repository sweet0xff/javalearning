package org.xxx.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xxx.model.entity.persist.Classtype;

/**
 * A data access object (DAO) providing persistence and search support for
 * Classtype entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.xxx.model.entity.persist.Classtype
 * @author MyEclipse Persistence Tools
 */
public class ClasstypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ClasstypeDAO.class);
	// property constants
	public static final String CNAME = "cname";

	public List<Classtype> doFindAll(){
		List<Classtype> clist = new ArrayList<Classtype>();
		
		String hql = "from Classtype order by cid";
		clist = getSession().createQuery(hql).list();
		
		return clist;
	}
	
	public void save(Classtype transientInstance) {
		log.debug("saving Classtype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Classtype persistentInstance) {
		log.debug("deleting Classtype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Classtype findById(java.lang.Integer id) {
		log.debug("getting Classtype instance with id: " + id);
		try {
			Classtype instance = (Classtype) getSession().get(
					"org.xxx.model.entity.persist.Classtype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Classtype instance) {
		log.debug("finding Classtype instance by example");
		try {
			List results = getSession()
					.createCriteria("org.xxx.model.entity.persist.Classtype")
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
		log.debug("finding Classtype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Classtype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCname(Object cname) {
		return findByProperty(CNAME, cname);
	}

	public List findAll() {
		log.debug("finding all Classtype instances");
		try {
			String queryString = "from Classtype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Classtype merge(Classtype detachedInstance) {
		log.debug("merging Classtype instance");
		try {
			Classtype result = (Classtype) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Classtype instance) {
		log.debug("attaching dirty Classtype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Classtype instance) {
		log.debug("attaching clean Classtype instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}