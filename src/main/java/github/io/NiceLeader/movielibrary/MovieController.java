package github.io.NiceLeader.movielibrary;

import org.springframework.web.bind.annotation.GetMapping;

public class MovieController {

    @GetMapping("/test")
    public int test() {
        return 1;
    }
}
