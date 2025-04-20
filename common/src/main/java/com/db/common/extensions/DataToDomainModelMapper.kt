package com.db.common.extensions

import com.db.common.model.DomainModel
import com.db.common.model.ResponseModel

interface DataToDomainModelMapper<R: ResponseModel, U: DomainModel> {
    fun mapToDomainModel(responseModel: R): U
}