package com.jorgeromo.androidbasicsclass.ui.firstpartialpdm1.homeFirstPartialPDM1.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jorgeromo.androidbasicsclass.ui.firstpartialpdm1.homeFirstPartialPDM1.viewmodel.HomeFirstPartialPDM1ViewModel

data class Friend(
    val name: String,
    val status: String,
    val currentGame: String,
    val gamesCompleted: Int
)

val friendsList = listOf(
    Friend("Mario Jiménez", "En línea", "Elden Ring", 12),
    Friend("Sebastián Avitia", "En línea", "Hollow Knight", 8),
    Friend("Admin Epic", "Ausente", "Cyberpunk 2077", 25),
    Friend("Usuario Simple", "Desconectado", "Último juego: Zelda", 3)
)

@Composable
fun HomeFirstPartialPDM1View(
    homeViewModel: HomeFirstPartialPDM1ViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "👥 Amistades",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(friendsList) { friend ->
                FriendCard(friend)
            }
        }
    }
}

@Composable
fun FriendCard(friend: Friend) {
    val statusColor = when (friend.status) {
        "En línea" -> MaterialTheme.colorScheme.primary
        "Ausente" -> MaterialTheme.colorScheme.tertiary
        else -> MaterialTheme.colorScheme.outline
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Person, contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer)
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(friend.name, fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge)
                Text(friend.currentGame, style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text("${friend.gamesCompleted} juegos completados",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
            }

            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(statusColor)
            )
        }
    }
}