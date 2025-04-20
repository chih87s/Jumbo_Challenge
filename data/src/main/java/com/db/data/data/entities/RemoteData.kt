package com.db.data.data.entities

import com.db.common.model.ResponseModel

data class ResponseDetailsPageModel(
    val basicInfo: ResponseBasicInfo,
    val availability: ResponseAvailabilityInfo,
    val reviews: List<ResponseReview>,
    val hostInfo: ResponseHostInfo,
    val bookingInfo: ResponseBookingInfo,
    val priceInfo: ResponsePriceInfo,
    val location: ResponseLocationInfo
) : ResponseModel


data class ResponseBasicInfo(
    val id: String,
    val title: String,
    val description: String,
    val imageUrls: List<String>,
    val pricePerNight: Double,
    val hostName: String,
    val location: String,
    val rating: Double,
    val amenities: List<String>
) : ResponseModel


data class ResponseAvailabilityInfo(
    val availableDates: List<String>,
    val bookedDates: List<String>
) : ResponseModel

data class ResponseReview(
    val author: String,
    val rating: Double,
    val comment: String,
    val date: String,
    val reviewerProfilePic: String
) : ResponseModel


data class ResponseHostInfo(
    val hostName: String,
    val hostProfilePic: String,
    val responseRate: Double,
    val responseTime: String
) : ResponseModel


data class ResponseBookingInfo(
    val checkIn: String,
    val checkOut: String,
    val numGuests: Int,
    val totalPrice: Double
) : ResponseModel

data class ResponsePriceInfo(
    val basePrice: Double,
    val cleaningFee: Double,
    val serviceFee: Double,
    val totalPrice: Double
) : ResponseModel

data class ResponseLocationInfo(
    val latitude: Double,
    val longitude: Double,
    val address: String
) : ResponseModel