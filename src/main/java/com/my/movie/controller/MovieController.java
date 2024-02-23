package com.my.movie.controller;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.movie.entity.Movie;
import com.my.movie.entity.Response;
import com.my.movie.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/movie-with-null-imdb")
	public Response movieWithNullIMDB() {
		List<Movie> data = movieService.movieWithNullIMDB();
		return new Response(data, "Fetched Successfully", false);
	}

	@GetMapping("/movie-with-non-null-imdb")
	public Response movieWithNonNullIMDB() {
		System.err.println("Hii");
		List<Movie> data = movieService.movieWithNonNullIMDB();
		return new Response(data, "Fetched Successfully", false);
	}

	@GetMapping("/movie-with-imdb-decending-order")
	public Response movieWithIMDbRatingDecendingOrder() {
		List<Movie> data = movieService.movieWithIMDbRatingDecendingOrder();
		return new Response(data, "Fetched Successfully", false);
	}

	@GetMapping("/top5-bollywood-movie-with-low-imdb")
	public Response top5BollyWoodMovieWithLowIMDbAscending() {
		List<Movie> bollywoodMovie = movieService.top5BollyWoodMovieWithLowIMDbAscending();
		return new Response(bollywoodMovie, "Fetched Successfully", false);
	}

	@GetMapping("/top5-hollywood-movie-with-heigh-IMDb")
	public Response top5HollywoodMovieWihHighestIMDb() {
		List<Movie> data = movieService.top5HollywoodMovieWihHighestIMDb();
		return new Response(data, "Fetched Successfully", false);

	}

	@GetMapping("/all-movies-orderby-year-desc")
	public Response allMoviesOrderByReleaseYearDesc() {
		List<Movie> listOfmovie = movieService.allMoviesOrderByReleaseYearDesc();
		return new Response(listOfmovie, "Fetched Successfully", false);
	}

	@GetMapping("/movies-released-in-year/{releaseYear}")
	public Response allMoviesReleasedInYear(@PathVariable Integer releaseYear) {
		List<Movie> movieReleased = movieService.allMoviesReleasedInYear(releaseYear);
		return new Response(movieReleased, "Fetched Successfully", false);

	}

	@GetMapping("/movies-released-after/{releaseYear}/{imdbRating}")
	public Response movieReleasedAfterWithIMDbRatinggreater(@PathVariable Integer releaseYear, Double imdbRating) {
		List<Movie> moviesReleasedIn = movieService.movieReleasedAfterWithIMDbRatinggreater(releaseYear, imdbRating);
		return new Response(moviesReleasedIn, "Fetched Successfully", false);

	}

//	@GetMapping("movies-released-in-year/{releaseYear}")
//	public Response movieReleasedInYear(@PathVariable Integer releaseYear) {
//		List<Movie> moviesReleaseinYr= movieService.movieReleasedInYear(releaseYear);
//		return new Response(moviesReleaseinYr, "Fetched Successfully", false);
//		
//		
//	}
	@GetMapping("/moviesProducedBy/{productionStudio}")
	public Response moviesProducedBy(@PathVariable String productionStudio) {
		List<Movie> moviesprdBy = movieService.moviesProducedBy(productionStudio);
		return new Response(moviesprdBy, "Fetched Successfully", false);

	}

	@GetMapping("/movie-title-with/{title}")
	public Response movieTitleWithAndDescYr(@PathVariable String title) {
		List<Movie> movTW = movieService.movieTitleWithAndDescYr(title);
		return new Response(movTW, "Fetched Successfully", false);

	}

	@GetMapping("/movies-not-produced-by/{productionStudio}")
	public Response movieNotProduceByPrdStdudio(@PathVariable String productionStudio) {
		List<Movie> notProducedBy = movieService.movieNotProduceByPrdStdudio(productionStudio);
		return new Response(notProducedBy, "Fetched Successfully", false);

	}

	@GetMapping("/no-of-movies-in/{industry}")
	public Response noOfMovieInIndustry(@PathVariable String industry) {
		long noOfMovie = movieService.noOfMovieInIndustry(industry);
		return new Response(noOfMovie, "Fetched Successfully", false);

	}
    @GetMapping("/max-rating-of-movie-in/{industry}")
	public Response maximumIMDbRating(@PathVariable String industry) {
		Optional<Movie> maxRating = movieService.maximumIMDbRating(industry);
		return new Response(maxRating, "Fetched Successfully", false);

	}
    @GetMapping("/min-rating-of-movie-in/{industry}")
  	public Response minimumIMDbRating(@PathVariable String industry) {
  		Optional<Movie> minRating = movieService.minimumIMDbRating(industry);
  		return new Response(minRating, "Fetched Successfully", false);

  	}
    @GetMapping("average-IMDb-rating-by-studio/{productionStudio}")
    public Response avergaeIMDbratingByPrdStudio(@PathVariable String productionStudio) {
    	OptionalDouble dbratingByPrdStudio = movieService.avergaeIMDbratingByPrdStudio(productionStudio);
    	 return new Response(dbratingByPrdStudio, "Fetched Successfully", false);
    }
}
