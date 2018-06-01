/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.prodes.xmlconverter.book;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author АРТЁМ
 */
public class Book {
    private String bookName;
    private List<Chapter> chapters;
    
    public Book(){
        chapters = new ArrayList<>();
    }
    
    public void setBookName(String bookName){
        this.bookName = bookName;
    }
    public String getBookName(){
        return bookName;
    }
    public void addChapter(Chapter chapter){
        chapters.add(chapter);
    }
    public List<Chapter> getChapters(){
        return chapters;
    }
}
