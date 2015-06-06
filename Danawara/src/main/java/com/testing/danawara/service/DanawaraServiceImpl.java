package com.testing.danawara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testing.danawara.models.Cpu;
import com.testing.danawara.models.Mainboard;
import com.testing.danawara.models.Pc_case;
import com.testing.danawara.models.Vga;
import com.testing.danawara.dao.CpuDAO;
import com.testing.danawara.dao.MainboardDAO;
import com.testing.danawara.dao.Pc_caseDAO;
import com.testing.danawara.dao.VgaDAO;

public class DanawaraServiceImpl implements DanawaraService {

	private CpuDAO cpuDao;
	private MainboardDAO mainBoardDao;
	private Pc_caseDAO pccaseDao;
	private VgaDAO vgaDao;
	
	public void setCpuDAO(CpuDAO cpuDAO) {
        this.cpuDao = cpuDAO;
    }
	
	public void setMainboardDAO(MainboardDAO mainboardDAO) {
        this.mainBoardDao = mainboardDAO;
    }

	public void setPc_caseDAO(Pc_caseDAO pc_caseDAO) {
        this.pccaseDao = pc_caseDAO;
    }

	public void setVgaDAO(VgaDAO vgaDAO) {
        this.vgaDao = vgaDAO;
    }
	
	@Override
	@Transactional
	public List<Cpu> listCpu() {
		return this.cpuDao.listCpu();
	}

	@Override
	@Transactional
	public Cpu getCpuById(int id) {
		return this.cpuDao.getCpuById(id);
	}

	@Override
	@Transactional
	public List<Mainboard> listMainboard() {
		return this.mainBoardDao.listMainboard();
	}

	@Override
	@Transactional
	public Mainboard getMainboardById(int id) {
		return this.mainBoardDao.getMainboardById(id);
	}

	@Override
	@Transactional
	public List<Pc_case> listPc_case() {
		return this.pccaseDao.listPc_case();
	}

	@Override
	@Transactional
	public Pc_case getPc_caseById(int id) {
		return this.pccaseDao.getPc_caseById(id);
	}

	@Override
	@Transactional
	public List<Vga> listVga() {
		return this.vgaDao.listVga();
	}

	@Override
	@Transactional
	public Vga getVgaById(int id) {
		return this.vgaDao.getVgaById(id);
	}

}
