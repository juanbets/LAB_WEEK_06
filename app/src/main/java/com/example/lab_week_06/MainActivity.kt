package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        // Glide digunakan untuk load image
        // Kita pass juga OnClickListener ke adapter
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pasang adapter ke RecyclerView
        recyclerView.adapter = catAdapter

        // Atur layout manager RecyclerView (linear vertical)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        // === Pasang swipe-to-delete dengan ItemTouchHelper ===
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Tambahkan data kucing ke adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.BalineseJavanese,
                    name = "Fred",
                    biography = "Silent and deadly",
                    imageUrl = "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.ExoticShorthair,
                    name = "Wilma",
                    biography = "Cuddly assassin",
                    imageUrl = "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    gender = Gender.Unknown,
                    breed = CatBreed.AmericanCurl,
                    name = "Curious George",
                    biography = "Award winning investigator",
                    imageUrl = "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.MaineCoon,
                    name = "Simba",
                    biography = "The lion-hearted guardian",
                    imageUrl = "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.Bengal,
                    name = "Nala",
                    biography = "Fast and fierce",
                    imageUrl = "https://cdn2.thecatapi.com/images/O3btzLlsO.png"
                ),
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.Persian,
                    name = "Snowball",
                    biography = "Fluffy cloud of happiness",
                    imageUrl = "https://cdn2.thecatapi.com/images/8r1.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.Sphynx,
                    name = "Cleopatra",
                    biography = "Regal and majestic",
                    imageUrl = "https://cdn2.thecatapi.com/images/DBmIBhhyv.jpg"
                ),
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.ScottishFold,
                    name = "Oliver",
                    biography = "Loves to curl and nap",
                    imageUrl = "https://cdn2.thecatapi.com/images/6qi.jpg"
                ),
                CatModel(
                    gender = Gender.Unknown,
                    breed = CatBreed.Ragdoll,
                    name = "Mittens",
                    biography = "Gentle and soft-hearted",
                    imageUrl = "https://cdn2.thecatapi.com/images/k71ULYfRr.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.Siamese,
                    name = "Luna",
                    biography = "Moonlight whisperer",
                    imageUrl = "https://cdn2.thecatapi.com/images/ai6.jpg"
                )
            )
        )
    }

        // Fungsi untuk menampilkan dialog saat item diklik
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
