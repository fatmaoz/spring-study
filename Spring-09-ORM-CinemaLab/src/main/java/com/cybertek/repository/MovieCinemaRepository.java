package com.cybertek.repository;

import com.cybertek.entity.Cinema;
import com.cybertek.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema,Long> {
    // ------------------- DERIVED QUERIES ------------------- //
//Write a derived query to read movie cinema with id
    Optional<MovieCinema> findById(Long cinemaId);
//Write a derived query to count all movie cinemas with a specific cinema id
    Integer countAllByCinemaId(Long id);
//Write a derived query to count all movie cinemas with a specific movie id
    Integer countAllByMovieId(Integer movieId);
//Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByDateTimeAfter(LocalDate dateTime);
//Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findFirst3ByOrderByMoviePriceAsc();
//Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findAllByMovieNameContaining(String name);
//Write a derived query to list all movie cinemas in a specific location
    List<MovieCinema> findAllByCinemaLocationName(String location);
// ------------------- JPQL QUERIES ------------------- //
//Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("SELECT m FROM MovieCinema  m WHERE m.dateTime>?1")
    List<MovieCinema> retrieveAllMovieHigherThan(LocalDate localDate);
// ------------------- Native QUERIES ------------------- //
//Write a native query to count all movie cinemas by cinema id
    @Query(value = "SELECT COUNT (*)  FROM movie_cinema WHERE cinema_id=?1",nativeQuery = true)
    Integer retrieveTotalCinema(Long cinemaId);
//***************Write a native query that returns all movie cinemas by location name
    @Query(value = "SELECT * FROM movie_cinema mc JOIN cinema c c.id=mc.ciname_id JOIN location l ON c.location_id=l.id WHERE l.name=?1",nativeQuery = true)
    List<MovieCinema> retrieveAllMovieByLocationName(String locationName);
}
