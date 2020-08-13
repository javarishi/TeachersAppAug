package com.h2kinfosys.teachersapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.h2kinfosys.teachersapp.dto.TeacherTO;
import com.h2kinfosys.teachersapp.exception.InvalidDataException;
import com.h2kinfosys.teachersapp.util.ConnectionUtil;

/*
 * CREATE TABLE teacher  (
   teacher_id  smallint unsigned NOT NULL AUTO_INCREMENT,
   first_name  varchar(45) NOT NULL,
   last_name  varchar(45) NOT NULL,
   skill  varchar(45) NOT NULL,
   last_update  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY ( teacher_id ),
  KEY  idx_actor_last_name  ( skill )
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 */


public class TeacherDAO {

	private String insertTeacher = "INSERT INTO teacher ( first_name , last_name , skill , last_update ) VALUES (?,?,?, CURRENT_TIMESTAMP)";
	
	public TeacherDAO() {
		// TODO Auto-generated constructor stub
	}
	
	// Add 4 methods
	// getTeachers
	// update
	// delete
	
	public int createTeacher(TeacherTO teacher) throws InvalidDataException{
		Connection conn = null;
		int numberofrowsinserted = 0;
		try {
			conn = ConnectionUtil.getConnection();
			PreparedStatement pStat = conn.prepareStatement(insertTeacher);
			pStat.setString(1, teacher.getFirstName());
			pStat.setString(2, teacher.getLastName());
			pStat.setString(3, teacher.getSkill());
			
			numberofrowsinserted = pStat.executeUpdate();
			
		}catch(Exception ex) {
			throw new InvalidDataException(ex);
		}finally {
			ConnectionUtil.closeConnection(conn);
		}
		return numberofrowsinserted;
	}

}
