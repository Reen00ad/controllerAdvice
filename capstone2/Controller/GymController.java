package com.example.capstone2.Controller;

import com.example.capstone2.ApiResponce.ApiResponse;
import com.example.capstone2.Model.Gym;
import com.example.capstone2.Service.GymService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gym")
@RequiredArgsConstructor
public class GymController {

    private final GymService gymService;

    Logger logger= LoggerFactory.getLogger(GymController.class);

    @GetMapping("/get")
    public ResponseEntity getAllGym(){
        logger.info("inside get all gym");
        return ResponseEntity.status(200).body(gymService.getALlGym());
    }

    @PostMapping("/add")
    public ResponseEntity addGym(@RequestBody @Valid Gym gym){
        logger.info("inside add gym");
        gymService.addGym(gym);
        return ResponseEntity.status(200).body(new ApiResponse("gym added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateGym(@PathVariable Integer id, @RequestBody @Valid Gym gym){
        logger.info("inside update gym");
        gymService.updateGym(id,gym);
        return ResponseEntity.status(200).body(new ApiResponse("gym updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteGym(@PathVariable Integer id){
        logger.info("inside delete gym");
        gymService.deleteGym(id);

        return ResponseEntity.status(200).body(new ApiResponse("gym deleted"));

    }




}
