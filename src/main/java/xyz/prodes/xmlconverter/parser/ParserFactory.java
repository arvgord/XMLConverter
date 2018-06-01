/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.prodes.xmlconverter.parser;

/**
 *
 * @author АРТЁМ
 */
public class ParserFactory {
    public static Parser create(ParserType parserType){
        switch(parserType){
            case ATTRIBUTE_BASED:
                return new AttributeParser();
            case ELEMENTS_BASED:
                return new ElementParser();
            case FLAT:
                return new FlatParser();
        }
        throw new IllegalArgumentException("Unknown parser type = " + parserType);
    }
}
