package com.example.unitconvertor.ui.unit

enum class Unit(val factor1 :Double , val names :String) {
    LENGHT(0.0,"Lenght"),
    AREA(0.0,"Area"),
    TIME(0.0,"Time"),


    //LENGHT ALL THE UNITS

    METER(1.0,"Meter"),
    CENTI_METER(100.0,"Centimeter"),
    FOOT(3.28084,"foot"),
    MILI_METER(1000.0,"Milimeter"),

    // Area
    METER_SQUARE( 1.0,"Meter Square"),
    FOOT_SQUARE( 10.76,"Foot square"),
    CENTIMETER_SQUARE( 10000.0,"Centimeter Square"),
    ACRE( 0.000247,"Acre"),

    // Time
    MINUTE( 1.0,"Minute"),
    HOUR( 0.0167,"Hour"),
    SECONDS( 60.0,"Second")
}