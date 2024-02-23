package com.my.movie.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.movie.entity.Movie;
import com.my.movie.entity.Response;
import com.my.movie.repo.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepo movieRepo;

	@Override
	public List<Movie> movieWithNonNullIMDB() {
		List<Movie> collect = movieRepo.findAll().stream().filter(i -> !i.getImdbRating().equals(null))
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<Movie> movieWithNullIMDB() {
		return movieRepo.findAll().stream().filter(i -> i.getImdbRating().equals(null)).collect(Collectors.toList());
	}

	@Override
	public List<Movie> movieWithIMDbRatingDecendingOrder() {
		return movieRepo.findAll().stream().sorted(Comparator.comparingDouble(Movie::getImdbRating).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public List<Movie> top5BollyWoodMovieWithLowIMDbAscending() {
		return movieRepo.findAll().stream().filter(i -> i.getIndustry().equalsIgnoreCase("bollywood"))
				.sorted(Comparator.comparingDouble(Movie::getImdbRating)).limit(5).toList();
	}

	@Override
	public List<Movie> top5HollywoodMovieWihHighestIMDb() {
		return movieRepo.findAll().stream().filter(i -> i.getIndustry().equalsIgnoreCase("hollywood"))
				.sorted(Comparator.comparingDouble(Movie::getImdbRating)).skip(3).limit(5).toList();
	}

	@Override
	public List<Movie> allMoviesOrderByReleaseYearDesc() {
		return movieRepo.findAll().stream().sorted(Comparator.comparing(Movie::getReleaseYear).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public List<Movie> allMoviesReleasedInYear(Integer releaseYear) {
		System.out.println("cfvghjkl;");
		return movieRepo.findAll().stream().filter(i -> i.getReleaseYear().equals(releaseYear))
				.collect(Collectors.toList());
	}

	@Override
	public List<Movie> movieReleasedAfterWithIMDbRatinggreater(Integer releaseYear, Double imdbRating) {
		return movieRepo.findAll().stream().filter(i -> i.getReleaseYear() > releaseYear)
				.filter(i -> i.getImdbRating() > imdbRating).collect(Collectors.toList());
	}

	@Override
	public List<Movie> movieReleasedInYear(Integer releaseYear) {
		return movieRepo.findAll().stream().filter(i -> i.getReleaseYear().equals(releaseYear))
				.collect(Collectors.toList());
	}

	@Override
	public List<Movie> moviesProducedBy(String productionStudio) {
		return movieRepo.findAll().stream().filter(i -> i.getProductionStudio().equalsIgnoreCase(productionStudio))
				.collect(Collectors.toList());
	}

	@Override
	public List<Movie> movieTitleWithAndDescYr(String title) {
		return movieRepo.findAll().stream().filter(i -> i.getTitle().equalsIgnoreCase(title))
				.sorted(Comparator.comparing(Movie::getReleaseYear).reversed()).collect(Collectors.toList());
	}

	@Override
	public List<Movie> movieNotProduceByPrdStdudio(String productionStudio) {
		return movieRepo.findAll().stream().filter(i -> !i.getProductionStudio().equalsIgnoreCase(productionStudio))
				.collect(Collectors.toList());
	}

	@Override
	public long noOfMovieInIndustry(String industry) {
		long count = movieRepo.findAll().stream().filter(i -> i.getIndustry().equalsIgnoreCase(industry)).count();

		return count;
	}

	@Override
	public Optional<Movie> maximumIMDbRating(String industry) {
		Optional<Movie> max = movieRepo.findAll().stream().filter(i -> i.getIndustry().equalsIgnoreCase(industry))
				.max(Comparator.comparingDouble(Movie::getImdbRating));
		return max;
	}

	@Override
	public Optional<Movie> minimumIMDbRating(String industry) {
		Optional<Movie> min = movieRepo.findAll().stream().filter(i -> i.getIndustry().equalsIgnoreCase(industry))
				.min(Comparator.comparingDouble(Movie::getImdbRating));
		return min;
	}

	@Override
	public OptionalDouble avergaeIMDbratingByPrdStudio(String productionStudio) {
		OptionalDouble average = movieRepo.findAll().stream().filter(i->i.getProductionStudio().equalsIgnoreCase(productionStudio)).mapToDouble(Movie::getImdbRating).average();

		return average;
	}



//	@Override
//	public Optional Double avergaeIMDbratingByPrdStudio(String productionStudio) {
//			 OptionalDouble average = movieRepo.findAll().stream().filter(i->i.getProductionStudio().equalsIgnoreCase(productionStudio)).mapToDouble(Movie::getImdbRating).average();
//		return average;
//	}

}
