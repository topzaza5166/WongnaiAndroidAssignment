package com.example.wongnaiandroidassignment.data.model

import com.google.gson.annotations.SerializedName

data class DataResponse (
	@SerializedName("status") val status : String,
	@SerializedName("data") val data : Data
){
	data class Data (
		@SerializedName("stats") val stats : Stats,
		@SerializedName("base") val base : Base,
		@SerializedName("coins") val coins : List<Coin>
	){
		data class Stats (
			@SerializedName("total") val total : Int,
			@SerializedName("offset") val offset : Int,
			@SerializedName("limit") val limit : Int,
			@SerializedName("order") val order : String,
			@SerializedName("base") val base : String,
			@SerializedName("totalMarkets") val totalMarkets : Int,
			@SerializedName("totalExchanges") val totalExchanges : Int,
			@SerializedName("totalMarketCap") val totalMarketCap : Double,
			@SerializedName("total24hVolume") val total24hVolume : Double
		)

		data class Base (
			@SerializedName("symbol") val symbol : String,
			@SerializedName("sign") val sign : String
		)

	}
}