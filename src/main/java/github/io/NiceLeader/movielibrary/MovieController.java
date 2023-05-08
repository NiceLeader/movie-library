package github.io.NiceLeader.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class MovieController {
    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/test")
    public int test() {
        return 1;
    }

    @GetMapping("/movies")
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }
}
