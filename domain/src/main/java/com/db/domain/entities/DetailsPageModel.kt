package com.db.domain.entities

import com.db.common.model.DomainModel

data class DetailsPageModel(
    val basicInfo: BasicInfo,
    val availability: AvailabilityInfo,
    val reviews: List<Review>,
    val hostInfo: HostInfo,
    val bookingInfo: BookingInfo,
    val priceInfo: PriceInfo,
    val location: LocationInfo
) : DomainModel


data class BasicInfo(
    val id: String,
    val title: String,
    val description: String,
    val imageUrls: List<String>,
    val pricePerNight: Double,
    val location: String,
    val rating: Double,
    val amenities: List<String>
) : DomainModel


data class AvailabilityInfo(
    val availableDates: List<String>,
    val bookedDates: List<String>
) : DomainModel


data class LocationInfo(
    val latitude: Double,
    val longitude: Double,
    val address: String
) : DomainModel

data class Review(
    val author: String,
    val rating: Double,
    val comment: String,
    val date: String,
    val reviewerProfileUrl: String
) : DomainModel


data class HostInfo(
    val hostName: String,
    val hostProfilePic: String,
    val responseRate: Double,
    val responseTime: String
) : DomainModel


data class BookingInfo(
    val checkIn: String,
    val checkOut: String,
    val numGuests: Int,
    val totalPrice: Double
) : DomainModel

data class PriceInfo(
    val basePrice: Double,
    val cleaningFee: Double,
    val serviceFee: Double,
    val totalPrice: Double
) : DomainModel



