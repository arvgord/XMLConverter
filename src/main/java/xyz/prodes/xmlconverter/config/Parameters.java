/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.prodes.xmlconverter.config;

import xyz.prodes.xmlconverter.parser.ParserType;
import xyz.prodes.xmlconverter.writer.WriterType;

/**
 *
 * @author АРТЁМ
 */
public class Parameters {
    private ParserType parserType;
    private WriterType writerType;
    private String input;
    private String output;
    
    public void setParser(ParserType parserType){
        this.parserType = parserType;
    }    
    public ParserType getParser(){
        return parserType;
    }
    public void setWriter(WriterType writerType){
        this.writerType = writerType;
    }
    public WriterType getWriter(){
        return writerType;
    }
    public void setInput(String input){
        this.input = input;
    }    
    public String getInput(){
        return input;
    }
    public void setOutput(String output){
        this.output = output;
    }    
    public String getOutput(){
        return output;
    }
}
