package com.example.unitconvertor.ui.unit

import com.example.unitconvertor.ui.unit.Unit

object Utility {

    val unitlist = arrayListOf(Unit.LENGHT.names,Unit.AREA.names,Unit.TIME.names)
    val lengthlist = arrayListOf(Unit.METER,Unit.CENTI_METER,Unit.FOOT,Unit.MILI_METER)
    val arealist = arrayListOf(Unit.METER_SQUARE,Unit.ACRE,Unit.CENTIMETER_SQUARE,Unit.FOOT_SQUARE)
    val timelist = arrayListOf(Unit.SECONDS,Unit.HOUR,Unit.MINUTE)
}