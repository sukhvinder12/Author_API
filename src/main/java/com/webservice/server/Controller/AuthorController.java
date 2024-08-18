package com.webservice.server.Controller;

import com.webservice.server.Exceptions.ErrorMessage;
import com.webservice.server.service.AuthorService;
import com.webservice.server.vo.AuthorVO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Valid
@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @RequestMapping(method = RequestMethod.GET, name = "Get author by name and url",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAthor(@RequestParam(name = "name") String name,
                                      @RequestParam(name = "url") String url) {
        try {
            return new ResponseEntity<>(authorService.get(name, url), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(name = "Add Author", value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addAuthor(@RequestBody @Valid AuthorVO authorVO) {
        try {
            return new ResponseEntity<>(authorService.add(authorVO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(name = "Get all Authors", value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllAuthors() {
        try {
            return new ResponseEntity<>(authorService.getALl(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
