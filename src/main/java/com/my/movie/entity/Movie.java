package com.my.movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "title")
	private String title;

	@Column(name = "genere")
	private String genre; // action , thriller

	@Column(name = "release_year")
	private Integer releaseYear;

	@Column(name = "production_studio")
	private String productionStudio; // marvel , dc, hombale films

	@Column(name = "industry")
	private String industry; // bollywo0d , hollywood

	@Column(name = "imdb_rating")
	private Double imdbRating;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getProductionStudio() {
		return productionStudio;
	}

	public void setProductionStudio(String productionStudio) {
		this.productionStudio = productionStudio;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(Double imdbRating) {
		this.imdbRating = imdbRating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", releaseYear=" + releaseYear
				+ ", productionStudio=" + productionStudio + ", industry=" + industry + ", imdbRating=" + imdbRating
				+ "]";
	}

}
