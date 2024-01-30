package com.JetEye20.JetEye20.API;

import com.JetEye20.JetEye20.Repos.PointRepository;
import com.JetEye20.JetEye20.Repos.UserRepository;

import com.JetEye20.JetEye20.models.AdminResponse;
import com.JetEye20.JetEye20.models.GapPointData;
import com.JetEye20.JetEye20.models.Point;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {

    private final UserRepository userRepository;
    private final PointRepository pointRepository;



    @PostMapping("/startMove")
    public ResponseEntity startDriverMovement(@RequestBody GapPointData gapPointData){

        Point point = Point.builder()
                .driver(userRepository.findById(gapPointData.getDriverId()))
                .latitude(gapPointData.getLatitude())
                .longitude(gapPointData.getLongitude())
                .hasDriver(true)
                .isDone(false)
                .build();

        pointRepository.save(point);

        return ResponseEntity.ok("Movement started successfully");
    }

    @PostMapping("/updateMove")
    public ResponseEntity driverMovement(@RequestBody GapPointData gapPointData){

        Point gap = pointRepository.findByDriver(userRepository.findById(gapPointData.getDriverId()));
        gap.setLongitude(gapPointData.getLongitude());
        gap.setLatitude(gapPointData.getLatitude());
        System.out.println(gap.getLongitude());
        pointRepository.save(gap);

        return ResponseEntity.ok("Data was updated!!");
    }

    @GetMapping("/driverData")
    public ResponseEntity getDriverData(@RequestBody GapPointData gapPointData){
        System.out.println(gapPointData.getDriverId());
        Point point = pointRepository.findByDriver(userRepository.findById(gapPointData.getDriverId()));

        AdminResponse response = new AdminResponse();
        response.setLatitude(point.getLatitude());
        response.setLongitude(point.getLongitude());


        return ResponseEntity.ok(response);
    }

    @GetMapping("/stopMovement")
    public ResponseEntity stopMovement(@RequestBody GapPointData gapPointData){

        Point point = pointRepository.findByDriver(userRepository.findById(gapPointData.getDriverId()));
        point.setDone(true);
        pointRepository.delete(point);


        return ResponseEntity.ok("Movement stopped");
    }










}
