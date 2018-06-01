/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.prodes.xmlconverter.book;

/**
 *
 * @author АРТЁМ
 */
public class Section {
    private String sectionName;
    private String text;
    
    public void setSectionName(String sectionName){
        this.sectionName = sectionName;
    }
    public String getSectionName(){
        return sectionName;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }
}
