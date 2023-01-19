package com.assignment.three.bibooks.model;

import java.io.Serializable;

public class BookCopyId implements Serializable {
    private String book;
    private Long copyId;

    public BookCopyId(){}
    public BookCopyId(String book, Long copyId){
        this.book = book;
        this.copyId = copyId;
    }
    // Getters and setters for the fields
    public String getBook() {
        return book;
    }

    public Long getCopyId() {
        return copyId;
    }
}
