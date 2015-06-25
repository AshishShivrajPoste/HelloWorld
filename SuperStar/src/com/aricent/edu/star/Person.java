package com.aricent.edu.star;

import java.util.List;

public class Person {

	private Boolean isSuperStar;
	
	private List<Person> knows;
	
	public Person(){
		
	}
	public Person(Boolean isSuperStar,List<Person> knows){
		this.isSuperStar = isSuperStar;
		this.knows = knows;
	}
	
	public Boolean getIsSuperStar() {
		return isSuperStar;
	}
	public void setIsSuperStar(Boolean isSuperStar) {
		this.isSuperStar = isSuperStar;
	}
	public List<Person> getKnows() {
		return knows;
	}
	public void setKnows(List<Person> knows) {
		this.knows = knows;
	}
	
	public Boolean knows(Person p1){
		for(int i = 0;i<knows.size();i++){
			if(p1.equals(knows.get(i))){
				return true;
			}
		}
		return false;
	}
}
