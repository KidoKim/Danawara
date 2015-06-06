package com.testing.danawara.dao;

import java.util.List;

import com.testing.danawara.models.Mainboard;

public interface MainboardDAO {
	public List<Mainboard> listMainboard();
    public Mainboard getMainboardById(int id);
	
}
