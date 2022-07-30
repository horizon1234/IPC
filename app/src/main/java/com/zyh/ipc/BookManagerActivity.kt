package com.zyh.ipc

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button

class BookManagerActivity : AppCompatActivity() {

    private val TAG = "BookManagerAct"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_manager)

        findViewById<Button>(R.id.bind).setOnClickListener {
            val intent = Intent(this, BookManagerService::class.java)
            bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
        }
    }

    private val mConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val bookManager = IBookManager.Stub.asInterface(service)
            val list = bookManager.bookList
            for (book in list) {
                Log.i(TAG, "onServiceConnected: ${book.BookId} ${book.BookName}")
            }

            bookManager.addBook(Book(33, "Linux"))
            val list1 = bookManager.bookList
            for (book in list1) {
                Log.i(TAG, "onServiceConnected: ${book.BookId} ${book.BookName}")
            }
        }

        override fun onServiceDisconnected(name: ComponentName?) {
        }
    }

    override fun onDestroy() {
        unbindService(mConnection)
        super.onDestroy()
    }
}