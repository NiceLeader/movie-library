package github.io.NiceLeader.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieRepository movieRepository;

    @GetMapping("")
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }
    @GetMapping("/{id}")
    public Movie getById(@PathVariable("id") int id) {
        return movieRepository.getById(id);
    }

    @PostMapping("")
    public void add(@RequestBody List<Movie> movies) {
        movieRepository.add(movies);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        movieRepository.delete(id);
    }

    @PutMapping("")
    public int update(@PathVariable("id")int id, @RequestBody Movie updatedMovie) {
        Movie movie = movieRepository.getById(id);
        if (movie != null){
            movie.setName(updatedMovie.getName());
            movie.setRating(updatedMovie.getRating());
            movieRepository.update(movie);
        }else {
            return 0;
        }
        return id;
    }
}
