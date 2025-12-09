package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RestController
public class ApiController {
    private final List<Post> messages = new ArrayList<>();
    @PostMapping("/posts")
    public ResponseEntity<Void> addPost(@RequestBody Post text) {
        text.setId(messages.size() - 1);
        messages.add(text);
        return ResponseEntity.accepted().build();
    }
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getMessages() {
        return ResponseEntity.ok(messages);
    }
    @GetMapping("posts/{id}")
    public ResponseEntity<Void> Remake(@PathVariable("id") Integer index, @RequestBody String title) {
        for (int i = 0; i < messages.size(); i++) {
            if(messages.get(i).getId() == index){
                messages.get(i).setTitle(title);
            }
        }
        return ResponseEntity.noContent().build();
    }
    @GetMapping("posts/{id}")
    public ResponseEntity<Post> getMessage(@PathVariable("id") Integer index) {
        for (int i = 0; i < messages.size(); i++) {
            if(messages.get(i).getId() == index){
                return ResponseEntity.ok(messages.get(i));
            }
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("posts/count")
    public ResponseEntity<Integer> getMessage() {
        return ResponseEntity.ok(messages.size());
    }
    @GetMapping("posts/posts/author/{author}")
    public ResponseEntity<List<Post>> getMessage(@PathVariable("author") String author) {
        List<Post> messages2 = new ArrayList<>();
        for (int i = 0; i < messages.size(); i++) {
            if(messages.get(i).getAuthor().equals(author)){
                messages2.add(messages.get(i));
            }
        }
        return ResponseEntity.ok(messages2);
    }
    @DeleteMapping("posts/{index}")
    public ResponseEntity<Void> deleteText(@PathVariable("index") Integer index) {
        messages.remove((int) index);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("posts/{id}")
    public ResponseEntity<Void> updateMessage(@PathVariable("id") Integer id, @RequestBody String message) {

        return ResponseEntity.accepted().build();
    }
    @DeleteMapping("posts")
    public ResponseEntity<Void> deleteAll() {
        for (int i = 0; i < messages.size(); i++) {
            messages.remove(i);
        };
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/post/search/{text}")
    public ResponseEntity<List<Post>> searchingtext(@PathVariable("text") String text){
        List<Post> messages2 = new ArrayList<>();
        for (int i = 0; i < messages.size(); i++) {
            if(messages.get(i).getTitle().contains(text)){
                messages2.add(messages.get(i));
            }
        }
        return ResponseEntity.ok(messages2);
    }
    @GetMapping("/post/lastest")
    public ResponseEntity<List<Post>> lastestingtext(){
        List<Post> messages2 = new ArrayList<>();
        for (int i = 0; i < Math.min(messages.size(), 20); i++) {
            messages2.add(messages.get(i));
        }
        return ResponseEntity.ok(messages2);
    }



}

