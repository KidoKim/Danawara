package com.testing.danawara.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.testing.danawara.controller.HomeController;
import com.testing.danawara.models.Pc_case;

@Repository
public class Pc_caseDAOImpl implements Pc_caseDAO {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
    @SuppressWarnings("unchecked")
	@Override
	public List<Pc_case> listPc_case() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Pc_case> caseList = session.createQuery("from Pc_case").list();
        for(Pc_case pc_case : caseList){
            logger.info("pc_case : " + pc_case);
        }
        return caseList;
	}

	@Override
	public Pc_case getPc_caseById(int id) {
		Session session = this.sessionFactory.getCurrentSession();      
        Pc_case pc_case = (Pc_case) session.load(Pc_case.class, new Integer(id));
        logger.info("pc_case : " + pc_case);
        return pc_case;
	}

}
