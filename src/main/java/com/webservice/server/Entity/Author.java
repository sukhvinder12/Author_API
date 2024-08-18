package com.webservice.server.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Authors", uniqueConstraints = @UniqueConstraint(columnNames = {"name","url"}))
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String bio;
    private String url;

}
