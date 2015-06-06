package com.testing.danawara.dao;

import java.util.List;

import com.testing.danawara.models.Vga;

public interface VgaDAO {
	public List<Vga> listVga();
    public Vga getVgaById(int id);
}
