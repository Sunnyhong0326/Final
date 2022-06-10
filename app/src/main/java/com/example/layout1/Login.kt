package com.example.layout1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun login(
    modifier: Modifier = Modifier,
    onSetName: (String) -> Unit = {},
    onClickConfirmName: () -> Unit = {}
){
    Image(
        modifier = modifier.fillMaxSize(1f),
        painter = painterResource(id = R.drawable.login),
        contentDescription = null
    )
    Column (
        modifier = modifier.fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Text(
            text = "Friendly\n好友記帳",
            fontSize = 40.sp
        )
        Spacer(modifier = modifier.heightIn(50.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {onSetName},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null) },
            placeholder = { Text(text = "Your Name") }
        )
        TextButton(
            onClick = { onClickConfirmName },
            modifier = Modifier
                .width(120.dp)
                .background(
                    color = Color(0xFFFFA500),
                    shape = RoundedCornerShape(25.dp)
                )
        ) {
            Text(
                text = "Start!",
                fontSize = 20.sp,
                color = Color(0f,0f,0f)
            )
        }
    }

}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun loginPreview(){
    login()
}