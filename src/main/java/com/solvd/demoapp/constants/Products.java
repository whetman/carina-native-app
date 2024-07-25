package com.solvd.demoapp.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Products {

    BAGBLACK("BagBlack Image"),
    BIKELIGHT("BikeLight Image"),
    SHIRTBLACK("ShirtBlack Image"),
    ONESIE("ShirtRedOnesie Image"),
    SHIRTRED("ShirtRed Image");

    private final String name;
}
