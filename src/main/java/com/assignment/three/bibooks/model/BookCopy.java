package com.assignment.three.bibooks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "book_copy")
@IdClass(BookCopyId.class)
@Builder
@AllArgsConstructor
public class BookCopy {
    @Id
    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private Book book;

    @Id
    @Column(name = "copy_id")
    @GeneratedValue(strategy=SEQUENCE, generator="book_copy_seq_gen")
    @SequenceGenerator(name="book_copy_seq_gen", sequenceName="book_copy_seq")
    private Long copyId;

    // DISPONIBILE O NO
    @Column(name = "status")
    private String status;

    public BookCopy() {
    }

    public BookCopy(Book myBook) {
        this.book = myBook;
        this.status = "Available";
        this.copyId = 1L;
    }

    public Book getBook() {
        return book;
    }

    public Long getCopyId() {
        return copyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "book=" + book +
                ", copyId=" + copyId +
                ", status='" + status + '\'' +
                '}';
    }
}

