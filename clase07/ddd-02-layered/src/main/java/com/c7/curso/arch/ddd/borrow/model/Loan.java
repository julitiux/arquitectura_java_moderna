package com.c7.curso.arch.ddd.borrow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "barcode", column = @Column(name = "book_barcode"))
    private Book book;

    private Long patronId;

    private LocalDate dateOfIssue;

    private int loanDurationInDays;

    private LocalDate dateOfReturn;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @Version
    private Long version;

    public Loan(String bookBarcode) {
        this.book = new Book(bookBarcode);
        this.dateOfIssue = LocalDate.now();
        this.loanDurationInDays = 14;
        this.status = LoanStatus.ACTIVE;
    }

    public static Loan of(String bookBarcode) {
        return new Loan(bookBarcode);
    }

    public boolean isActive() {
        return LoanStatus.ACTIVE.equals(this.status);
    }

    public boolean isOverdue() {
        return LoanStatus.OVERDUE.equals(this.status);
    }

    public boolean isCompleted() {
        return LoanStatus.COMPLETED.equals(this.status);
    }

    public void complete() {
        if (isCompleted()) {
            throw new IllegalStateException("Loan is not active!");
        }
        this.status = LoanStatus.COMPLETED;
        this.dateOfReturn = LocalDate.now();
    }

    public enum LoanStatus {
        ACTIVE, OVERDUE, COMPLETED
    }

    /**
     * Book modeled as a value object in the Loan module. It only includes one property.
     *
     * @param barcode The barcode of the book.
     */
    public record Book(String barcode) {
    }
}
