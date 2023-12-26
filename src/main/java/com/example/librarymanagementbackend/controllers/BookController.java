//package com.example.librarymanagementbackend.controllers;
////import io.swagger.v3.oas.annotations.Operation;
////import io.swagger.v3.oas.annotations.responses.ApiResponse;
////import io.swagger.v3.oas.annotations.responses.ApiResponses;
////import io.swagger.v3.oas.annotations.tags.Tag;
//import net.minidev.json.JSONObject;
//
//
//        import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/api/v1/tasks")
////@Tag(name="Book", description = "Book API")
//@CrossOrigin("*")
//public class BookController {
//
//    @GetMapping("/")
//    public ResponseEntity<String> getJsonData() {
//        String jsonString = "{\"name\": \"Alice\", \"city\": \"New York\", \"age\": 25}";
//        return ResponseEntity.ok(jsonString);
//    }
////    @Autowired
////    private BookService bookService;
////
////    @CrossOrigin("http://localhost:4200")
////    @GetMapping("/")
////    public ResponseEntity<List<Book>> getAllTasks() {
////        return ResponseEntity.ok(bookService.getAllTask());
////
////    }
////
////    swagger
////    @Operation(
////            summary = "Fetch all tasks completed",
////            description = "fetches all tasks completed")
////    @ApiResponses(value = {
////            @ApiResponse(responseCode = "200", description = "successful operation")
////    })
////    @PostMapping("/")
////    public ResponseEntity<Book> createTask(@RequestBody Book task) {
////        return ResponseEntity.ok(BookService.createNewBook(task));
////    }
////
////
////    @DeleteMapping("/{id}")
////    public ResponseEntity<Boolean> getAllTasks(@PathVariable Long id) {
////        BookService.deleteBook(id);
////        return ResponseEntity.ok(true);
////    }
////
////
////    @PutMapping("/{id}")
////    public ResponseEntity<Book> updateTask(@PathVariable Long id, @RequestBody Book book) {
////        task.setId(id);
////        return ResponseEntity.ok(BookService.updateBook(task));
////    }
//
//
//}
