package com.Jubaw.controller;


import com.Jubaw.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //States to Spring to create Bean from it.
//In SpringBoot, @Controller is not needed since we will not managing the model,view,and controller manually, but will get requests with REST API JSON body.
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;



}
