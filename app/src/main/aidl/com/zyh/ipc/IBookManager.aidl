package com.zyh.ipc;

import com.zyh.ipc.Book;
import com.zyh.ipc.IOnBookListener;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
    void registerListener(IOnBookListener listener);
    void unregisterListener(IOnBookListener listener);
}