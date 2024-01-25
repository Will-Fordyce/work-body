package com.example.program5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import java.util.*

class BookActivity : SingleFragmentActivity() {

    companion object {
        val EXTRA_BOOK_ID = "com.example.apoe.fragment1.crime_id"

        fun newIntent (packageContext: Context?, bookID:UUID?):Intent? {

            val intent = Intent (packageContext!!,BookActivity::class.java)
            intent.putExtra (EXTRA_BOOK_ID,bookID)
            return intent
        }
    }
    override fun createFragment(): Fragment {
        val bookID: UUID? = intent.getSerializableExtra(EXTRA_BOOK_ID) as UUID?
        return BookFragment.newInstance (bookID)
    }

}