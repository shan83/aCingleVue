package com.cinglevue.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@Entity(name="mark_detail")
@org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true)
@Table(name="MARK_DETAIL")
public class MarkDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long mdId;
	private String subject;
	private double latestY3;
	private double latestY5;
	private double latestY7;
	private double latestY9;
	private double rawGainY3Y5;
	private double factoredGainY3Y5;
	private double glgY3Y5;
	private double latestGainInGainY3Y5;
	private School school;
	
	@Id	
    @SequenceGenerator(name = "idsequence", sequenceName = "mark_detail_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idsequence")
    @Column(name = "MD_ID", length = 12)
	public long getMdId() {
		return mdId;
	}
	public void setMdId(long mdId) {
		this.mdId = mdId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getLatestY3() {
		return latestY3;
	}
	public void setLatestY3(double latestY3) {
		this.latestY3 = latestY3;
	}
	public double getLatestY5() {
		return latestY5;
	}
	public void setLatestY5(double latestY5) {
		this.latestY5 = latestY5;
	}
	public double getLatestY7() {
		return latestY7;
	}
	public void setLatestY7(double latestY7) {
		this.latestY7 = latestY7;
	}
	public double getLatestY9() {
		return latestY9;
	}
	public void setLatestY9(double latestY9) {
		this.latestY9 = latestY9;
	}
	public double getRawGainY3Y5() {
		return rawGainY3Y5;
	}
	public void setRawGainY3Y5(double rawGainY3Y5) {
		this.rawGainY3Y5 = rawGainY3Y5;
	}
	public double getFactoredGainY3Y5() {
		return factoredGainY3Y5;
	}
	public void setFactoredGainY3Y5(double factoredGainY3Y5) {
		this.factoredGainY3Y5 = factoredGainY3Y5;
	}
	public double getGlgY3Y5() {
		return glgY3Y5;
	}
	public void setGlgY3Y5(double glgY3Y5) {
		this.glgY3Y5 = glgY3Y5;
	}
	public double getLatestGainInGainY3Y5() {
		return latestGainInGainY3Y5;
	}
	public void setLatestGainInGainY3Y5(double latestGainInGainY3Y5) {
		this.latestGainInGainY3Y5 = latestGainInGainY3Y5;
	}
	
	@OneToOne(mappedBy="markDetail",fetch=FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	
	public Map<String, Object> toMarkDetailMap() {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("subject", subject );
		map.put("latestY3", latestY3);
		map.put("latestY5", latestY5);
		map.put("latestY7", latestY7);
		map.put("latestY9", latestY9);
		map.put("rawGainY3Y5", rawGainY3Y5);
		map.put("factoredGainY3Y5", factoredGainY3Y5);
		map.put("glgY3Y5", glgY3Y5);
		map.put("latestGainInGainY3Y5", latestGainInGainY3Y5);
		map.put("school", school.getSchoolName());
		return map;
	} 
	
}
