package com.Jubaw.repository;

import com.Jubaw.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Not needed to use annotation neccesarily, since we already extended from JpaRepository.
//Also bean cannot be created from Interfaces. So it is redundant.
public interface BookRepository extends JpaRepository<Book,Long> {
}
