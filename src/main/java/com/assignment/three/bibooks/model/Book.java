package com.assignment.three.bibooks.model;

import java.sql.Timestamp;
import java.util.List;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @Column(updatable = false, nullable = false)
    String isbn;

    @Column
    String title;

    @Column
    Integer pages;

    @Column
    String author;

    @Column
    String editor;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookCopy> copies;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dateCreated;
    @UpdateTimestamp
    Timestamp lastModified;

    protected Book() {
    }

    public Book(String isbn, String title, Integer pages, String author, String editor) {
        this.isbn = isbn;
        this.title = title;
        this.pages = pages;
        this.author = author;
        this.editor = editor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPages() {
        return pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getEditor() {
        return editor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                ", editor='" + editor + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastModified=" + lastModified +
                '}';
    }
}
