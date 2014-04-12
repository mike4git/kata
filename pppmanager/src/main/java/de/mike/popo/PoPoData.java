package de.mike.popo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PoPoData {

	private String filename;
	
	private String author;
	
	private Date creationTime;
	
	private String name;

	private int numberOfSlides;
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public int getNumberOfSlides() {
		return numberOfSlides;
	}

	public void setNumberOfSlides(int numberOfSlides) {
		this.numberOfSlides = numberOfSlides;
	}
	
	@Override
	public String toString() {
		return this.getName() + ";" + this.getFilename() + ";" + new SimpleDateFormat("dd.MM.yy - hh:mm").format(this.getCreationTime()) + ";" + this.getAuthor() + ";" + this.getNumberOfSlides();
	}
}
