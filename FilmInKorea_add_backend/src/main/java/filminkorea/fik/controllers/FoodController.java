package filminkorea.fik.controllers;

import filminkorea.fik.entities.Food;
import filminkorea.fik.entities.FoodMap;
import filminkorea.fik.services.FoodMapService;
import filminkorea.fik.services.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;
    private final FoodMapService foodMapService;

    // 생성자에서 두 서비스 의존성을 주입받음
    @Autowired
    public FoodController(FoodService foodService, FoodMapService foodMapService) {
        this.foodService = foodService;
        this.foodMapService = foodMapService;
    }

    // 모든 맛집 데이터를 가져오는 API
    @GetMapping("/all")
    @Operation(summary = "Get all food places", description = "Retrieve a list of all food places stored in the system.")
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    // 지도에 표시할 맛집의 모든 정보 리스트를 가져오는 API
    @GetMapping("/map")
    @Operation(summary = "Get all food places for the map", description = "Retrieve all food place information to be displayed on the map.")
    public ResponseEntity<List<FoodMap>> getAllFoodPlaces() {
        List<FoodMap> foodPlaces = foodMapService.getAllFoodPlacesOnTheMap();
        return ResponseEntity.ok(foodPlaces);
    }


}
