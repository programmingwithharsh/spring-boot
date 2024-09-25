package com.example.demo.actor;

import com.example.demo.movie.MovieRepository;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;



@Repository
public class ActorRepository {

    private List<Actor> mockActors;
    private MovieRepository movieRepository;

    public ActorRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostConstruct
    private void initializeMockActors() {
        mockActors = new ArrayList<>(List.of(
                new Actor(1L, "Keanu Reeves", "1964-09-02", List.of(movieRepository.getById(1L), movieRepository.getById(2L), movieRepository.getById(3L))),
                new Actor(2L, "Laurence Fishburne", "1961-07-30", List.of(movieRepository.getById(1L), movieRepository.getById(2L), movieRepository.getById(3L)))
        )
        );
    }

    public Actor getById(Long id) {
        return mockActors
                .stream()
                .filter(actor -> actor.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}