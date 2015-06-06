package com.testing.danawara.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.testing.danawara.controller.HomeController;
import com.testing.danawara.models.Mainboard;

@Repository
public class MainboardDAOImpl implements MainboardDAO {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Mainboard> listMainboard() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Mainboard> mainboardList = session.createQuery("from Mainboard").list();
        for(Mainboard mainboard : mainboardList){
            logger.info("mainboard : " + mainboard);
        }
        return mainboardList;
	}

	@Override
	public Mainboard getMainboardById(int id) {
		Session session = this.sessionFactory.getCurrentSession();      
        Mainboard mainboard = (Mainboard) session.load(Mainboard.class, new Integer(id));
        logger.info("mainboard : " + mainboard);
        return mainboard;
	}

}
