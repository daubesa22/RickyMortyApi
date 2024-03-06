package com.danielubeda.rickymortyapi.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.danielubeda.rickymortyapi.R
import com.danielubeda.rickymortyapi.model.Character

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(characters: List<Character>, onCharacterClick: (Int) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Image(
                            painter = rememberAsyncImagePainter(model = R.drawable.logorickymorty),
                            contentDescription = "Logo Rick y Morty",
                            modifier = Modifier
                                .size(60.dp)
                                .clip(RoundedCornerShape(50.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = colorResource(id = R.color.nav_bar)
                )
            )
        }
    ) { innerPadding ->
        CharacterListContent(characters = characters, padding = innerPadding, onCharacterClick = onCharacterClick)
    }
}



@Composable
fun CharacterListContent(characters: List<Character>, padding: PaddingValues, onCharacterClick: (Int) -> Unit) {
    LazyColumn(contentPadding = padding) {
        items(items = characters, key = { character ->
            character.id
        }) { character ->
            CharacterRow(character = character, onClick = { onCharacterClick(character.id) })
        }
    }
}

@Composable
fun CharacterRow(character: Character, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .clickable(onClick = onClick)
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        color = colorResource(id = R.color.row_color),
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = character.image),
                    contentDescription = "Character Image",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(50.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = character.name,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Status: ${character.status}",
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Species: ${character.species}",
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Gender: ${character.gender}",
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

