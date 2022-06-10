package com.example.layout1

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun guideCard(
    page: Int,
    @DrawableRes category: Int,
    @DrawableRes screen: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.padding(start = 10.dp, end = 5.dp, top = 40.dp, bottom = 80.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(24.dp),
    ){
        Column (modifier = modifier.fillMaxSize(1f)){
            IconButton(
                modifier = modifier.size(75.dp),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    modifier = modifier.size(45.dp),
                    imageVector = Icons.Default.Close,
                    contentDescription = null
                )
            }
            Row {
                Column {
                    Image(
                        modifier = modifier.size(96.dp).padding(top = 12.dp),
                        painter = painterResource(id = category),
                        contentDescription = null
                    )
                    Text(
                        text = stringResource(id = text),
                        fontSize = 27.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(90.dp))
                    if (page > 0){
                        IconButton(
                            modifier = modifier.width(60.dp),
                            onClick= { /*TODO*/ }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth(1f)
                                    .size(60.dp)
                                    .rotate(90.0F),
                            )
                        }
                    }
                }
                Image(
                    modifier = modifier.height(420.dp).width(180.dp),
                    painter = painterResource(id = screen),
                    contentDescription = null
                )
                Column {
                    Spacer(modifier = Modifier.height(225.dp))
                    if (page < 5){
                        IconButton(
                            modifier = Modifier.width(60.dp),
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth(1f)
                                    .size(60.dp)
                                    .rotate(270.0F),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun guideCardPreview(){
    guideCard(
        page = 1,
        category = com.example.layout1.R.drawable.account_balance_48px,
        screen = com.example.layout1.R.drawable.homescreen,
        text =  com.example.layout1.R.string.category_history
    )
}
