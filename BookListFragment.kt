package com.example.program5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class BookListFragment : Fragment() {

    private var mBookRecyclerView: RecyclerView? = null
    private var mAdapter: BookAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("BOOKLISTFRAGMENT", "onCreateView")
        val view = inflater.inflate(R.layout.fragment_book_list, container, false)
        mBookRecyclerView = view.findViewById (R.id.book_recycler_view)
        mBookRecyclerView!!.layoutManager = LinearLayoutManager(activity)
        updateUI()
        return view
    }


    private fun updateUI() {
        val library = Library  //makes a new CrimeLab object
        val books = Library.books
        if (mAdapter == null) {
            mAdapter = BookAdapter(books)
            mBookRecyclerView!!.adapter = mAdapter
        } else {
            mAdapter!!.notifyDataSetChanged()
        }
    }
    override fun onResume() {
        Log.d("BOOKLISTFRAGMENT", "onResume")
        super.onResume()
        updateUI() //update any changes made
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("BOOKLISTFRAGMENT", "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Log.d("BOOKLISTFRAGMENT", "onStart")
        super.onStart()
    }

    override fun onStop() {
        Log.d("BOOKLISTFRAGMENT", "onStop")
        super.onStop()
    }

    override fun onDetach() {
        Log.d("BOOKLISTFRAGMENT", "onDetach")
        super.onDetach()
    }

    override fun onDestroyView() {
        Log.d("BOOKLISTFRAGMENT", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("BOOKLISTFRAGMENT", "onDestroy")
        super.onDestroy()
    }

    override fun onPause() {
        Log.d("BOOKLISTFRAGMENT", "onPause")
        super.onPause()
    }



    //An inner class is a class that can only be used within this file
    private inner class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val mTitleTextView: TextView?
        private val mDateTextView: TextView?
        private val mRatingField: TextView?
        private var mBook: Book? = null

        init {
            itemView.setOnClickListener(this)
            mTitleTextView = itemView.findViewById(R.id.list_item_book_title_text_view) as TextView
            mDateTextView = itemView.findViewById(R.id.list_item_book_date_text_view) as TextView
            mRatingField = itemView.findViewById(R.id.list_item_book_rated_text_view) as TextView
        }

        fun bindBook(book: Book?) {
            mBook = book
            mTitleTextView!!.text = mBook!!.mTitle
            mRatingField!!.text = mBook!!.mRating
        }

        override fun onClick(v: View) {

            Toast.makeText(activity, mBook!!.mTitle!! + " Clicked!", Toast.LENGTH_SHORT).show()
            val intent = BookPagerActivity.newIntent(activity as Context, mBook!!.mId)
            startActivity(intent)

        }
    }

    private inner class BookAdapter(private val mBooks: List<Book>?) : RecyclerView.Adapter<BookHolder>() {
        //This runs when the RecyclerView is initialized
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
            Log.d("RECYCLER", "onCreateViewHolder")
            val layoutInflater = LayoutInflater.from(activity)
            val view = layoutInflater.inflate(R.layout.list_item_book, parent, false)
            return BookHolder(view)
        }
        //This is code that runs when something goes off the screen and is deallocated
        override fun onDetachedFromRecyclerView(rv: RecyclerView) {
            Log.d("RECYCLER", "DEAD!!!")
            super.onDetachedFromRecyclerView(rv)
        }
        //This is what runs when something in the recyclerview scrolls into view
        override fun onBindViewHolder(holder: BookHolder, position: Int) {
            val book = mBooks!![position]
            holder.bindBook(book)
        }

        override fun getItemCount(): Int {
            return mBooks!!.size
        }
    }
}
