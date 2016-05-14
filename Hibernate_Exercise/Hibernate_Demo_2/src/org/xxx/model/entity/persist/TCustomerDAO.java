package org.xxx.model.entity.persist;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TCustomer entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.xxx.model.entity.persist.TCustomer
 * @author MyEclipse Persistence Tools
 */
public class TCustomerDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TCustomerDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String AGE = "age";
	public static final String ADDR = "addr";

	public void save(TCustomer transientInstance) {
		log.debug("saving TCustomer instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TCustomer persistentInstance) {
		log.debug("deleting TCustomer instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TCustomer findById(java.lang.Long id) {
		log.debug("getting TCustomer instance with id: " + id);
		try {
			TCustomer instance = (TCustomer) getSession().get(
					"org.xxx.model.entity.persist.TCustomer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TCustomer instance) {
		log.debug("finding TCustomer instance by example");
		try {
			List results = getSession()
					.createCriteria("org.xxx.model.entity.persist.TCustomer")
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
		log.debug("finding TCustomer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TCustomer as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List findByAddr(Object addr) {
		return findByProperty(ADDR, addr);
	}

	public List findAll() {
		log.debug("finding all TCustomer instances");
		try {
			String queryString = "from TCustomer";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TCustomer merge(TCustomer detachedInstance) {
		log.debug("merging TCustomer instance");
		try {
			TCustomer result = (TCustomer) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TCustomer instance) {
		log.debug("attaching dirty TCustomer instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TCustomer instance) {
		log.debug("attaching clean TCustomer instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}