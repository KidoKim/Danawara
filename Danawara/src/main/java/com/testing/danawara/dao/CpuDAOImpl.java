package com.testing.danawara.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.testing.danawara.controller.HomeController;
import com.testing.danawara.models.Cpu;

@Repository
public class CpuDAOImpl implements CpuDAO{

	private static final Logger logger = Logger.getLogger(HomeController.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
    @SuppressWarnings("unchecked")
	@Override
	public List<Cpu> listCpu() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Cpu> cpuList = session.createQuery("from Cpu").list();
        for(Cpu cpu : cpuList){
            logger.info("cpu : " + cpu);
        }
        return cpuList;
	}

	@Override
	public Cpu getCpuById(int id) {
		Session session = this.sessionFactory.getCurrentSession();      
        Cpu cpu = (Cpu) session.load(Cpu.class, new Integer(id));
        logger.info("cpu : " + cpu);
        return cpu;
	}
	
}
