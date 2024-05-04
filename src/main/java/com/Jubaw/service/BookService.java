package com.Jubaw.service;

import com.Jubaw.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 //Should have been interface but whatever.
@Service
public class BookService {



    @Autowired  //Should have been constructor injection but whatever, still learning.
    private BookRepository bookRepository;



}
