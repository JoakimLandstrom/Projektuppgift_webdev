package se.webdev.ju15.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataBean implements Comparable<DataBean>{

	int id = 0;
	String name = "";
	String message = "";
	int votes = 0;
	String location = "";
	Integer compareVotes=0;
	Integer compareId=0;

	public Integer getCompareId() {
		return compareId;
	}

	public void setCompareId(Integer compareId) {
		this.compareId = compareId;
	}

	public DataBean(String name, String message,String location, int votes) {
		System.out.println("inside bean");
		this.name = name;
		this.message = message;
		this.location = location;
		this.votes = votes;
		System.out.println("inside bean");
		
	}
	
	public DataBean(int id, String name, String message,String location, int votes) {
		System.out.println("inside bean");
		this.compareId=id;
		this.name = name;
		this.message = message;
		this.location = location;
		this.compareVotes = votes;
		System.out.println("inside bean");
	}
	
	public Integer getCompareVotes() {
		return compareVotes;
	}

	public void setCompareVotes(Integer compareVotes) {
		this.compareVotes = compareVotes;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
	 * @return the votes
	 */
	public Integer getVotes() {
		return votes;
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
	
	public void voteForBean(){
		votes += 1;
	}

	@Override
	public int compareTo(DataBean db) {
		int x = this.compareVotes.compareTo(db.compareVotes);
		return x;
	}
	
}
