package com.example.program5

import java.util.*

object Library {

    private val mBooks:MutableList<Book>?


    val books:List<Book>?
        get() = mBooks

    fun getBook (id: UUID?):Book? {
        for (book in mBooks!!)
            if (book.mId==id) return book
        return null
    }

    val titles = arrayOf<String>("Don Quixote","A Tale of Two Cities", "The Fellowship of the Ring",
        "The Little Prince","The Hobbit","Harry Potter and the Philosopher's Stone",
        "The Lion, The Witch and the Wardrobe","She: A History of Adventure",
        "The Adventures of Pinocchio","The Da Vinci Code","Harry Potter and the Chamber of Secrets",
        "Harry Potter and the Prisoner of Azkaban","Harry Potter and the Goblet of Fire",
        "Harry Potter and the Order of the Phoenix","Harry Potter and the Half-Blood Prince",
        "Harry Potter and the Deathly Hallows","The Alchemist","The Catcher in the Rye",
        "The Bridges of Madison County","Ben-Hur: A Tale of the Christ","One Hundred Years of Solitude",
        "Lolita","Heidi","Anne of Green Gables","Black Beauty","The Name of the Rose",
        "The Eagle Has Landed","Watership Down","Charlotte's Web","The Ginger Man")

    init {  //This initializes our object; it runs ONCE
        mBooks = ArrayList()
        for (i in 0..29) {
            val book = Book()
            book.mTitle = titles[i]
            book.mRating = "0"
            mBooks.add(book)
        }
    }


}