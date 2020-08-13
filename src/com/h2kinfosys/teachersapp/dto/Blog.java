package com.h2kinfosys.teachersapp.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("blog")
public class Blog implements Serializable{

	@XStreamAsAttribute
	private String author;
	@XStreamImplicit
	private ArrayList<Entry> entries;
	
	
	public Blog() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}


	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}


	/**
	 * @return the entries
	 */
	public ArrayList<Entry> getEntries() {
		return entries;
	}


	/**
	 * @param entries the entries to set
	 */
	public void setEntries(ArrayList<Entry> entries) {
		this.entries = entries;
	}

}
