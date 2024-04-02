package com.example.capstone2.Controller;

import com.example.capstone2.ApiResponce.ApiResponse;
import com.example.capstone2.Model.MealPlaning;
import com.example.capstone2.Service.MealPlaningService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mealplaning")
@RequiredArgsConstructor
public class MealPlaningController {

    private final MealPlaningService mealPlaningService;

    Logger logger= LoggerFactory.getLogger(MealPlaningController.class);

    @GetMapping("/get")
    public ResponseEntity getAllMealPlaning(){
        logger.info("inside gel all meal planing");
        return ResponseEntity.status(200).body(mealPlaningService.getAllMealPlaning());
    }

    @PostMapping("/add")
    public ResponseEntity addMealPlaning(@RequestBody @Valid MealPlaning mealPlaning){

        logger.info("inside add  meal planing");
        mealPlaningService.addMealPlaning(mealPlaning);
        return ResponseEntity.status(200).body(new ApiResponse("MealPlaning added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMealPlaning(@PathVariable Integer id, @RequestBody @Valid MealPlaning mealPlaning){
        logger.info("inside update meal planing");
        mealPlaningService.updateMealPlaning(id,mealPlaning);
        return ResponseEntity.status(200).body(new ApiResponse("MealPlaning updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMealPlaning(@PathVariable Integer id){
        logger.info("inside delete MealPlaning");
        mealPlaningService.deleteMealPlaning(id);

        return ResponseEntity.status(200).body(new ApiResponse("MealPlaning deleted"));

    }

    @GetMapping("/calculate/{userid}")
    public ResponseEntity calculateCalorise(@PathVariable Integer userid){
        logger.info("inside calculateCalorise in MealPlaning");
        return ResponseEntity.status(200).body(mealPlaningService.calculateCalorise(userid));
    }

    @GetMapping("/bmi/{userid}")
    public ResponseEntity calculateBMI(@PathVariable Integer userid){
        logger.info("inside calculateBMI in MealPlaning");
        return ResponseEntity.status(200).body(mealPlaningService.calculateBMI(userid));
    }

    @GetMapping("/checkforfood/{userid}/{foodid}")
    public ResponseEntity checkForFoodCal(@PathVariable Integer userid, @PathVariable Integer foodid){
        logger.info("inside checkForFoodCal in MealPlaning");
        return ResponseEntity.status(200).body(mealPlaningService.checkForFoodCal(userid, foodid));
    }

    @GetMapping("/ideal/{userid}")
    public ResponseEntity idealweight(@PathVariable Integer userid){
        logger.info("inside idealweight in MealPlaning");
        return ResponseEntity.status(200).body(mealPlaningService.getIdealWeight(userid));
    }






}
