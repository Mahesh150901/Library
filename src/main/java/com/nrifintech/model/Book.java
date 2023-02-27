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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bookSequence")
	@SequenceGenerator(initialValue=100,name="bookSequence",sequenceName="bookSequence")
	@Column(name="bookId",nullable=false)
	private int bookId;
	
	@Column(name="title",nullable=false)
	private String title;
	
	
	@Column(name="qty")
	private int qty;
	
	@Column(name="date",nullable=false)
	private LocalDate date;
	
	
	

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="authorId",nullable=false)
	private Author author;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="genreId",nullable=false)
	private Genre genre;

	public int getBookId() 
	{
		return bookId;
	}

	public void setBookId(int bookId) 
	{
		this.bookId = bookId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Author getAuthor()
	{
		return author;
	}

	public void setAuthor(Author author)
	{
		this.author = author;
	}

	public int getQty()
	{
		return qty;
	}

	public void setQty(int qty)
	{
		this.qty = qty;
	}

	public Genre getGenre()
	{
		return genre;
	}

	public void setGenre(Genre genre)
	{
		this.genre = genre;
	}
	
	public LocalDate getDate() 
	{
		return date;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}

	public Book() 
	{
		super();
		
	}

	public Book(String title, int qty, LocalDate date, Author author, Genre genre)
	{
		super();
		this.title = title;
		this.qty = qty;
		this.date = date;
		this.author = author;
		this.genre = genre;
	}

	@Override
	public String toString() 
	{
		return "Book [bookId=" + bookId + ", title=" + title + ", qty=" + qty + ", date=" + date + ", author=" + author
				+ ", genre=" + genre + "]";
	}

	
}