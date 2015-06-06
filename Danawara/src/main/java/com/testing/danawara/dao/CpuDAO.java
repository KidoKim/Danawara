package com.testing.danawara.dao;


import java.util.List;
import com.testing.danawara.models.Cpu;

public interface CpuDAO {
	public List<Cpu> listCpu();
    public Cpu getCpuById(int id);
}
