package com.c7.curso.arch.ddd.borrow.service;

import java.time.LocalDate;

public record LoanWithBookDto(Long loanId, LocalDate dateOfIssue, String bookBarcode,
                              String bookTitle, String author) {
}
