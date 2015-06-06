package com.testing.danawara.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.testing.danawara.controller.HomeController;
import com.testing.danawara.models.Vga;

@Repository
public class VgaDAOImpl implements VgaDAO {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
    @SuppressWarnings("unchecked")
	@Override
	public List<Vga> listVga() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Vga> vgaList = session.createQuery("from Vga").list();
        for(Vga vga : vgaList){
            logger.info("vga"+vga);
        }
        return vgaList;
	}

	@Override
	public Vga getVgaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();      
        Vga vga = (Vga) session.load(Vga.class, new Integer(id));
        logger.info("vga"+vga);
        return vga;
	}

}
