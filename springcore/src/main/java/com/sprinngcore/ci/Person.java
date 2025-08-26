package com.sprinngcore.ci;

public class Person {

	private String name;
	private int personId;
	private Certificate certi;
	
	public Person(String name,int personId,Certificate certi) {
		this.name=name;
		this.personId=personId;
		this.certi=certi;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+":  "+this.personId+"{"+this.certi.name+" }";
	}
	
}
