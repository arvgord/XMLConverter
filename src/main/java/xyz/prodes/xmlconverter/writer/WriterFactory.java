/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.prodes.xmlconverter.writer;

/**
 *
 * @author АРТЁМ
 */
public class WriterFactory {
    public static Writer create(WriterType writerType){
        switch(writerType){
            case ATTRIBUTE_BASED:
                return new AttributeWriter();
            case TABLE_OF_CONTENT:
                return new ContentWriter();
            case ELEMENTS_BASED:
                return new ElementWriter();    
            case FLAT:
                return new FlatWriter();
        }
        throw new IllegalArgumentException("Unknown parser type = " + writerType);    
    }
}
