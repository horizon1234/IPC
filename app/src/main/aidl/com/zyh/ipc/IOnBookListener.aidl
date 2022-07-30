// IOnBookListener.aidl
package com.zyh.ipc;

import com.zyh.ipc.Book;

//返回所有Book
interface IOnBookListener {

    void onAllBook(in List<Book> books);

}