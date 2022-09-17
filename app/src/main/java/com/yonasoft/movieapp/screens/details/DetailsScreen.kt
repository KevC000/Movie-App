package com.yonasoft.movieapp.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.yonasoft.movieapp.model.Movie
import com.yonasoft.movieapp.model.getMovies
import com.yonasoft.movieapp.widgets.MovieRow


@Composable
fun DetailsScreen(
    navController: NavController,
    movieId: String?
) {
    //Get movie that matches id of the movie passed
    val newMovie = getMovies().filter {
        it.id == movieId
    }
    Scaffold(topBar = {
        //App bar
        TopAppBar(
            backgroundColor = Color.LightGray,
            elevation = 5.dp
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
            ) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    }
                )
                Spacer(modifier = Modifier.width(48.dp))

                Text(text = "Movies")
            }
        }
    }) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                //Details
                MovieRow(movie = newMovie.first())
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Movies Images")
                //Horizontal scrolling image
                horizontalScrollableImageView(newMovie)
            }
        }
    }
}
//Horizontal scrolling image
@Composable
private fun horizontalScrollableImageView(newMovie: List<Movie>) {
    LazyRow {
        items(newMovie[0].images) {
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {
                Image(
                    painter = rememberImagePainter(data = it),
                    contentDescription = "Movie Poster"
                )
            }
        }
    }
}

