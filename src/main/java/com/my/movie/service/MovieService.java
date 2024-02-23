package com.my.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import com.my.movie.entity.Movie;

public interface MovieService {

	List<Movie> movieWithNonNullIMDB();

	List<Movie> movieWithNullIMDB();

	List<Movie> movieWithIMDbRatingDecendingOrder();

	List<Movie> top5BollyWoodMovieWithLowIMDbAscending();

	List<Movie> top5HollywoodMovieWihHighestIMDb();

	List<Movie> allMoviesOrderByReleaseYearDesc();

	List<Movie> allMoviesReleasedInYear(Integer releaseYear);

	List<Movie> movieReleasedAfterWithIMDbRatinggreater(Integer releaseYear, Double imdbRating);

	List<Movie> movieReleasedInYear(Integer releaseYear);

	List<Movie> moviesProducedBy(String productionStudio);

	List<Movie> movieTitleWithAndDescYr(String title);

	List<Movie> movieNotProduceByPrdStdudio(String productionStudio);

	long noOfMovieInIndustry(String industry);

	Optional<Movie> maximumIMDbRating(String industry);

	Optional<Movie> minimumIMDbRating(String industry);

	OptionalDouble avergaeIMDbratingByPrdStudio(String productionStudio);

}
