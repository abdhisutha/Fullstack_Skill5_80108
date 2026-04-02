package com.example.library.controller;

import com.example.library.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the Online Library System!";
    }

    @GetMapping("/count")
    public int count(){
        return 100;
    }

    @GetMapping("/price")
    public double price(){
        return 499.99;
    }

    @GetMapping("/books")
    public List<String> books(){
        List<String> titles = new ArrayList<>();
        titles.add("Java Programming");
        titles.add("Spring Boot Guide");
        titles.add("Data Structures");
        return titles;
    }

    @GetMapping("/books/{id}")
    public String bookById(@PathVariable int id){
        return "Details for Book ID: " + id;
    }

    @GetMapping("/search")
    public String search(@RequestParam String title){
        return "You searched for book: " + title;
    }

    @GetMapping("/author/{name}")
    public String author(@PathVariable String name){
        return "Books written by: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book){
        bookList.add(book);
        return "Book added successfully";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks(){
        return bookList;
    }
}
