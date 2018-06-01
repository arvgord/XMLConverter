/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.prodes.xmlconverter.parser;

import java.util.List;
import xyz.prodes.xmlconverter.book.Book;
import xyz.prodes.xmlconverter.exception.ParserException;

/**
 *
 * @author АРТЁМ
 */
public interface Parser{
    List<Book> parse(String input) throws ParserException;
}
