package com.example.capstone2.Controller;

import com.example.capstone2.ApiResponce.ApiResponse;
import com.example.capstone2.Model.Booking;
import com.example.capstone2.Service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    Logger logger= LoggerFactory.getLogger(BookingController.class);

    @GetMapping("/get")
    public ResponseEntity getAllBooking(){
        logger.info("inside get all booking");

        return ResponseEntity.status(200).body(bookingService.getAllBooking());
    }

    @PostMapping("/add")
    public ResponseEntity addBooking(@RequestBody @Valid Booking booking){
        logger.info("inside add booking");

        bookingService.addBooking(booking);
        return ResponseEntity.status(200).body(new ApiResponse("booking class is done"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBooking(@PathVariable Integer id,@RequestBody @Valid Booking booking ){
        logger.info("inside update booking");
        bookingService.updateBooking(id,booking);
        return ResponseEntity.status(200).body(new ApiResponse("booking updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBooking(@PathVariable Integer id){
        logger.info("inside delete booking");
        bookingService.deleteBooking(id);

        return ResponseEntity.status(200).body(new ApiResponse("cancel booking is done"));

    }


    @GetMapping("/getuserbooking/{userid}")
    public ResponseEntity<List<Booking>> getUserbooking(@PathVariable Integer userid){
        logger.info("inside getUserbooking in booking");
        return ResponseEntity.status(200).body(bookingService.getUserbooking(userid));
    }

    
}
