package com.example.companyaplication.base

class ItemWithHeaders<T>(val type: ItemType) {

    enum class ItemType{HEADER,ITEM}
}