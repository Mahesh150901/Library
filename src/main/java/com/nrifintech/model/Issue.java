package com.nrifintech.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="issue")
public class Issue 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="issueId",nullable=false)
	private int issueId;
	
	@Column(name="issueDate",nullable=false)
	private LocalDate issueDate;
	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="bookId",nullable=false)
	private Book book;
	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="statusId",nullable=false)
	private Status status;
	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="userId",nullable=false)
	private User user;

	public int getIssueId()
	{
		return issueId;
	}

	public void setIssueId(int issueId)
	{
		this.issueId = issueId;
	}

	public LocalDate getIssueDate()
	{
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate)
	{
		this.issueDate = issueDate;
	}

	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
	}

	public Status getStatus()
	{
		return status;
	}

	public void setStatus(Status status)
	{
		this.status = status;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Issue(LocalDate issueDate, Book book, Status status, User user)
	{
		super();
		this.issueDate = issueDate;
		this.book = book;
		this.status = status;
		this.user = user;
	}

	public Issue()
	{
		super();
	}
	
	
	

}
