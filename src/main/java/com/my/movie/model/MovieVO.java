package com.my.movie.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class MovieVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String genre;   // action , thriller
	private Integer releaseYear;    
	private String productionStudio;  // marvel , dc, hombale films
	private String industry;    // bollywo0d , hollywood
	private Double imdbRating;
}
