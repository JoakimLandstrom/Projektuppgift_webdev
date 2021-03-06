package se.webdev.ju15.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class DataBean {

	int id = 0;
	String name = "";
	String message = "";
	String date = "";
	int votes = 0;
	String location = "";

	public DataBean(String id, String name, String message) {
		try{
			
		this.id = Integer.parseInt(id);
		
		}catch(NullPointerException e){
			System.out.println("Exception in databean constructor");
		}
	
		this.name = name;
		this.message = message;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return (Integer)(id);
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param name
	 *            the name to set
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
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {

		LocalDate ld = null;

		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM u, yyyy");
			ld = LocalDate.parse(date, formatter);

		} catch (Exception e) {
			System.out.println("getDate() found exception");
		}

		return ld;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {

		this.date = date;
	}

	/**
	 * @return the votes
	 */
	public Integer getVotes() {
		return (Integer)(votes);
	}

	/**
	 * @param votes
	 *            the votes to set
	 */
	public void setVotes(int votes) {
		this.votes = votes;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
}
