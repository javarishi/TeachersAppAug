package com.h2kinfosys.teachersapp.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("teacher")
public class TeacherTO implements Serializable {
	
	@Override
	public String toString() {
		return "TeacherTO [teacherId=" + teacherId + ", firstName=" + firstName + ", lastName=" + lastName + ", skill="
				+ skill + ", lastUpdate=" + lastUpdate + "]";
	}
	public TeacherTO() {
		// TODO Auto-generated constructor stub
	}

	@XStreamAsAttribute
	@XStreamAlias("id")
	private int teacherId;
	
	@XStreamAlias("firstname")
	private String firstName;
	
	@XStreamAlias("lastname")
	private String lastName;
	private String skill;
	private Timestamp lastUpdate;
	/**
	 * @return the teacherId
	 */
	public int getTeacherId() {
		return teacherId;
	}
	/**
	 * @param teacherId the teacherId to set
	 */
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the skill
	 */
	public String getSkill() {
		return skill;
	}
	/**
	 * @param skill the skill to set
	 */
	public void setSkill(String skill) {
		this.skill = skill;
	}
	/**
	 * @return the lastUpdate
	 */
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
	

}
