package com.testing.danawara.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mainboard", catalog = "danawara")
public class Mainboard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "socket", nullable = false)
	private Integer socket;
	
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
	
	public Integer getSocket(){
		return this.socket;
	}
	
	public void setSocket(Integer socket){
		this.socket = socket;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	@Override
    public String toString(){
        return "id="+id+", name="+name+", socket="+socket +", size=" + size;
    }
}
