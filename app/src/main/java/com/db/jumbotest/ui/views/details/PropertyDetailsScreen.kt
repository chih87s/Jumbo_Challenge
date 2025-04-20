package com.db.jumbotest.ui.views.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.db.jumbotest.ui.components.details.BookingInfoComponent
import com.db.jumbotest.ui.components.details.BottomActionBar
import com.db.jumbotest.ui.components.details.HostInfoComponent
import com.db.jumbotest.ui.components.details.LocationComponent
import com.db.jumbotest.ui.components.details.PriceInfoBar
import com.db.jumbotest.ui.components.details.PropertyBasicInfoComponent
import com.db.jumbotest.ui.components.details.PropertyImageGallery
import com.db.jumbotest.ui.components.details.ReviewsComponent
import com.db.jumbotest.ui.components.details.TopBar
import com.db.jumbotest.ui.viewmodel.DetailsViewModel
import com.db.jumbotest.ui.viewmodel.UIState


@Composable
fun PropertyDetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {

    LaunchedEffect(Unit) {
        viewModel.getDetailsPage()
    }


    val detailsData by viewModel.detailsPageState.collectAsState()


    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            if (detailsData is UIState.Success) {
                val details = (detailsData as UIState.Success).data
                BottomActionBar(
                    priceInfo = details.priceInfo
                )
            }
        }
    ) { paddingValues ->
        when (detailsData) {
            is UIState.Loading -> {}
            is UIState.Success -> {
                val details = (detailsData as UIState.Success).data
                Box(modifier = Modifier.padding(paddingValues).fillMaxSize()){
                    LazyColumn(modifier = Modifier.fillMaxSize().padding(bottom = 100.dp)) {

                        item {
                            //TODO display image gallery
                            PropertyImageGallery(imageUrls = details.basicInfo.imageUrls, modifier = Modifier.fillMaxWidth().height(160.dp)) { }
                        }

                        item {
                            //TODO display property basic info
                            PropertyBasicInfoComponent(details.basicInfo)
                        }

                        item {
                            //TODO display property location info
                            LocationComponent(details.location)
                        }

                        item {
                            //TODO display property reviews
                            ReviewsComponent(details.reviews)
                        }

                        item {
                            //TODO display host info
                            HostInfoComponent(details.hostInfo)
                        }

                        item {
                            //TODO display booking info
                            BookingInfoComponent(details.bookingInfo)
                        }
                    }

                    PriceInfoBar(details.priceInfo)
                }

            }

            is UIState.Error -> {}
        }

    }


}