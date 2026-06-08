package com.jorgeromo.androidbasicsclass.ui.personalinformation.homePersonalInformation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jorgeromo.androidbasicsclass.ui.personalinformation.homePersonalInformation.viewmodel.HomePersonalInformationViewModel

@Composable
fun HomePersonalInformationView(
    homeViewModel: HomePersonalInformationViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text("🧟", style = MaterialTheme.typography.displaySmall)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Sebastián Avitia",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            "SebastianAvitia@hotmail.com",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp)) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Algo sobre mí:...", fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium)
                Text(
                    "Yo soy un gamer desde los 9 años. Me encantan los juegos intensos, de zombies, de mundo abierto y con mucha libertad oh yeah",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp)) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Estadísticas", fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium)
                ProfileStat("🎮 Juego favorito", "Dying Light: The Beast")
                ProfileStat("🖥️ Plataforma favorita", "PC")
                ProfileStat("⏱️ Juego con más horas", "Red Dead Redemption 2")
                ProfileStat("🕐 Total de horas jugadas", "1400 horas")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ProfileStat(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(value, style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold)
    }
}