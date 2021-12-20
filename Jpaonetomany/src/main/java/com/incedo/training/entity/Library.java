package com.incedo.training.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "library")
public class Library {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "lid")
	private int lid;

	private String libraryLocation;

	@Column(name = "reg_no")
	private String libraryRegno;

	@Column(name = "contact_no")
	private String libraryContactNo;

	@OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
	List<Book> bookList;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLibraryLocation() {
		return libraryLocation;
	}

	public void setLibraryLocation(String libraryLocation) {
		this.libraryLocation = libraryLocation;
	}

	public String getLibraryRegno() {
		return libraryRegno;
	}

	public void setLibraryRegno(String libraryRegno) {
		this.libraryRegno = libraryRegno;
	}

	public String getLibraryContactNo() {
		return libraryContactNo;
	}

	public void setLibraryContactNo(String libraryContactNo) {
		this.libraryContactNo = libraryContactNo;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

}
