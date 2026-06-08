package com.jorgeromo.androidbasicsclass.ui.thirdpartialpdm1.homeThirdPartialPDM1.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jorgeromo.androidbasicsclass.ui.thirdpartialpdm1.homeThirdPartialPDM1.viewmodel.HomeThirdPartialPDM1ViewModel

data class GameRecommendation(
    val title: String,
    val genre: String,
    val rating: Float,
    val description: String,
    val emoji: String,
    val reason: String
)

val recommendations = listOf(
    GameRecommendation(
        "Street Fighter 6", "Pelea", 4.8f,
        "El mejor juego de pelea de la generación con controles modernos y modo mundo abierto.",
        "🥋", "Porque juegas Mortal Kombat 1"
    ),
    GameRecommendation(
        "Halo Infinite", "FPS", 4.5f,
        "El shooter icónico de Microsoft con campaña en mundo abierto y multijugador gratuito.",
        "🪖", "Porque juegas The Finals"
    ),
    GameRecommendation(
        "The Legend of Zelda: TotK", "Aventura", 4.9f,
        "Una aventura épica en Hyrule con libertad total para explorar cielos, tierra y profundidades OMGG.",
        "🗡️", "Popular entre tus amigos"
    ),
    GameRecommendation(
        "Hytale", "FPS", 4.6f,
        "Un juego increiblemente adictivo y que te sumergirá en su atrapante mundo de fantasía",
        "", "Porque juegas minecraft"
    )
)

@Composable
fun HomeThirdPartialPDM1View(
    homeViewModel: HomeThirdPartialPDM1ViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Recomendaciones",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Text(
            text = "Basadas en tus gustos",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(recommendations) { game ->
                RecommendationCard(game)
            }
        }
    }
}

@Composable
fun RecommendationCard(game: GameRecommendation) {
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(16.dp))
                    Text(" ${game.rating}", style = MaterialTheme.typography.bodySmall)
                }
            }

            Text(game.genre,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(vertical = 4.dp))

            Text(game.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 8.dp))

            Surface(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "💡 ${game.reason}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}