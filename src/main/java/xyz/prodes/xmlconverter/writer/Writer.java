/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.prodes.xmlconverter.writer;

import java.util.List;
import xyz.prodes.xmlconverter.book.Book;
import xyz.prodes.xmlconverter.exception.WriterException;

/**
 *
 * @author АРТЁМ
 */
public interface Writer {
    public void write(String outputFile, List<Book> books) throws WriterException;
}
