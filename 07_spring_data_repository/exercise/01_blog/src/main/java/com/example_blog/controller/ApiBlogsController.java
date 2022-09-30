package com.example_blog.controller;

import com.example_blog.model.Blogs;
import com.example_blog.service.IBlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin("*")
public class ApiBlogsController {

    @Autowired
    private IBlogsService iBlogsService;

    @GetMapping("/v1")
    public ResponseEntity<List<Blogs>> showBlog() {
        List<Blogs> blogsList = iBlogsService.findAll();
        if (blogsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogsList, HttpStatus.OK);
    }


    @GetMapping("v1/{id}")
    public ResponseEntity<Blogs> showView(@PathVariable int id) {
        Blogs blogs = iBlogsService.findById(id);
        if (blogs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/v1")
    public ResponseEntity<List<Blogs>> showBlogByName(@RequestParam(value = "name") String name) {
        List<Blogs> blogsList = iBlogsService.findName(name);
        if (blogsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogsList, HttpStatus.OK);
    }


}
