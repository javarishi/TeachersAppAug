package com.h2kinfosys.teachersapp.util;

import com.h2kinfosys.teachersapp.dto.Blog;
import com.h2kinfosys.teachersapp.dto.Entry;
import com.h2kinfosys.teachersapp.dto.TeacherTO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class XstreamUtil {

	private XStream xstream = null;
	
	public XstreamUtil() {
		xstream = new XStream();
		xstream.processAnnotations(TeacherTO.class);
		xstream.processAnnotations(Blog.class);
		xstream.processAnnotations(Entry.class);
	}
	
	public String toXML(Object obj) throws Exception{
		String xmlString = null;
		try {
			xmlString = xstream.toXML(obj);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return xmlString;
	}
	
	
	public String toJSON(Object obj) throws Exception{
		String xmlString = null;
		try {
			XStream jsonXs = new XStream(new JettisonMappedXmlDriver()) ;
			jsonXs.processAnnotations(Blog.class);
			jsonXs.processAnnotations(Entry.class);
			xmlString = jsonXs.toXML(obj);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return xmlString;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		TeacherTO teacher = new TeacherTO();
		teacher.setFirstName("Allan");
		teacher.setLastName("Bulson");
		teacher.setSkill("JAVA");
		teacher.setTeacherId(100);
		
		XstreamUtil util = new XstreamUtil();
		String xml = util.toXML(teacher);
		System.out.println(xml);
	}

}
