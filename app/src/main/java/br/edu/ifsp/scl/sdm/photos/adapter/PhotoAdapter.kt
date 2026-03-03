package br.edu.ifsp.scl.sdm.photos.adapter

import android.content.Context
import android.widget.ArrayAdapter
import br.edu.ifsp.scl.sdm.photos.model.Photo

class PhotoAdapter(context: Context, photos: MutableList<Photo>) :
    ArrayAdapter<Photo>(context, android.R.layout.simple_spinner_item, photos) {
    init {

        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }
}
