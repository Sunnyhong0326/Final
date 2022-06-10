package com.example.layout1

import android.graphics.Paint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CollectionBook(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(R.drawable.book),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clickable(
                    enabled = true,
                    onClickLabel = "Book",
                    onClick = {}
                )
        )
        Text(text = "Book")
    }
}

@Composable
fun SearchBar()
{
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {text = it},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = Modifier.width(270.dp)
    )
}

@Composable
fun Basic(
    @StringRes name: Int,
    value: Int
) {
    Column(modifier = Modifier.width(170.dp)) {
        Text(
            text = stringResource(name),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(
                painter = painterResource(R.drawable.heart),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = stringResource(R.string.intimacy),
            )
            Text(
                text = value.toString(),
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }
}

@Composable
fun Friend(
    @DrawableRes drawable: Int,
    @StringRes name: Int,
){
    Surface(
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(20.dp),
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Basic(name,56)
            Spacer(modifier = Modifier.width(30.dp))
            Image(
                painterResource(R.drawable.reminder),
                contentDescription ="reminder icon",
                modifier = Modifier
                    .size(60.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = "Reminder",
                        onClick = {}
                    )

            )
        }
    }
}

@Composable
fun FriendList(){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(vertical = 15.dp, horizontal = 15.dp)
    ) {
        items(FriendInfos) { item ->
            Friend(item.drawable, item.name)
        }
    }
}

@Composable
fun Homepage(
    isStarter: Boolean = false
){
    Box(modifier = Modifier.fillMaxSize(1f)
    ){
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.width(370.dp)){
            CollectionBook()
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.question_mark),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(10.dp)
                    .size(30.dp)
                    .align(Alignment.Start)
                    .clickable(
                        enabled = true,
                        onClickLabel = "Homepage_Teaching",
                        onClick = {}
                    )
            )
            Spacer(modifier = Modifier.height(70.dp))
            Image(
                painter = painterResource(R.drawable.jirachi),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(250.dp)
            )
            Text(
                text = "FRIENDS",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(verticalAlignment = Alignment.CenterVertically){
                SearchBar()
                Spacer(modifier = Modifier.width(15.dp))
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable(
                            enabled = true,
                            onClickLabel = "Sharing",
                            onClick = {}
                        )
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            FriendList()
        }
        if (isStarter){
        Box(){
            guideCard(
                page = 1,
                category = R.drawable.account_balance_48px,
                screen = R.drawable.homescreen,
                text = R.string.category_history
            )
        }
    }
    }
}

private val FriendInfos = listOf(
    R.drawable.wu to R.string.Wu,
    R.drawable.sophia to R.string.Sophia,
    R.drawable.lucy to R.string.Lucy,
    R.drawable.alice to R.string.Alice,
    R.drawable.christen to R.string.Christen,
    R.drawable.sam to R.string.Sam,
    R.drawable.jennifer to R.string.Jennifer
).map { FriendInfoPair(it.first, it.second) }

private data class FriendInfoPair(
    @DrawableRes val drawable: Int,
    @StringRes val name: Int
)

@Preview(showBackground = true)
@Composable
fun FriendPreview() {
    Friend(R.drawable.wu, R.string.Wu)
}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun HomepagePreview() {
    Homepage()
}