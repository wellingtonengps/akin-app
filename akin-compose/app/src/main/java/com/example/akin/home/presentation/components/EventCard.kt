package com.example.akin.home.presentation.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.akin.R
import com.example.akin.home.data.Event
import com.example.akin.home.data.Hobby
import com.example.akin.home.data.HobbyIcon
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.time.Duration.Companion.days

@Composable
fun EventCard(
    event: Event
) {

    val calendar = Calendar.getInstance()
    calendar.time = event.date
    val dayEvent = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))

    val dateFormat = SimpleDateFormat("MMMM", Locale("pt", "BR"))
    val monthEvent = dateFormat.format(calendar.time).capitalize()


    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD9D9D9)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .height(140.dp)
            .width(216.dp)
    ) {
       Box(){
           Image(
               painter = painterResource(id = R.drawable.rectangle_9),
               contentDescription = null,
               modifier = Modifier.fillMaxSize(),
               contentScale = ContentScale.Crop
           )
           Row(
               modifier = Modifier.padding(12.dp)
           ) {
               Column {
                   Text(
                       text = dayEvent,
                       color = Color(0xFFD9D9D9),
                       fontSize = 20.sp,
                       modifier = Modifier.padding(bottom = 2.dp)
                   )
                   Text(
                       color = Color(0xFFD9D9D9),
                       text = monthEvent,
                       fontSize = 16.sp,
                       modifier = Modifier.padding(bottom = 2.dp)
                   )
                   Text(
                       color = Color(0xFFD9D9D9),
                       text = event.title,
                       fontSize = 20.sp,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier.padding(bottom = 6.dp)
                   )
                   Hobbies(hobbies = event.category)
               }
           }
       }
    }
}

@Preview
@Composable
private fun EventCardPreview() {
    EventCard(event)
}


val event = Event(
    id = 1,
    title = "RPG da UFJF",
    date = Date(),
    description = "Jogar RPG de mesa na UFJF",
    location = "Jardim da UFJF",
    participantList = listOf("Well", "Emanuel", "Kamuel"),
    category = listOf(
        Hobby(id = 1, name = "casino")
    ),
)

