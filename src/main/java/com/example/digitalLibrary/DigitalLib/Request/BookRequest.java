package com.example.digitalLibrary.DigitalLib.Request;


public class BookRequest {
	
	private String bookName;
	private int authorId;
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

}
