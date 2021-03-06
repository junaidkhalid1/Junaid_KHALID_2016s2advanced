/**
 * 
 */
package fr.jkh.iamcore.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import fr.jkh.iam.datamodel.Identity;
import fr.jkh.iam.log.IAMLogger;

/**
 * @author Junaid KHALID
 *
 */
public class HibernateDAO implements DAO {
	
	@Autowired
	SessionFactory sf;

	private static final IAMLogger logger = fr.jkh.iam.log.IAMLogManager.getIAMLogger(HibernateDAO.class);
	
	/**
	 * @param identity
	 */
	public void save(Identity identity) {
		logger.info("=> save this identity : " + identity);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(identity);
		tx.commit();
		logger.info("<= save ok" );
		
	}

	/**
	 * @param identity
	 */
	public void update(Identity identity) {
		logger.info("=> update this identity : " + identity);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		identity.setEmail("tbr@tbr.com");
		session.update(identity);
		tx.commit();
		logger.info("<= update ok" );
		
	}

	/**
	 * @param identity
	 */
	public void delete(Identity identity) {
		logger.info("=> delete this identity : " + identity);
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(identity);
		tx.commit();
		
		logger.info("<= delete ok" );
		
	}
	
	
	

}
