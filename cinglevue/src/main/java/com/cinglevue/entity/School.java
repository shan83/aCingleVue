package com.cinglevue.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name="school")
@org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true)
@Table(name="SCHOOL")
public class School implements Serializable {

	private static final long serialVersionUID = 1L;
	private long schoolId;
	private String schoolName;
	private MarkDetail markDetail;
	
	@Id
    @SequenceGenerator(name = "idsequence", sequenceName = "school_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idsequence")
    @Column(name = "SCHOOL_ID", length = 12)
	public long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MARK_DETAIL_ID")
	@Cascade(CascadeType.MERGE)
	public MarkDetail getMarkDetail() {
		return markDetail;
	}
	public void setMarkDetail(MarkDetail markDetail) {
		this.markDetail = markDetail;
	}
	
	

}
