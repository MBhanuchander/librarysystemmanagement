package org.example;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
    @Id

    @Column(name = "isbn")
    private int isbn;

    @Column(name = "title")//each and every fields add column to mapping correctly
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publicationyear")
    private int publicationyear;
    @Column(name = "genre")
    private String genre;

    public Book() {
//need empty constructor because hibernate need empty objects during fetch the data
    }

    public Book(int isbn, String title, String author, int publicationyear, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationyear = publicationyear;
        this.genre = genre;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationyear() {
        return publicationyear;
    }

    public void setPublicationyear(int publicationyear) {
        this.publicationyear = publicationyear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publicationyear=" + publicationyear + " , genre=" + genre+ "]";
    }
}


