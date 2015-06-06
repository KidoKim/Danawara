package com.testing.danawara.service;

import java.util.List;

import com.testing.danawara.models.Cpu;
import com.testing.danawara.models.Mainboard;
import com.testing.danawara.models.Pc_case;
import com.testing.danawara.models.Vga;

public interface DanawaraService {
	
	public List<Cpu> listCpu();
	public Cpu getCpuById(int id);
	public List<Mainboard> listMainboard();
	public Mainboard getMainboardById(int id);
	public List<Pc_case> listPc_case();
	public Pc_case getPc_caseById(int id);
	public List<Vga> listVga();
	public Vga getVgaById(int id);
}
