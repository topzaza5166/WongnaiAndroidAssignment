package com.example.wongnaiandroidassignment.data.model

import com.google.gson.annotations.SerializedName

data class Coin (
    @SerializedName("id") val id : Long,
    @SerializedName("uuid") val uuid : String,
    @SerializedName("slug") val slug : String,
    @SerializedName("symbol") val symbol : String,
    @SerializedName("name") val name : String,
    @SerializedName("description") val description : String,
    @SerializedName("color") val color : String,
    @SerializedName("iconType") val iconType : String,
    @SerializedName("iconUrl") val iconUrl : String,
    @SerializedName("websiteUrl") val websiteUrl : String,
    @SerializedName("socials") val socials : List<Socials>,
    @SerializedName("links") val links : List<Links>,
    @SerializedName("confirmedSupply") val confirmedSupply : Boolean,
    @SerializedName("numberOfMarkets") val numberOfMarkets : Long,
    @SerializedName("numberOfExchanges") val numberOfExchanges : Long,
    @SerializedName("type") val type : String,
    @SerializedName("volume") val volume : Long,
    @SerializedName("marketCap") val marketCap : Long,
    @SerializedName("price") val price : Double,
    @SerializedName("circulatingSupply") val circulatingSupply : Double,
    @SerializedName("totalSupply") val totalSupply : Double,
    @SerializedName("approvedSupply") val approvedSupply : Boolean,
    @SerializedName("firstSeen") val firstSeen : Long,
    @SerializedName("change") val change : Double,
    @SerializedName("rank") val rank : Long,
    @SerializedName("history") val history : List<Double>,
    @SerializedName("allTimeHigh") val allTimeHigh : AllTimeHigh,
    @SerializedName("penalty") val penalty : Boolean
){
    data class Links (
        @SerializedName("name") val name : String,
        @SerializedName("type") val type : String,
        @SerializedName("url") val url : String
    )

    data class Socials (
        @SerializedName("name") val name : String,
        @SerializedName("url") val url : String,
        @SerializedName("type") val type : String
    )

    data class AllTimeHigh (
        @SerializedName("price") val price : Double,
        @SerializedName("timestamp") val timestamp : Long
    )
}