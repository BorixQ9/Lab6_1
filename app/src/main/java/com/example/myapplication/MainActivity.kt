package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable("profile") { ProfileScreen() }
                    composable("build") { BuildScreen() }
                    composable("menu") { MenuScreen() }
                    composable("favorite") { FavoriteScreen() }
                    composable("delete") { DeleteScreen() }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    var clickCount by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            CustomTopBar(
                onProfileClick = { navController.navigate("profile") }
            )
        },
        bottomBar = {
            CustomBottomBar(navController)
        },
        floatingActionButton = {
            CustomFAB(onClick = { clickCount++ })
        },
        content = { padding ->
            CustomContent(padding, clickCount)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(onProfileClick: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Menu")
            }
        },
        title = { Text(text = "Sample Title") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search")
            }
            IconButton(onClick = onProfileClick) {
                Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = "Profile")
            }
        }
    )
}

@Composable
fun CustomBottomBar(navController: NavHostController) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = { navController.navigate("build") }) {
                Icon(Icons.Filled.Build, contentDescription = "Build description")
            }
            IconButton(onClick = { navController.navigate("menu") }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu description")
            }
            IconButton(onClick = { navController.navigate("favorite") }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite description")
            }
            IconButton(onClick = { navController.navigate("delete") }) {
                Icon(Icons.Filled.Delete, contentDescription = "Delete description")
            }
        }
    }
}

@Composable
fun CustomFAB(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Text(fontSize = 24.sp, text = "+")
    }
}

@Composable
fun CustomContent(padding: PaddingValues, clickCount: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Número de clicks: $clickCount")
    }
}

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla Perfil")
    }
}

@Composable
fun BuildScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla Build")
    }
}

@Composable
fun MenuScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla Menu")
    }
}

@Composable
fun FavoriteScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla Favorite")
    }
}

@Composable
fun DeleteScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla Delete")
    }
}
