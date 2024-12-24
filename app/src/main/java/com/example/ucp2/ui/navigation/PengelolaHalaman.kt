package com.example.ucp2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ucp2.ui.view.Dashboard
import com.example.ucp2.ui.view.dosen.DestinasiInsertDsn
import com.example.ucp2.ui.view.dosen.HomeDsnView
import com.example.ucp2.ui.view.dosen.InserDsnView
import com.example.ucp2.ui.view.matakuliah.DestinasiInsertMK
import com.example.ucp2.ui.view.matakuliah.DetailMKView
import com.example.ucp2.ui.view.matakuliah.HomeMKView
import com.example.ucp2.ui.view.matakuliah.InsertMKView
import com.example.ucp2.ui.view.matakuliah.UpdateMKView

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        // Rute untuk dashboard
        composable(route = DestinasiHome.route) {
            Dashboard(
                onNavigateToDsn = {
                    navController.navigate(DestinasiHomeDosen.route) // ke HomeDsnView
                },
                onNavigateToMk = {
                    navController.navigate(DestinasiHomeMatakuliah.route) // ke HomeMkView
                }
            )
        }

        composable(route = DestinasiHomeMatakuliah.route) {
            HomeMKView(
                onAddMK = {
                    navController.navigate(DestinasiInsertMK.route)
                },
                onDetailClick = { kode ->
                    navController.navigate("${DestinasiDeailMataKuliah.route}/$kode")
                    println("PengelolaHalaman: kode = $kode")
                },
                onBack = {navController.popBackStack()},
                modifier = modifier,
            )
        }

        composable(route = DestinasiInsertMK.route){
            InsertMKView(
                onBack = {navController.popBackStack()},
                onNavigate = {navController.popBackStack()},
                modifier = modifier,
            )
        }

        composable(
          DestinasiDeailMataKuliah.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiDeailMataKuliah.kode){
                    type = NavType.StringType
                }
            )
        ){
            val kode = it.arguments?.getString(DestinasiDeailMataKuliah.kode)
            kode?.let { kode ->
                DetailMKView(
                    onBack = {navController.popBackStack()},
                    onEditClick = {kode ->
                        navController.navigate("${DestanasiUpdateMataKuliah.route}/$kode")
                    },
                    onDeleteClick = {navController.popBackStack()},
                    modifier = modifier
                )
            }
        }

        composable(
            DestanasiUpdateMataKuliah.routeWithArg,
            arguments = listOf(
                navArgument(DestanasiUpdateMataKuliah.kode){
                    type = NavType.StringType
                }
            )
        ){
            val kode = it.arguments?.getString(DestanasiUpdateMataKuliah.kode)
            kode?.let {
                UpdateMKView(
                    onBack = {navController.popBackStack()},
                    onNavigate = {navController.popBackStack()},
                    modifier = modifier
                )
            }
        }

        composable(route = DestinasiHomeDosen.route){
            HomeDsnView(
                onAddDsn = {
                    navController.navigate(DestinasiInsertDsn.route)
                },
                onBack = {navController.popBackStack()},
                modifier = modifier
            )
        }

        composable(route = DestinasiInsertDsn.route){
            InserDsnView(
                onBack = {navController.popBackStack()},
                onNavigate = {navController.popBackStack()},
                modifier = modifier
            )
        }
    }
}