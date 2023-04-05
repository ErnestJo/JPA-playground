package com.ernestui.jparelationship.service;

import com.ernestui.jparelationship.data.Author;
import com.ernestui.jparelationship.data.Book;
import com.ernestui.jparelationship.data.Category;
import com.ernestui.jparelationship.dto.mapper;
import com.ernestui.jparelationship.dto.requestDto.BookRequestDto;
import com.ernestui.jparelationship.dto.responseDto.BookResponseDto;
import com.ernestui.jparelationship.repository.BookRepository;
import io.netty.bootstrap.AbstractBootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 04/04/2023 - 20:38
 * @project jpa-relationship
 */

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private  final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Transactional
    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {

        Book book = new Book();
        book.setName(bookRequestDto.getName());
        if(bookRequestDto.getAuthorsIds().isEmpty()){
            throw new IllegalArgumentException("Atleast ast one Author is needed");

        }else {
            List<Author> authors = new ArrayList<>();
            for (Long authorId: bookRequestDto.getAuthorsIds()){
                Author author = authorService.getAuthor(authorId);
                authors.add(author);
            }
            book.setAuthors(authors);
        }

        if(bookRequestDto.getCategoryId() == null){
            throw new IllegalArgumentException("Book need atleast one category");
        }
        Category category = categoryService.getCategory(bookRequestDto.getCategoryId());
        book.setCategory(category);

        Book book1 = bookRepository.save(book);
        return mapper.bookTobookResponseDto(book1);
    }

    @Transactional
    @Override
    public BookResponseDto getBookById(Long bookId) {
        Book book = getBook(bookId);
        return mapper.bookTobookResponseDto(book);
    }

    @Override
    public Book getBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() ->  new IllegalArgumentException("cannot find book with id: " + bookId));
        return book;
    }

    @Override
    public List<BookResponseDto> getBooks() {
        List<Book> books = StreamSupport
                .stream(bookRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return mapper.bookToBookResponseDtos(books);
    }

    @Transactional
    @Override
    public BookResponseDto deleteBook(Long bookId) {
        Book book = getBook(bookId);
        bookRepository.delete(book);
        return mapper.bookTobookResponseDto(book);
    }

    @Transactional
    @Override
    public BookResponseDto editBook(Long bookId, BookRequestDto bookRequestDto) {
        Book bookToEdit = getBook(bookId);
        bookToEdit.setName(bookRequestDto.getName());
        if(!bookRequestDto.getAuthorsIds().isEmpty()){
            List<Author> authors = new ArrayList<>();
            for(Long authorId: bookRequestDto.getAuthorsIds()) {
                Author author = authorService.getAuthor(bookRequestDto.getCategoryId());
                authors.add(author);
            }
            bookToEdit.setAuthors(authors);
        }
        if(bookRequestDto.getCategoryId() != null){
            Category category = categoryService.getCategory(bookRequestDto.getCategoryId());
            bookToEdit.setCategory(category);
        }
        return mapper.bookTobookResponseDto(bookToEdit);
    }

    @Override
    public BookResponseDto addAuthorToBook(Long bookId, Long authorId) {
        Book book = getBook(bookId);
        Author author = authorService.getAuthor(authorId);
        if(author.getBooks().contains(author)){
                throw  new IllegalArgumentException("Sorry This author is already assigned to this book");
        }
        book.addAuthor(author);
        author.addBook(book);
        return mapper.bookTobookResponseDto(book);
    }

    @Override
    public BookResponseDto deleteAuthorFromBook(Long bookId, Long authorId) {
        Book book = getBook(bookId);
        Author author = authorService.getAuthor(authorId);
        if(!(author.getBooks().contains(author))){
            throw  new IllegalArgumentException("Book does not have this author");
        }
        author.removeBook(book);
        book.deleteAuthor(author);
        return mapper.bookTobookResponseDto(book);
    }

    @Override
    public BookResponseDto addCategoryToBook(Long bookId, Long categoryId) {
        Book book = getBook(bookId);
        Category category = categoryService.getCategory(categoryId);
        if(Objects.nonNull(book.getCategory())){
            throw new IllegalArgumentException("Sorry book already has a category");
        }
        book.setCategory(category);
        category.addBook(book);
        return mapper.bookTobookResponseDto(book);
    }

    @Override
    public BookResponseDto deleteCategoryFromBook(Long bookId, Long categoryId) {
        Book book = getBook(bookId);
        Category category = categoryService.getCategory(categoryId);
        if(!(Objects.nonNull(book.getCategory()))){
            throw new IllegalArgumentException("Sorry book already has a category");
        }
        book.setCategory(null);
        category.removeBook(book);
        return mapper.bookTobookResponseDto(book);
    }
}
