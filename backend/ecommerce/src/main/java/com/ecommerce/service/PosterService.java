package com.ecommerce.service;

import com.ecommerce.model.Poster;
import com.ecommerce.repository.PosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosterService {

    @Autowired
    private PosterRepository posterRepo;

    public List<Poster> getAllPosters(){
        return posterRepo.findAll();
    }

    public Poster savePoster(Poster poster){
        return posterRepo.save(poster);
    }

    public void deletePoster(Long id){
        posterRepo.deleteById(id);
    }
}
