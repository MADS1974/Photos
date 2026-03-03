package br.edu.ifsp.scl.sdm.photos.ui

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.sdm.photos.adapter.PhotoAdapter
import br.edu.ifsp.scl.sdm.photos.databinding.ActivityMainBinding
import br.edu.ifsp.scl.sdm.photos.model.ApiSingleton
import br.edu.ifsp.scl.sdm.photos.model.Photo
import com.android.volley.Request
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.JsonArrayRequest
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val photoList: MutableList<Photo> = mutableListOf()

    private val photoAdapter: PhotoAdapter by lazy {
        PhotoAdapter(this, photoList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        setSupportActionBar(amb.mainTb.apply {
            title = "Photos App"
        })

        amb.photosSp.apply {
            adapter = photoAdapter
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedPhoto = photoList[position]
                    retrieveImages(selectedPhoto)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) { }
            }
        }

        retrievePhotos()
    }

    private fun retrievePhotos() {
        val url = "https://jsonplaceholder.typicode.com/photos"

        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->

                val photos = Gson().fromJson(response.toString(), Array<Photo>::class.java)
                photoList.clear()
                photoList.addAll(photos.take(100))
                photoAdapter.notifyDataSetChanged()
            },
            {
                Toast.makeText(this, "Erro ao buscar fotos", Toast.LENGTH_SHORT).show()
            }
        )

        ApiSingleton.getInstance(this).addToRequestQueue(request)
    }

    private fun retrieveImages(photo: Photo) {
        amb.photoIv.setImageDrawable(null)
        amb.thumbIv.setImageDrawable(null)

        val realPhotoUrl = "https://picsum.photos/id/${photo.id}/600/600"
        val realThumbUrl = "https://picsum.photos/id/${photo.id}/150/150"

        val mainImageRequest = ImageRequest(
            realPhotoUrl,
            { response -> amb.photoIv.setImageBitmap(response) },
            0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888,
            { /* tratar erro */ }
        )

        val thumbImageRequest = ImageRequest(
            realThumbUrl,
            { response -> amb.thumbIv.setImageBitmap(response) },
            0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888,
            { /* tratar erro */ }
        )

        ApiSingleton.getInstance(this).addToRequestQueue(mainImageRequest)
        ApiSingleton.getInstance(this).addToRequestQueue(thumbImageRequest)
    }
}