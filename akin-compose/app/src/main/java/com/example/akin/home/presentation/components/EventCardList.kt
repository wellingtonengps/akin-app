package com.example.akin.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.akin.home.data.Event
import com.example.akin.home.data.events
import java.util.Date

@Composable
fun EventCardList(events: List<Event>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 26.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(events) {
            event-> EventCard(event = event)
        }
    }
}

@Preview(showBackground = true, device = Devices.DEFAULT)
@Composable
private fun EventCardListPreview() {
    EventCardList(events = events)
}

