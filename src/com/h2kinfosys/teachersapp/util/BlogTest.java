package com.h2kinfosys.teachersapp.util;

import java.util.ArrayList;

import com.h2kinfosys.teachersapp.dto.Blog;
import com.h2kinfosys.teachersapp.dto.Entry;

public class BlogTest {

	public static void main(String[] args) {
		Entry entryOne = new Entry();
		entryOne.setTitle("first");
		entryOne.setDescription("My first blog entry.");
		Entry entryTwo = new Entry();
		entryTwo.setTitle("tutorial");
		entryTwo.setDescription("Today we have developed a nice alias tutorial. Tell your friends! NOW!");
		
		ArrayList<Entry> entries = new ArrayList<Entry>();
		entries.add(entryOne);
		entries.add(entryTwo);
		
		
		Blog blog = new Blog();
		blog.setAuthor("Guilherme Silveira");
		blog.setEntries(entries);
		
		XstreamUtil util = new XstreamUtil();
		String xml;
		try {
			xml = util.toXML(blog);
			System.out.println(util.toJSON(blog));
			System.out.println(xml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
