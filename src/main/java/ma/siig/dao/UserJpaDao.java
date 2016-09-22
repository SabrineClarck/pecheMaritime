package ma.siig.dao;



import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.util.Assert;

import ma.siig.commons.dao.GenericJpaDao;
import ma.siig.domain.UserEntity;

public class UserJpaDao extends GenericJpaDao<UserEntity, Long> implements UserDao{



	public UserJpaDao() {
		super(UserEntity.class);
		
	}

	
	public boolean checkAvailable(String userName) {
		//this method notNull will throw an exception in case the userName is null
		//and the app will crash
		Assert.notNull(userName);
		
		Query qr = getEntityManager().createQuery("select count(*) from "+ getPersistenceClass().getSimpleName()
						+ " u where u.userName = :userName").setParameter("userName", userName);		
		
		Long count = (Long) qr.getSingleResult();		
		return count < 1;
	}

	
	public UserEntity loadUserByUserName(String userName) {
		UserEntity user = null;
		
		Query qr = getEntityManager().createQuery("select u from "+ getPersistenceClass().getSimpleName()
				+ " u where u.userName = :userName").setParameter("userName", userName);		

		try{
		user = (UserEntity) qr.getSingleResult();
		}catch(NoResultException e){
			// do nothing
		}
		
		return user;
	}
	
	

}
