package com.Jubaw.service;

import com.Jubaw.domain.Book;
import com.Jubaw.exceptions.ResourceNotFound;
import com.Jubaw.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Should have been interface but whatever.
@Service
public class BookService {


    @Autowired  //Should have been constructor injection but whatever, still learning.
    private BookRepository bookRepository;

    //1b
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    //2b
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long identity) {
        return bookRepository.findById(identity).orElseThrow(() -> new ResourceNotFound("Book has not been found with given ID" + identity));

    }

    public void deleteBookById(Long id) {
        Book book = getBookById(id); //Check if empty.
        //bookRepository.delete(book);
        bookRepository.deleteById(id);

    }
}
