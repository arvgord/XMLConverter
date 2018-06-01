/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.prodes.xmlconverter;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.prodes.xmlconverter.book.Book;
import xyz.prodes.xmlconverter.config.Parameters;
import xyz.prodes.xmlconverter.config.ParametersParser;
import xyz.prodes.xmlconverter.exception.XMLException;
import xyz.prodes.xmlconverter.parser.Parser;
import xyz.prodes.xmlconverter.parser.ParserFactory;
import xyz.prodes.xmlconverter.writer.Writer;
import xyz.prodes.xmlconverter.writer.WriterFactory;

/**
 *
 * @author АРТЁМ
 */
public class XMLConverter {
    private static final Logger LOGGER = LogManager.getLogger();
    private static List<Book> books;
    
    public static void main(String[] args) {
        
        ParametersParser paramsParser = new ParametersParser();
        Parameters params = paramsParser.parseArgs(args);
            
        try {    
            Parser parser = ParserFactory.create(params.getParser());
            books = parser.parse(params.getInput());
            
            Writer writer = WriterFactory.create(params.getWriter());
            writer.write(params.getOutput(), books);
            
        } catch (XMLException ex) {
            LOGGER.error(ex.getMessage());
        }
    }
    
}
