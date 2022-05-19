package ca.qc.barreau.userws.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.qc.barreau.userws.model.User;

@Repository
public class UserRepositoryImp implements UserRepository {
	private EntityManager em;
	private Session session = null;

	@Autowired
	public UserRepositoryImp(EntityManager em) {
		this.em = em;
	}

	@Override
	@Transactional
	public List<User> findAll() {
		session = em.unwrap(Session.class);
		Query<User> query = session.createQuery("from User", User.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public User findById(int userId) {
		session = em.unwrap(Session.class);
		return session.get(User.class, userId);
	}

	@Override
	@Transactional
	public void save(User user) {
		session = em.unwrap(Session.class);
		session.saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void deleteById(int userId) {
		session = em.unwrap(Session.class);
		Query query=session.createQuery("delete User where id=:userId");
		query.setParameter("userId", userId);
		query.executeUpdate();
	}
}
