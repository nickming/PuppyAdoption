package com.example.androiddevchallenge.data

import android.os.Parcelable
import com.example.androiddevchallenge.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Puppy(
    val id: String,
    val name: String,
    val age: Int,
    val type: String,
    val description: String,
    val photos: List<Int> = emptyList()
) : Parcelable

val puppyData = mutableListOf(
    Puppy(
        "1",
        "Mike",
        2,
        "Siberian Husky",
        "One day, this Siberian Husky could pull a sled across Alaska",
        listOf(R.drawable.ic_siberian_husky_cute_puppies)
    ),
    Puppy(
        "2", "Jake", 3, "Golden Retriever", "A devoted companion and incredible working dog",
        listOf(R.drawable.ic_golden_retriever_cute_puppies)
    ),
    Puppy(
        "3",
        "Nick",
        1,
        "Poodles",
        "like this pup, can be a variety of solid colors, including blues, grays, silvers, browns, cafe-au-laits, apricots and creams",
        listOf(R.drawable.ic_poodle_cute_puppies)
    ),
    Puppy(
        "4",
        "John",
        1,
        "French Bulldog",
        "These unbelievably adorable bat-like ears are characteristic of the French Bulldog",
        listOf(R.drawable.ic_french_bulldog_cute_puppies)
    ),
    Puppy(
        "5",
        "Alpha",
        4,
        "Shiba Inu",
        "Check out the head tilt on this alert and agile Shiba Inu pup",
        listOf(R.drawable.ic_shiba_inu_cute_puppies)
    )
)