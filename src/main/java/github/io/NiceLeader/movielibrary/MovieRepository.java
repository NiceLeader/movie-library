package github.io.NiceLeader.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;





    public List<Movie> getAll() {
        return jdbcTemplate.query("SELECT id, name, rating FROM movielibrary.movie",
                BeanPropertyRowMapper.newInstance(Movie.class));
    }

    public Movie getById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, name, rating FROM  movielibrary.movie WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Movie.class), id);
    }


    public void add(List<Movie> movies) {
        movies.forEach(movie -> jdbcTemplate
                .update("INSERT INTO  movielibrary.movie(name, rating) VALUES (?, ?)",
                movie.getName(), movie.getRating()
        ));
    }
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM movielibrary.movie WHERE id = ?", id);
    }
    public void update(Movie movie) {
        jdbcTemplate.update("UPDATE movielibrary.movie SET name = ?, rating = ? WHERE id = ?",
                movie.getName(), movie.getRating(), movie.getId());
    }

}
