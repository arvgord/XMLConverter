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
public class Chapter {
    private String chapterName;
    private List<Section> sections;// = new ArrayList<>();
    
    public Chapter(){
        sections = new ArrayList<>();
    }
    
    public void setChapterName(String chapterName){
        this.chapterName = chapterName;
    }
    public String getChapterName(){
        return chapterName;
    }
    public void addSection(Section section){
        sections.add(section);
    }
    public List<Section> getSections(){
        return sections;
    }
}
