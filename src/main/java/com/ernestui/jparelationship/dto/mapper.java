package com.ernestui.jparelationship.dto;

import com.ernestui.jparelationship.data.Author;
import com.ernestui.jparelationship.data.Book;
import com.ernestui.jparelationship.data.Category;
import com.ernestui.jparelationship.dto.responseDto.AuthorResponseDto;
import com.ernestui.jparelationship.dto.responseDto.BookResponseDto;
import com.ernestui.jparelationship.dto.responseDto.CategoryResponseDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 03/04/2023 - 09:05
 * @project jpa-relationship
 */
public class mapper {
    public static BookResponseDto bookTobookResponseDto(Book book){
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setName(book.getName());
        List<String>  names = new ArrayList<>();
        List<Author> authors =new ArrayList<>();
            for(Author author: authors){
            names.add(author.getName());
            }

            bookResponseDto.setAuthorNames(names);
            return bookResponseDto;
    }

    public static List<BookResponseDto> bookToBookResponseDtos(List<Book> books){
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for(Book book: books){
            bookResponseDtos.add(bookTobookResponseDto(book));
        }
        return bookResponseDtos;
    }

    public static AuthorResponseDto authorToAuthorResponseDto(Author author){
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setId(author.getId());
        authorResponseDto.setName(author.getName());
        List<String> names = new ArrayList<>();
        List<Book> books = author.getBooks();

        for(Book book: books){
            names.add(book.getName());
        }
        authorResponseDto.setBookNames(names);
        return authorResponseDto;
    }

    public static List<AuthorResponseDto> authorToAuthorResponseDtos(List<Author> authors){
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
        for(Author author: authors){
            authorResponseDtos.add(authorToAuthorResponseDto(author));
        }
        return authorResponseDtos;
    }

    public static CategoryResponseDto categoryToCategoryResponseDto(Category category){
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setName(category.getName());
        List<String> names = new ArrayList<>();
        List<Book> books = category.getBooks();
        for(Book book: books){
            names.add(book.getName());
        }
        categoryResponseDto.setBookNames(names);
        return  categoryResponseDto;
    }

    public static List<CategoryResponseDto> categoryToCategoryResponseDtos(List<Category> categories){
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        for(Category category: categories){
            categoryResponseDtos.add(categoryToCategoryResponseDto(category));
        }
        return categoryResponseDtos;
    }
}
