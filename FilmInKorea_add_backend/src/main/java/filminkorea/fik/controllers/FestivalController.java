package filminkorea.fik.controllers;

import filminkorea.fik.entities.Festival;
import filminkorea.fik.repositories.FestivalRepository;
import filminkorea.fik.services.FestivalService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/festival")
@CrossOrigin(origins = "http://localhost:3000")
public class FestivalController {

    @Autowired
    private FestivalService festivalService;

    @GetMapping("/current")
    @Operation(summary = "Get currently ongoing festivals", description = "Fetch a list of festivals that are currently ongoing based on the system date.")
    public List<Festival> getCurrentFestivals() {
        return festivalService.getCurrentFestivals();
    }

    // 사계절 별 축제 데이터 가져오기
    @GetMapping("/season")
    @Operation(summary = "Get festivals by season", description = "Fetch a list of festivals for a specified season (Spring, Summer, Fall, Winter) from the system.")
    public List<Festival> getFestivalsBySeason(@RequestParam String season) {
        return festivalService.getFestivalsBySeason(season);
    }
}
