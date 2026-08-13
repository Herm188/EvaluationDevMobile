package com.example.decouvertemadagascar
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decouvertemadagascar.ui.theme.DecouverteMadagascarTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DecouverteMadagascarTheme {

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    App(
                        titre = stringResource(R.string.titre)
                    )
                }
            }
        }
    }
}


@Composable
fun App(
    titre: String,
    modifier: Modifier = Modifier
) {
    var nblike by remember { mutableStateOf(0) }
    var nbdislike by remember { mutableStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize()
            .padding(top = 30.dp)
    ) {

        Row(
            modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp)
        ) {
            Text(
                text = titre,
                fontSize = 30.sp,
                modifier = Modifier.weight(1f)
            )

            Card {
                Row(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "$nblike")

                    Image(
                        painter = painterResource(R.drawable.like),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )

                    Text(text = "$nbdislike")

                    Image(
                        painter = painterResource(R.drawable.like),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .graphicsLayer {
                                scaleY = -1f
                            }
                    )
                }
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {

            item {
                Destination(
                    titre = stringResource(R.string.andapa),
                    region = stringResource(R.string.sava),
                    description = stringResource(R.string.andapa_description),
                    activite = stringResource(R.string.andapa_activite),
                    image = R.drawable.andapa_one,
                    onLike = { nblike++ },
                    onDislike = { nbdislike++ }
                )
            }

            item {
                Destination(
                    titre = stringResource(R.string.mahajanga),
                    region = stringResource(R.string.boeny),
                    description = stringResource(R.string.mahajanga_description),
                    activite = stringResource(R.string.mahajanga_activite),
                    image = R.drawable.photo_1602174423520_daa2d87175a0,
                    onLike = { nblike++ },
                    onDislike = { nbdislike++ }
                )
            }

            item {
                Destination(
                    titre = stringResource(R.string.ambarijeby),
                    region = stringResource(R.string.sofia),
                    description = stringResource(R.string.ambarijeby_description),
                    activite = stringResource(R.string.ambarijeby_activite),
                    image = R.drawable._34934111834_8c43387e91_k,
                    onLike = { nblike++ },
                    onDislike = { nbdislike++ }
                )
            }

            item {
                Destination(
                    titre = stringResource(R.string.capSaintMarie),
                    region = stringResource(R.string.androy),
                    description = stringResource(R.string.capSaintMarie_description),
                    activite = stringResource(R.string.capSaintMarie_activite),
                    image = R.drawable.cap_st_marie_2,
                    onLike = { nblike++ },
                    onDislike = { nbdislike++ }
                )
            }

            item {
                Destination(
                    titre = stringResource(R.string.andasibe),
                    region = stringResource(R.string.antsinanana),
                    description = stringResource(R.string.andasibe_description),
                    activite = stringResource(R.string.andasibe_activite),
                    image = R.drawable.images,
                    onLike = { nblike++ },
                    onDislike = { nbdislike++ }
                )
            }

            item {
                Destination(
                    titre = stringResource(R.string.fortDauphin),
                    region = stringResource(R.string.anosy),
                    description = stringResource(R.string.fortDauphin_description),
                    activite = stringResource(R.string.fortDauphin_activite),
                    image = R.drawable.screen_shot_2018_12_19_at_5_32_46_am,
                    onLike = { nblike++ },
                    onDislike = { nbdislike++ }
                )
            }
        }
    }
}


@Composable
fun Destination(
    titre: String,
    region: String,
    description: String,
    activite: String,
    image: Int,
    onLike: () -> Unit,
    onDislike: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(4.dp)
    ) {
        Box {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Column {
                Text(text = titre,
                    color = Color.Black)
                Text(text = region,
                    color=Color.Black)
                Text(text = description,
                    color = Color.Yellow)
                Text(text = activite,
                    color = Color.Yellow)

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End) {
                    Image(
                        painter = painterResource(R.drawable.like),
                        contentDescription = "Like",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                onLike()
                            }
                    )

                    Image(
                        painter = painterResource(R.drawable.like),
                        contentDescription = "Dislike",
                        modifier = Modifier
                            .size(20.dp)
                            .graphicsLayer {
                                scaleY = -1f
                            }
                            .clickable {
                                onDislike()
                            }
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    DecouverteMadagascarTheme {

        App(
            titre = "Découverte de Madagascar"
        )
    }
}