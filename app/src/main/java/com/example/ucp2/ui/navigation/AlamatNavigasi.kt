package com.example.ucp2.ui.navigation

interface AlamatNavigasi{
    val route: String
}

object DestinasiHomeDosen : AlamatNavigasi{
    override val route = "home dosen"
}

object DestinasiHomeMatakuliah : AlamatNavigasi{
    override val route = "home matakuliah"
}

object DestinasiDeailMataKuliah : AlamatNavigasi{
    override val route = "detail"
    const val kode = "kode"
    val routeWithArg = "$route/{$kode}"
}

object DestanasiUpdateMataKuliah : AlamatNavigasi{
    override val route = "update"
    const val kode = "kode"
    val routeWithArg = "$route/{$kode}"
}