package com.testing.danawara.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pc_case", catalog = "danawara")
public class Pc_case {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "size", nullable = false)
	private Integer size;

	@Column(name = "name", nullable = false, length = 60)
	private String name;
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getSize(){
		return this.size;
	}
	
	public void setSize(Integer size){
		this.size = size;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Override
    public String toString(){
        return "id="+id+", name="+name+", size="+size;
    }

}
