package com.Jubaw.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) // We dont want ID to be accessed to set since it is auto-generated.
    private Long id;

    //Using JAVAX PERSISTENCE and Validator together is better. ↴

    @NotBlank(message = "Book title cannot be empty")
    @NotNull(message = "Book title should be given")
    //@Size and @NotBlank are Valiadtor annotations. It checks before making entry into DB, at Validation phase.
    @Column(nullable = false)//Javax Persistence, gives error while Inserting into table.
    private String title;

    @NotBlank(message = "Author name cannot be blank")
    @Size(min = 2, max = 30, message = "Author name {${validatedValue}} should contain {min} and {max} chars")
    //@Size and @NotBlank are Valiadtor annotations. It checks before making entry into DB, at Validation phase.
    @Column(length = 30, nullable = false) //Javax Persistence, gives error while Inserting into table.
    private String author;


    @Column(nullable = false)
    private String publicationDate;

    //!!! NO GETTER SETTER SINCE IT IS LOMBOK.

    //toString
    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                '}';
    }
}
