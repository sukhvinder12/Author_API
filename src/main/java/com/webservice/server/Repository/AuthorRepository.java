package com.webservice.server.Repository;

import com.webservice.server.Entity.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findByNameAndUrl(String name, String url);
}
