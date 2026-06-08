package com.jorgeromo.androidbasicsclass.ui.secondpartialpdm1.homeSecondPartialPDM1.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jorgeromo.androidbasicsclass.ui.secondpartialpdm1.homeSecondPartialPDM1.viewmodel.HomeSecondPartialPDM1ViewModel

data class GameProgress(
    val title: String,
    val platform: String,
    val progress: Int,
    val status: String,
    val emoji: String
)

@Composable
fun HomeSecondPartialPDM1View(
    onNavigateToGameApi: () -> Unit = {},
    homeViewModel: HomeSecondPartialPDM1ViewModel = viewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "🎮 Mi Progreso",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Consulta tus juegos y progreso desde la API",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Button(
            onClick = onNavigateToGameApi,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cargar desde API")
        }
    }
}

@Composable
fun GameProgressCard(game: GameProgress) {
    val statusColor = when (game.status) {
        "Completado" -> MaterialTheme.colorScheme.primary
        "En progreso" -> MaterialTheme.colorScheme.tertiary
        else -> MaterialTheme.colorScheme.outline
    }
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("${game.emoji} ${game.title}",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge)
                Badge(containerColor = statusColor) {
                    Text(game.status, modifier = Modifier.padding(horizontal = 4.dp))
                }
            }
            Text(game.platform,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(vertical = 8.dp))
            LinearProgressIndicator(
                progress = { game.progress / 100f },
                modifier = Modifier.fillMaxWidth(),
                color = statusColor
            )
            Text("${game.progress}%",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp))
        }
    }
}