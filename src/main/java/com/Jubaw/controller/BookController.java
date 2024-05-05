package com.Jubaw.controller;


import com.Jubaw.domain.Book;
import com.Jubaw.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@RestController //States to Spring to create Bean from it.
//In SpringBoot, @Controller is not needed since we will not be managing the model,view,and controller manually, but will get requests with REST API JSON body.
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //1- Save a Book & Return Message
    //  + POST + JSON format body

    //1a
    @PostMapping
    public ResponseEntity<String> saveBook(@Valid @RequestBody Book book) {
        bookService.saveBook(book);
        return new ResponseEntity<>("Book has been saved successfully", HttpStatus.CREATED); //200
    }

    //2- Get All Books, Return: List<Book>
    // http://localhost:8080/books + GET
    //2a
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookService.getAll();
        return ResponseEntity.ok(bookList); //200
    }

    //3- Get a Book by its ID, Return Book
    // http://localhost:8080/books/2 + GET
    //If there is more than 1 variable, it should be like @PathVariable{"varname"}
    @GetMapping("/{identity}")
    public ResponseEntity<Book> getBookById( @PathVariable Long identity) {
        Book found = bookService.getBookById(identity);
        return new  ResponseEntity<>(found, HttpStatus.OK); //200
    }


//4- Delete a Book by its ID
// http://localhost:8080/books/2 + DELETE
    @DeleteMapping("/{no}")
    public ResponseEntity<String> deleteBook(@PathVariable ("no")Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Book has been deleted successfully");

    }


}
