// BookManager.aidl
package com.mccree.review;

import com.mccree.review.Book;
// Declare any non-default types here with import statements

interface BookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
    List<Book> getBookList();
    void addBook(in Book book);
}