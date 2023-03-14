package com.example.demo.apis;

import com.example.demo.models.Book;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("api/v1/cars")
public class CarApi {
    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Book> get(@RequestParam(required = false) String title) {
        Book book = new Book();
        book.setTitle(title == null ? "Car Default Title" : title);
        book.setDescription("Spring 5.0");
        book.setAuthors(new String[] {"John Doe", "Martin"});
        book.setPages(1200);
        book.setPrice(2000.25);

        return ResponseEntity.ok(book);
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.ok(book);
    }
}
