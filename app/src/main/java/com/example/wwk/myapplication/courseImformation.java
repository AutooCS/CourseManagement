package com.example.wwk.myapplication;

public class courseImformation {

	private String grade;
	private String profession;
	private String proNumber;
	private String courseName;
	private String selectType;
	private String credit;
	private String studyHours;
	private String examHours;
	private String computerHours;

	public courseImformation(String grade, String profession, String proNumber, String courseName,
							 String selectType, String credit, String studyHours, String examHours,
							 String computerHours) {
			this.grade=grade;
			this.profession=profession;
			this.proNumber=proNumber;
			this.courseName=courseName;
			this.selectType=selectType;
			this.credit=credit;
			this.studyHours=studyHours;
			this.examHours=examHours;
			this.computerHours=computerHours;

	}

	public String getGrade(){
		return grade;
	}
	public String getProfession() {
		return profession;
	}
	public String getProNumber() {
		return proNumber;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getSelectType() {
		return selectType;
	}
	public String getCredit() {
		return credit;
	}
	public String getStudyHours() {
		return studyHours;
	}
	public String getExamHours() {
		return examHours;
	}
	public String getComputerHours() {
		return computerHours;
	}



}
