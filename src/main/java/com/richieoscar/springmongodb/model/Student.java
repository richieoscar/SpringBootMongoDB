package com.richieoscar.springmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
public class Student {
    @Id
    private String id;
    @NotBlank(message = "FirstName is required")
    private String firstName;
    @NotBlank(message = "LastName is required")
    private String lastName;
    @Indexed(unique = true)
    @NotBlank(message = "Email is required")
    @Email
    private String email;
    @NotBlank(message = "FirstName is required")
    private Gender gender;
    private Address address;
    private List<String> favoriteBooks;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime createdAt;
}
