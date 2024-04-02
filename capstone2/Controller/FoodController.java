package com.example.capstone2.Controller;

import com.example.capstone2.ApiResponce.ApiResponse;
import com.example.capstone2.Model.Food;
import com.example.capstone2.Service.FoodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    Logger logger= LoggerFactory.getLogger(FoodController.class);


    @GetMapping("/get")
    public ResponseEntity getAllFood(){
        logger.info("inside get all food");
        return ResponseEntity.status(200).body(foodService.getAllFood());
    }

    @PostMapping("/add")
    public ResponseEntity addFood(@RequestBody @Valid Food food){
        logger.info("inside add food");
        foodService.addFood(food);
        return ResponseEntity.status(200).body(new ApiResponse("food added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateFood(@PathVariable Integer id,@RequestBody @Valid Food food){
        logger.info("inside update food");
        foodService.updateFood(id,food);
        return ResponseEntity.status(200).body(new ApiResponse("food updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFood(@PathVariable Integer id){
        logger.info("inside delete food");
        foodService.deleteFood(id);

        return ResponseEntity.status(200).body(new ApiResponse("food deleted"));

    }

    @GetMapping("/bycal/{cal}")
    public ResponseEntity<List<Food>> getFoodlessthancal(@PathVariable Double cal){
        logger.info("inside getFoodlessthancal food");
        return ResponseEntity.status(200).body(foodService.getFoodlessthan(cal));
    }




}
