/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.prodes.xmlconverter.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import xyz.prodes.xmlconverter.book.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.prodes.xmlconverter.book.Chapter;
import xyz.prodes.xmlconverter.book.Section;
import xyz.prodes.xmlconverter.exception.ParserException;

/**
 *
 * @author АРТЁМ
 */
public class AttributeParser implements Parser{
    private final static Logger LOGGER =  LogManager.getLogger();
    
    private List<Book> books;
    private Book currBook;
    private Chapter currChapter;
    private Section currSection;
    private String currName;

    @Override
    public List<Book> parse(String input) throws ParserException{
        FileInputStream fi;
        try {
            fi = new FileInputStream(input);
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(fi);
            

            int event = reader.getEventType();
            boolean hasNext;
            do{
                switch (event) {
                    case XMLStreamConstants.START_DOCUMENT:
                        LOGGER.info("Attribute parser started");
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        LOGGER.info("Attribute parser end");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        processStartElement(reader);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        processEndElement(reader);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (reader.isWhiteSpace())
                            break;
                        processCharacters(reader);
                    break;
                }
                hasNext = reader.hasNext();
                if (hasNext) {
                    event = reader.next();
                }              

            } while (hasNext);

            reader.close();
        } catch (FileNotFoundException | XMLStreamException ex){            
            throw new ParserException(ex);            
        }
        return books;
    }
    
    private void processStartElement(XMLStreamReader reader){
        String elementName = reader.getLocalName().toUpperCase();
        switch (BookAttributes.valueOf(elementName)){
            case BOOKS:
                books = new ArrayList<>();
                break;
            case BOOK:
                currBook = new Book();
                currName = reader.getAttributeValue(0);
                currBook.setBookName(currName);
                break;
            case CHAPTER:
                currChapter = new Chapter();
                currName = reader.getAttributeValue(0);
                currChapter.setChapterName(currName);
                break;
            case SECTION:
                currSection = new Section();
                currName = reader.getAttributeValue(0);
                currSection.setSectionName(currName);
                break;
        }
    }
    
    private void processEndElement(XMLStreamReader reader){
        String elementName = reader.getLocalName().toUpperCase();
        switch (BookAttributes.valueOf(elementName)){
            case BOOK:
                books.add(currBook);
                break;
            case CHAPTER:
                currBook.addChapter(currChapter);
                break;
            case SECTION:
                currChapter.addSection(currSection);
                break;
        }
    }
    
    private void processCharacters(XMLStreamReader reader){
        String text = reader.getText();
        currSection.setText(text);
    }
}
