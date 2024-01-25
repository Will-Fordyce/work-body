package com.example.program5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.program5.BookActivity.Companion.EXTRA_BOOK_ID
import java.util.*

class BookPagerActivity : AppCompatActivity() {

    private var mViewPager: ViewPager2? = null
    private var mBooks:List<Book>? = null

    override fun onCreate (savedInstanceState: Bundle?) {
        Log.d ("BOOKPAGERACTIVITY","onCreate")
        super.onCreate (savedInstanceState)
        setContentView (R.layout.activity_book_pager)
        val bookId = intent.getSerializableExtra(EXTRA_BOOK_ID) as UUID
        mViewPager = findViewById (R.id.book_view_pager)
        mBooks = Library.books
        val fragmentManager = supportFragmentManager
        mViewPager!!.adapter = object : FragmentStateAdapter(fragmentManager,lifecycle) {
            //When the pager is on page "position" what should it show?
            override fun createFragment (position:Int) : Fragment {
                val book = mBooks!![position]
                return BookFragment.newInstance(book.mId)
            }

            override fun getItemCount():Int {
                return mBooks!!.size
            }


        }
        //This sets where we are in the Pager View
        for (i in mBooks!!.indices) {
            if (mBooks!![i].mId==bookId) {
                mViewPager!!.currentItem = i
                break
            }
        }

    }

    override fun onStart() {
        Log.d ("BOOKPAGERACTIVITY","onStart")
        super.onStart()
    }
    override fun onRestart() {
        Log.d ("BOOKPAGERACTIVITY","onRestart")
        super.onRestart()
    }
    override fun onPause() {
        Log.d ("BOOKPAGERACTIVITY","onPause")
        super.onPause()
    }
    override fun onResume() {
        Log.d ("BOOKPAGERACTIVITY","onResume")
        super.onResume()
    }
    override fun onDestroy() {
        Log.d ("BOOKPAGERACTIVITY","onDestroy")
        super.onDestroy()
    }
    override fun onStop() {
        Log.d ("BOOKPAGERACTIVITY","onStop")
        super.onStop()
    }

    companion object {
        fun newIntent (packageContext: Context, bookId:UUID?): Intent {
            val intent = Intent(packageContext,BookPagerActivity::class.java)
            intent.putExtra(EXTRA_BOOK_ID,bookId);
            return intent
        }
    }
}