package se.webdev.ju15.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataBean {
	
	int id = 0;
	String name = "";
	String message = "";
	String date = "";
	int votes = 0;
	
	public DataBean(String name, String message) {	
		this.id = 99;
		this.name = name;
		this.date="12/12/12";
		this.votes = 1;
		this.message = message;
		//Took away parameters to simplify the bean making process for DB testing.
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**@author Joakim
	 * @return the date
	 */
	public String getDate() {
		
//		LocalDate ld = null;
//		
//		try{
//			
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM u, yyyy");
//		ld = LocalDate.parse(date, formatter);
//		
//		}catch(Exception e){
//			System.out.println("getDate() found exception");
//		}
		
		return this.date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		
		
		this.date = date;
	}

	/**
	 * @return the votes
	 */
	public int getVotes() {
		return this.votes;
	}

	/**
	 * @param votes the votes to set
	 */
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	
	
}
