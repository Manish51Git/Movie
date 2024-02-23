package com.my.movie.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.movie.entity.Movie;
@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>{

}
