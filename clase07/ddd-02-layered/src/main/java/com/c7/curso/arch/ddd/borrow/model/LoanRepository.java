package com.c7.curso.arch.ddd.borrow.model;

import com.c7.curso.arch.ddd.borrow.service.LoanWithBookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("""
            SELECT new com.c7.curso.arch.ddd.borrow.service.LoanWithBookDto(l.id, l.dateOfIssue, l.book.barcode, b.title, b.author.name)
            FROM Loan l
            INNER JOIN Book b ON l.book.barcode = b.inventoryNumber.barcode
            WHERE l.status = :status
            """)
    List<LoanWithBookDto> findLoansWithStatus(Loan.LoanStatus status);
}
