package com.example.newapp29feb.databse

 data class DatabaseEntity(
     val count:Int,
     val entries:List<Entries>
 )
data class Entries( val API:String,
val Description:String,
 val Auth:String,
val HTTPS:String,
val Cors:String,
val Link:String,
val Category:String
)