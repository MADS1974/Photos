package br.edu.ifsp.scl.sdm.photos.model

data class Photo(
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) {

    override fun toString(): String = title
}
