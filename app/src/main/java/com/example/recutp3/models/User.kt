package com.example.recutp3.models

data class User(
    val name: Name,
    val email: String,
    val picture: Picture,
    val location: Location,
    val gender: String,
    var index: Int
) : java.io.Serializable {

    data class Name(val title: String, val first: String, val last: String)
    data class Picture(val large: String, val medium: String, val thumbnail: String)
    data class Location(val country: String, val state: String, val city: String)
}