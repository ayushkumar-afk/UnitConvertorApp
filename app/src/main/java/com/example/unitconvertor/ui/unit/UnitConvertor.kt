package com.example.unitconvertor.ui.unit

import android.graphics.Paint

import android.widget.Toast
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconvertor.ui.unit.Unit
import java.text.DecimalFormat

@Composable

fun UnitConvertor(modifier: Modifier = Modifier){



    var unitList by remember { mutableStateOf(Utility.lengthlist) }
    val (SelectedOption, OnOptionSelected) = remember { mutableStateOf(Utility.unitlist[0]) }
    var expandfrom by remember { mutableStateOf(false) }
    var expandto by remember { mutableStateOf(false) }
    var selectedfrom by remember { mutableStateOf(unitList[0]) }
    var selectedto by remember { mutableStateOf(unitList[0]) }
    var inputvalue by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column {

        Spacer(modifier = Modifier.padding(top = 50.dp))
        Text(
            text = "Pick Category",
            modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold



        )

        Row {
            Utility.unitlist.forEach{  list->
                Card(
                    modifier = Modifier.padding(23.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (list == SelectedOption) Color.Yellow else Color.White
                    )
                    , onClick =  {
                        OnOptionSelected(list)
                        when (list){
                            Unit.LENGHT.names ->
                                unitList = Utility.lengthlist

                            Unit.AREA.names->
                                unitList = Utility.arealist

                            Unit.TIME.names->
                                unitList =Utility.timelist

                        }

                        selectedfrom = unitList[0]
                        selectedto = unitList[0]

                    }


                )


                {
                    Text(
                        text = list,
                        modifier = Modifier.padding(15.dp)




                    )
                }

            }

        }
        Spacer(modifier = Modifier.padding(top = 15.dp))
        Text(
            text = "Convertor",
            modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold



        )

        Row {
            Text(

                text = "Convert from :-",

                )

            Button(
                modifier = Modifier.padding(start = 10.dp),
                onClick = {
                expandfrom = true      // Expand the DropDownMenu on Click of it
                }
            ) {
                Text(
                    selectedfrom.names    // Displays the currently selected unit
                )
                Icon(
                    Icons.Default.ArrowDropDown,
                    contentDescription = "arrowdown"
                )

            }
            DropdownMenu(
                expanded = expandfrom,
                onDismissRequest = {
                    expandfrom = false    // Closes the dropdown when clicked outside
                }
            ) {
                unitList.forEach { unit->
                    DropdownMenuItem(
                        text = {
                            Text(unit.names)
                        }, onClick =  {
                            selectedfrom = unit
                            expandfrom = false

                        }
                    )
                }
            }


        }


        Row {
            Text(

                text = "Convert to :-",

                )

            Button(
                modifier = Modifier.padding(start = 10.dp),
                onClick = {
                    expandto = true      // Expand the DropDownMenu on Click of it
                }
            ) {
                Text(
                    selectedto.names    // Displays the currently selected unit
                )
                Icon(
                    Icons.Default.ArrowDropDown,
                    contentDescription = "arrowdown"
                )

            }
            DropdownMenu(
                expanded = expandto,
                onDismissRequest = {
                    expandto = false    // Closes the dropdown when clicked outside
                }
            ) {
                unitList.forEach { unit->
                    DropdownMenuItem(
                        text = {
                            Text(unit.names)
                        }, onClick =  {
                            selectedto = unit
                            expandto = false

                        }
                    )
                }
            }




        }

        OutlinedTextField(
            value = inputvalue,
            onValueChange = {
                result =""
                inputvalue = it
            },
            label = {
                Text("Enter the Value")
            },
            placeholder = {
                Text("Enter No")
            }, modifier = Modifier.padding(15.dp).fillMaxWidth(),
            //KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)




        )

        Button(
            onClick = {
                val df =DecimalFormat("#.##")
            //    df.roundingMode = CEILING
                result = df.format(inputvalue.text.toDouble() * selectedto.factor1/selectedfrom.factor1)
            },
            enabled = inputvalue.text != ""
        ) {
            Text("Convert")
        }

        Text(
            "Result:- $result"
        )


    }
}


@Preview
@Composable
fun demo(){
    UnitConvertor()
}


//KOTLIN DESTRUCTION FEATURE IN THE VAR AS THE RADIO BUTTON HAS BEEN USED CHECK ONCE



