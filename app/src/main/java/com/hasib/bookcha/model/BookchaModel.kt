package com.hasib.bookcha.model

import kotlinx.serialization.Serializable

// Api Objects
@Serializable
data class BookchaModel(
    val kind: String = "",
    val totalItems: Int = 0,
    val items: List<Items> = emptyList()
)


//Api item objects
@Serializable
data class Items(
    val volumeInfo : VolumeInfo = VolumeInfo(),
    val saleInfo: SalesInfo = SalesInfo(),
    val accessInfo : AccessInfo = AccessInfo()
)

//book info object
@Serializable
data class VolumeInfo(
    val title: String = "",
    val publishedDate: String = "",
    val authors: List<String> = listOf("N/A"),
    val description: String = "",
    val pageCount: Int = 0,
    val averageRating:Float = 0F,
    val imageLinks: ImageLinks = ImageLinks(),
    val language: String = "",
    val previewLink: String = "",
    val infoLink: String = "",
    val canonicalVolumeLink: String = ""
)
@Serializable
data class ImageLinks(
    val smallThumbnail: String = "",
    val thumbnail: String = ""
)

//sales info object
@Serializable
data class SalesInfo(
    val buyLink: String = "",
    val listPrice: PriceList = PriceList()
)
@Serializable
data class PriceList(
    val amount: Float = 0.0F,
    val currencyCode: String = ""
)

//accessibility info
@Serializable
data class AccessInfo(
    val pdf: PdfLink = PdfLink(),
    val webReaderLink: String = ""
)
@Serializable
data class PdfLink(
    val isAvailable: Boolean = false,
    val acsTokenLink: String = ""
)