package liaoo.springhibernatear.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import liaoo.springhibernatear.entity.User;

public class UserDAO implements IUserDAO {
	private SessionFactory sessionFactory;

	public UserDAO() {
	}

	public UserDAO(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	// 注入sessionFactory
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insert(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}
}