package com.zyh.ipc;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    public int BookId;
    public String BookName;

    public Book(int bookId, String bookName){
        this.BookId = bookId;
        this.BookName = bookName;
    }

    protected Book(Parcel in) {
        BookId = in.readInt();
        BookName = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(BookId);
        dest.writeString(BookName);
    }
}
