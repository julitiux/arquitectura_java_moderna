package com.c7.curso.arch.borrow;


import com.c7.curso.arch.ddd.borrow.model.Loan;
import com.c7.curso.arch.ddd.borrow.service.LoanManagement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import com.c7.curso.arch.ddd.inventory.BookManagement;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class LoanManagementIT {

    @Autowired
    LoanManagement loans;

    @Autowired
    BookManagement books;

    @Test
    void shouldCreateLoanAndIssueBookOnCheckout() {
        var loanDto = loans.checkout("13268510");
        assertThat(loanDto.status()).isEqualTo(Loan.LoanStatus.ACTIVE);
        assertThat(loanDto.book().barcode()).isEqualTo("13268510");
        assertThat(books.locate(1L).get().status()).hasToString("ISSUED");
    }

    @Test
    void shouldCompleteLoanAndReleaseBookOnCheckin() {
        var loan = loans.checkin(10L);
        assertThat(loan.status()).isEqualTo(Loan.LoanStatus.COMPLETED);
        assertThat(books.locate(2L).get().status()).hasToString("AVAILABLE");
    }

    @Test
    void shouldListActiveLoans() {
        var loans = this.loans.activeLoans();
        assertThat(loans).hasSize(1);
    }
}
