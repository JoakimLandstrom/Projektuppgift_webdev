package se.webdev.ju15.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataBean {
	
	int id = 0;
	String name = "";
	String message = "";
	String date = "";
	int votes = 0;
	
	public DataBean(int id, String name, String message, String date, int votes) {
		
		this.id = id;
		this.name = name;
		this.message = message;
		this.date = date;
		this.votes = votes;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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
		return name;
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
		return message;
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
	public LocalDate getDate() {
		
		LocalDate ld = null;
		
		try{
			
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM u, yyyy");
		ld = LocalDate.parse(date, formatter);
		
		}catch(Exception e){
			System.out.println("getDate() found exception");
		}
		
		return ld;
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
		return votes;
	}

	/**
	 * @param votes the votes to set
	 */
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	
	
}