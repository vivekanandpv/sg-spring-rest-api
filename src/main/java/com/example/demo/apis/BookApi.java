package com.example.demo.apis;

import com.example.demo.ancillary.Vehicle;
import com.example.demo.config.AppConfig;
import com.example.demo.models.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/books")
public class BookApi {
    private final Vehicle vehicle;
    private final AppConfig config;

    @Value("${app.key}")
    private String key;

    public BookApi(Vehicle vehicle, AppConfig config) {
        this.vehicle = vehicle;
        this.config = config;
    }

    @GetMapping
    public ResponseEntity<Book> get(@RequestParam(required = false) String title) {
        Book book = new Book();
        book.setTitle(title == null ? "Default Title" : title);
        book.setDescription("Spring 5.0");
        book.setAuthors(new String[] {"John Doe", "Martin"});
        book.setPages(1200);
        book.setPrice(2000.25);

        vehicle.drive();

        System.out.println(String.format("Key: %s", key));

        System.out.println(String.format("API Key: %s; Username: %s; Password: %s", config.getApiKey(), config.getUsername(), config.getPassword()));

        return ResponseEntity.ok(book);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> get(@PathVariable int id) {
        Book book = new Book();
        book.setTitle("Learning Spring " + id);
        book.setDescription("Spring 5.0");
        book.setAuthors(new String[] {"John Doe", "Martin"});
        book.setPages(1200);
        book.setPrice(2000.25);

        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        book.setDescription("Created!");
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> updatePut(@RequestBody Book book, @PathVariable int id) {
        book.setDescription("Updated!");
        return ResponseEntity.ok(book);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Book> updatePatch(@PathVariable int id, @RequestBody Book book) {
        book.setDescription("Updated!");
        return ResponseEntity.ok(book);
    }
}
