package com.example.capstone2.Controller;

import com.example.capstone2.ApiResponce.ApiResponse;
import com.example.capstone2.Model.Classes;
import com.example.capstone2.Service.ClassesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
@RequiredArgsConstructor
public class ClassesController {

    private final ClassesService classesService;

    Logger logger= LoggerFactory.getLogger(ClassesController.class);

    @GetMapping("/get")
    public ResponseEntity getAllClasses(){
        logger.info("inside get all classes");

        return ResponseEntity.status(200).body(classesService.getAllClasses());
    }

    @PostMapping("/add")
    public ResponseEntity addClasses(@RequestBody @Valid Classes classes){
        logger.info("inside add classes");
        classesService.addClasses(classes);
        return ResponseEntity.status(200).body(new ApiResponse("classes added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateClasses(@PathVariable Integer id,@RequestBody @Valid Classes classes){
        logger.info("inside update classes");
        classesService.updateClasses(id,classes);
        return ResponseEntity.status(200).body(new ApiResponse("classes updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClasses(@PathVariable Integer id){
        logger.info("inside delete classes");
        classesService.deleteClasses(id);

        return ResponseEntity.status(200).body(new ApiResponse("classes deleted"));

    }

    @GetMapping("/fully")
    public ResponseEntity<List<Classes>> getfullybooked(){
        logger.info("inside getfullybooked in classes");
        return ResponseEntity.status(200).body(classesService.getFullyBooked());
    }


    @GetMapping("/available")
    public ResponseEntity<List<Classes>> getEmptyClasses(){
        logger.info("inside getEmptyClasses in classes");
        return ResponseEntity.status(200).body(classesService.getAvailableClasses());
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<Classes>> getUpcomingclasses(){
        logger.info("inside getupcomingclasses in classes");
        return ResponseEntity.status(200).body(classesService.getUpcomingClasses());
    }

    @GetMapping("/time/{time}")
    public ResponseEntity<List<Classes>> getClassesStartAt(@PathVariable Time time){
        logger.info("inside getClassesStartAt in classes");
        return ResponseEntity.status(200).body(classesService.getClassesStartAt(time));
    }


    @GetMapping("/byname/{cname}")
    public ResponseEntity<List<Classes>> getClassesbycoachname(@PathVariable String cname){
        logger.info("inside getClassesbycoachname in classes");
        return ResponseEntity.status(200).body(classesService.getClassesbycoachname(cname));
    }

}
