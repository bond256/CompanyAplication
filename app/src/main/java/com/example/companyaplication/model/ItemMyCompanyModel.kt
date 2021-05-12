package com.example.companyaplication.model

import com.example.companyaplication.common.FilterType

data class ItemMyCompanyModel(
    val avatar: String,
    val displayName: String,
    val rank: Int,
    val total: Int,
    val filterPanelItem: FilterPanelItem?
)

data class FilterPanelItem(
    val imageActivity: Int,
    val iconTime: Int,
    val typeActivity: FilterType,
    val typeTime: FilterType
)