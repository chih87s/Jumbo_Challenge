package com.db.jumbotest.ui.components.details

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.Coil
import coil.compose.AsyncImage
import com.db.domain.entities.BasicInfo
import com.db.domain.entities.BookingInfo
import com.db.domain.entities.HostInfo
import com.db.domain.entities.LocationInfo
import com.db.domain.entities.PriceInfo
import com.db.domain.entities.Review

@Composable
fun TopBar(){

}

@Composable
fun BottomActionBar(
    priceInfo: PriceInfo
){

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PropertyImageGallery(
    modifier: Modifier,
    imageUrls: List<String>,
    onImageClick: (String) -> Unit
){
    //TODO display image gallery
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { imageUrls.size })

    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { page ->
        //
        AsyncImage(
            model = imageUrls[page].ifEmpty {  }, contentDescription = "property image",
        )
    }

}

@Composable
fun PropertyBasicInfoComponent(
    basicInfo: BasicInfo
){
    //TODO display property basic info
}

@Composable
fun LocationComponent(
    locationInfo: LocationInfo
){
    //TODO display property location info
}


@Composable
fun ReviewsComponent(
    reviews: List<Review>
){
    //TODO display property reviews
}

@Composable
fun HostInfoComponent(
    hostInfo: HostInfo
){
    //TODO display host info
}

@Composable
fun BookingInfoComponent(
    bookingInfo: BookingInfo
){
    //TODO display booking info
}


@Composable
fun PriceInfoBar(
    priceInfo: PriceInfo
){
    //TODO display price info
}