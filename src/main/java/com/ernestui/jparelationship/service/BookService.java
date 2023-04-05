package com.ernestui.jparelationship.service;

import com.ernestui.jparelationship.data.Book;
import com.ernestui.jparelationship.dto.requestDto.BookRequestDto;
import com.ernestui.jparelationship.dto.responseDto.BookResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 04/04/2023 - 20:28
 * @project jpa-relationship
 */
@Service
public interface BookService {
    public BookResponseDto addBook(BookRequestDto bookRequestDto);
    public BookResponseDto getBookById(Long bookId);
    public Book getBook(Long bookId);
    public List<BookResponseDto> getBooks();
    public BookResponseDto deleteBook(Long bookId);
    public BookResponseDto editBook(Long bookId,  BookRequestDto bookRequestDto);
    public BookResponseDto addAuthorToBook(Long bookId, Long authorId);
    public BookResponseDto deleteAuthorFromBook(Long bookId, Long authorId);
    public BookResponseDto addCategoryToBook(Long bookId, Long categoryId);
    public BookResponseDto deleteCategoryFromBook(Long bookId, Long categoryId);
}
