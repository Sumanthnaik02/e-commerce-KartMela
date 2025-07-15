package com.ecommerce.controller;

import com.ecommerce.model.Poster;
import com.ecommerce.service.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/posters")
public class PosterController {
    @Autowired
    private PosterService posterService;

    @GetMapping
    public List<Poster> getPoster(){
        return posterService.getAllPosters();
    }

    @PostMapping
    public Poster addPoster(@RequestBody Poster poster){
        return posterService.savePoster(poster);
    }

    @DeleteMapping("{/id}")
    public void deletePoster(@PathVariable Long id){
      posterService.deletePoster(id);
    }
}
