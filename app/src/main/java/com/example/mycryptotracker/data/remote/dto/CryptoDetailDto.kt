package com.example.mycryptotracker.data.remote.dto

import com.example.mycryptotracker.domain.model.CryptoDetail

data class CryptoDetailDto(
    val additional_notices: List<Any>,
    val asset_platform_id: Any,
    val block_time_in_minutes: Int,
    val categories: List<String>,
    val country_origin: String,
    val description: Description,
    val genesis_date: String,
    val hashing_algorithm: String,
    val id: String,
    val image: Image,
    val last_updated: String,
    val links: Links,
    val market_cap_rank: Int,
    val market_data: MarketData,
    val name: String,
    val preview_listing: Boolean,
    val public_notice: Any,
    val sentiment_votes_down_percentage: Double,
    val sentiment_votes_up_percentage: Double,
    val status_updates: List<Any>,
    val symbol: String,
    val watchlist_portfolio_users: Int,
    val web_slug: String
)

fun CryptoDetailDto.toCryptoDetail(): CryptoDetail {
    return CryptoDetail(
        id,
        image,
        description,
        last_updated,
        market_data.current_price.usd,
        market_data.price_change_24h
    )
}