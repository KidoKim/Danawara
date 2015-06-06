package com.testing.danawara.dao;

import java.util.List;

import com.testing.danawara.models.Pc_case;

public interface Pc_caseDAO {
	public List<Pc_case> listPc_case();
    public Pc_case getPc_caseById(int id);
}
