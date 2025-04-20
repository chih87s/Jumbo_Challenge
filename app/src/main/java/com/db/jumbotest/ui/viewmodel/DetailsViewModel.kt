package com.db.jumbotest.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.db.common.Resource
import com.db.domain.entities.DetailsPageModel
import com.db.domain.usecase.FetchDetailsDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val fetchDetailsDataUseCase: FetchDetailsDataUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    private val itemId: String = savedStateHandle["itemId"] ?: ""


    private val _detailsPageState = MutableStateFlow<UIState>(UIState.Loading)
    val detailsPageState: StateFlow<UIState> = _detailsPageState


    fun getDetailsPage(){
        viewModelScope.launch {
            _detailsPageState.value = UIState.Loading
            fetchDetailsDataUseCase.invoke(itemId).collect{ result ->
                when(result){
                    is Resource.Success -> {
                        _detailsPageState.value = UIState.Success(result.data)

                    }
                    is Resource.Failure -> {
                        _detailsPageState.value = UIState.Error(result.error.message?:"Unknown error")
                    }
                }
            }
        }
    }


}

sealed class UIState {
    data object Loading : UIState()
    data class Success(val data: DetailsPageModel) : UIState()
    data class Error(val message: String) : UIState()
}