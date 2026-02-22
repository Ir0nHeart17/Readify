package com.example.readify.presentation.HomeScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.readify.R
import com.example.readify.presentation.TabScreen.TabScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navHostController: NavHostController) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val urlHandler = LocalUriHandler.current
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(250.dp)
                        .padding(16.dp)
                ) {

                    Spacer(modifier = Modifier.height(16.dp))
                    Divider()
                    NavigationDrawerItem(
                        label = { Text(text = "Home") },
                        selected = true,
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Home,
                                contentDescription = "Home",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                        }
                    )
                    Divider()
                    NavigationDrawerItem(
                        label = { Text(text = "Version 1.0") },
                        selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = "Version",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            Toast.makeText(context," Version 1.0" , Toast.LENGTH_SHORT).show()
                        }
                    )
                    Divider()
                    NavigationDrawerItem(
                        label = { Text(text = "Contact ME") },
                        selected = false,
                        icon = {
                            Icon(
                                painterResource(id = R.drawable.github),
                                contentDescription = "git hub",
                                modifier = Modifier.size(24.dp),
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        },
                        onClick = {
                            urlHandler.openUri("https://github.com/Ir0nHeart17")

                        }
                    )

                    Divider()
                    NavigationDrawerItem(
                        label = { Text(text = "Bug Report") },
                        selected = false,
                        icon = {
                            Icon(
                                painterResource(id = R.drawable.no_bugs),
                                contentDescription = "Bug Report",
                                modifier = Modifier.size(24.dp),
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        },
                        onClick = {
                            urlHandler.openUri("https://github.com/Ir0nHeart17/Readify")

                        }
                    )


                }

            }

        }
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Book Library",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )


                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {coroutineScope.launch { drawerState.open() }}) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Open Drawer",
                                tint = MaterialTheme.colorScheme.onSurface)
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            }

        ) {innerpadding ->
            Column(
                modifier = Modifier.padding(innerpadding).fillMaxSize()
            ) {
                TabScreen(navHostController = navHostController)
            }
        }
    }

}