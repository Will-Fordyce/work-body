package com.example.program5

import androidx.fragment.app.Fragment

class BookListActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return BookListFragment()
    }

}