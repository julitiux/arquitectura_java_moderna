package com.c7.curso.arch.ddd.inventory;

public record BookDto(Long id, String title, Book.Barcode inventoryNumber,
                      String isbn, Book.Author author, Book.BookStatus status) {
}
