package com.JetEye20.JetEye20.Repos;

import com.JetEye20.JetEye20.models.Point;
import com.JetEye20.JetEye20.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.sql.Driver;

public interface PointRepository extends MongoRepository<Point,Long> {
    Point findById(String driverId);

    Point findByDriver(User driverId);
}
