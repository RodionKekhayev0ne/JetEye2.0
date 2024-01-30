package com.JetEye20.JetEye20.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GapPointData {

    private String driverId;

    private Double longitude;

    private Double latitude;

}
