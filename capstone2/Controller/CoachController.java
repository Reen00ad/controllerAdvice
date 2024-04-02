package com.example.capstone2.Controller;

import com.example.capstone2.ApiResponce.ApiResponse;
import com.example.capstone2.Model.Coatch;
import com.example.capstone2.Service.CoachService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coach")
@RequiredArgsConstructor
public class CoachController {

    private final CoachService coachService;

    Logger logger= LoggerFactory.getLogger(CoachController.class);

    @GetMapping("/get")
    public ResponseEntity getAllCoach(){
        logger.info("inside get all coach");
        return ResponseEntity.status(200).body(coachService.getAllCoach());
    }

    @PostMapping("/add")
    public ResponseEntity addCoach(@RequestBody @Valid Coatch coatch){
        logger.info("inside add coach");
        coachService.addCoach(coatch);
        return ResponseEntity.status(200).body(new ApiResponse("coach added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateCoach(@PathVariable Integer id,@RequestBody @Valid Coatch coatch){
        logger.info("inside update coach");
        coachService.updateCoach(id,coatch);
        return ResponseEntity.status(200).body(new ApiResponse("coach updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCoach(@PathVariable Integer id){
        logger.info("inside delete coach");
        coachService.deleteCoach(id);

        return ResponseEntity.status(200).body(new ApiResponse("coach deleted"));

    }

    @GetMapping("/without")
    public ResponseEntity<List<Coatch>> getCoachwithoutclasses(){
        logger.info("inside getCoachwithoutclasses coach");
        return ResponseEntity.status(200).body(coachService.getCoachwithoutclasses());
    }

    @GetMapping("/specialization/{gymid}")
    public ResponseEntity<List<Coatch>> getBySpecializationAsc(@PathVariable Integer gymid){
        logger.info("inside getBySpecializationAsc coach");
        return ResponseEntity.status(200).body(coachService.getBySpecializationAsc(gymid));
    }
}
