package com.example.demo.actor;

import com.example.demo.movie.Movie;
import java.util.List;


public record Actor(Long id, String name, String birthDate, List<Movie> movies) {

}
