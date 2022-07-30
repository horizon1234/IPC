package com.zyh.ipc

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteCallbackList
import android.util.Log
import java.util.concurrent.CopyOnWriteArrayList

class BookManagerService : Service() {

    private val mBookList = CopyOnWriteArrayList<Book>()

    //listener列表
    private val mListenerList = RemoteCallbackList<IOnBookListener>()

    private val mBinder = object : IBookManager.Stub(){
        override fun getBookList(): MutableList<Book> {
            return mBookList
        }

        override fun addBook(book: Book?) {
            mBookList.add(book!!)
        }

        override fun registerListener(listener: IOnBookListener?) {
            mListenerList.register(listener)
        }

        override fun unregisterListener(listener: IOnBookListener?) {
            mListenerList.unregister(listener)
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()
        mBookList.add(Book(11,"Android"))
        mBookList.add(Book(22,"Ios"))
        //开启线程循环回调book信息
//        Thread{
//            while (true){
//                Thread.sleep(5000)
//                for (listener in mListenerList){
//                    Log.i("BMS", "onCreate: 回调信息")
//                    listener.onAllBook(mBookList)
//                }
//            }
//        }.start()
    }
}