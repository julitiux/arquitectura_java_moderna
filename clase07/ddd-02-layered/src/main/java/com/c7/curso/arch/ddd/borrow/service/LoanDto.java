package com.c7.curso.arch.ddd.borrow.service;

import com.c7.curso.arch.ddd.borrow.model.Loan;

import java.time.LocalDate;


public record LoanDto(Long id, Loan.Book book, Long patronId,
                      LocalDate dateOfIssue, int loanDurationInDays,
                      LocalDate dateOfReturn, Loan.LoanStatus status) {
}
