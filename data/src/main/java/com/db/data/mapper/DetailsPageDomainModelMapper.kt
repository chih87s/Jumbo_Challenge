package com.db.data.mapper


import com.db.common.extensions.DataToDomainModelMapper
import com.db.data.data.entities.ResponseDetailsPageModel
import com.db.domain.entities.AvailabilityInfo
import com.db.domain.entities.BasicInfo
import com.db.domain.entities.BookingInfo
import com.db.domain.entities.DetailsPageModel
import com.db.domain.entities.HostInfo
import com.db.domain.entities.LocationInfo
import com.db.domain.entities.PriceInfo
import com.db.domain.entities.Review
import javax.inject.Inject

class DetailsPageDomainModelMapper @Inject constructor() : DataToDomainModelMapper<ResponseDetailsPageModel, DetailsPageModel> {
    override fun mapToDomainModel(responseModel: ResponseDetailsPageModel): DetailsPageModel {
        return with(responseModel) {
            generateDetailsPageModel()
        }
    }
}

//TODO assuming mock data
fun generateDetailsPageModel(): DetailsPageModel {
    val basicInfo = BasicInfo(
        id = "12345",
        title = "Cozy Beachfront Villa",
        description = "A beautiful villa by the beach with amazing views.",
        imageUrls = listOf("https://example.com/image1.jpg", "https://example.com/image2.jpg"),
        pricePerNight = 200.0,
        location = "California, USA",
        rating = 4.8,
        amenities = listOf("Pool", "Wi-Fi", "Air Conditioning")
    )

    val availability = AvailabilityInfo(
        availableDates = listOf("2025-05-01", "2025-05-02", "2025-05-03"),
        bookedDates = listOf("2025-05-04", "2025-05-05")
    )

    val reviews = listOf(
        Review(
            author = "John Doe",
            rating = 5.0,
            comment = "Amazing place! Highly recommend.",
            date = "2025-04-01",
            reviewerProfileUrl = "https://example.com/profile1.jpg"
        ),
        Review(
            author = "Jane Smith",
            rating = 4.5,
            comment = "Great location and views, but a bit expensive.",
            date = "2025-03-20",
            reviewerProfileUrl = "https://example.com/profile2.jpg"
        )
    )

    val hostInfo = HostInfo(
        hostName = "Alice Johnson",
        hostProfilePic = "https://example.com/host.jpg",
        responseRate = 95.0,
        responseTime = "1 hour"
    )

    val bookingInfo = BookingInfo(
        checkIn = "2025-05-01",
        checkOut = "2025-05-07",
        numGuests = 4,
        totalPrice = 1400.0
    )

    val priceInfo = PriceInfo(
        basePrice = 1200.0,
        cleaningFee = 100.0,
        serviceFee = 100.0,
        totalPrice = 1400.0
    )

    val locationInfo = LocationInfo(
        latitude = 34.0522,
        longitude = -118.2437,
        address = "123 Beachside Blvd, Malibu, CA"
    )

    return DetailsPageModel(
        basicInfo = basicInfo,
        availability = availability,
        reviews = reviews,
        hostInfo = hostInfo,
        bookingInfo = bookingInfo,
        priceInfo = priceInfo,
        location = locationInfo
    )
}
