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
}
