package com.example.program5

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.*


class BookFragment : Fragment() {

    var mBook:Book? = null
    var mTitleV: TextView? = null
    var mRatingField: EditText? = null
    var mRatingV: TextView? = null
    var mRateButton:Button? =  null
    var mDeleteB:Button? = null

    companion object {
        val ARG_BOOK_ID = "book_id"

        fun newInstance (bookID: UUID?):BookFragment {
            val args = Bundle()
            args.putSerializable(ARG_BOOK_ID,bookID)
            val fragment = BookFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("BOOKFRAGMENT", "onCreate")
        val bookID:UUID? = requireArguments().getSerializable(ARG_BOOK_ID) as UUID?
        mBook= Library.getBook(bookID)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        Log.d("BOOKFRAGMENT", "onCreateView")
        val v:View? = inflater.inflate(R.layout.fragment_book, container, false)
        mTitleV = v!!.findViewById(R.id.textView)
        mTitleV!!.text = (mBook!!.mTitle)
        mRatingField = v!!.findViewById (R.id.book_title)
        mRatingField!!.setText (mBook!!.mRating)
        mRatingField!!.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            //This runs every single time the text changes, even slightly in the edittext box
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mBook!!.mRating = s!!.toString() + " Stars"
                mRateButton!!.text = "Your rating is: " + mBook!!.mRating
            }

            override fun afterTextChanged (s: Editable) {

            }
        })

        mRatingV = v.findViewById(R.id.book_solved);
        mRateButton = v.findViewById(R.id.book_rater)
        mRateButton!!.isEnabled = false

        return v
    }


    override fun onStart() {
        Log.d("BOOKFRAGMENT", "onStart")
        super.onStart()
    }

    override fun onStop() {
        Log.d("BOOKFRAGMENT", "onStop")
        super.onStop()
    }

    override fun onDetach() {
        Log.d("BOOKFRAGMENT", "onDetach")
        super.onDetach()
    }

    override fun onDestroyView() {
        Log.d("BOOKFRAGMENT", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("BOOKFRAGMENT", "onDestroy")
        super.onDestroy()
    }

    override fun onPause() {
        Log.d("BOOKFRAGMENT", "onPause")
        super.onPause()
    }

    override fun onResume() {
        Log.d("BOOKFRAGMENT", "onResume")
        super.onResume()
    }



}