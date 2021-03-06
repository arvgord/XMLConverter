/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.prodes.xmlconverter.writer;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.prodes.xmlconverter.book.Book;
import xyz.prodes.xmlconverter.book.Chapter;
import xyz.prodes.xmlconverter.book.Section;
import xyz.prodes.xmlconverter.exception.WriterException;

/**
 *
 * @author ARTYOM
 */
public class ElementWriter implements Writer{
    private final static Logger LOGGER =  LogManager.getLogger();
    
    private List<Chapter> chapters;
    private List<Section> sections;
    
    @Override
    public void write(String outputFile, List<Book> books) throws WriterException{
        try {
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream(outputFile), "UTF-8");
            writeBooks(books, writer);
        } catch (IOException | XMLStreamException ex){
            throw new WriterException(ex);
        }        
    }
    private void writeBooks(List<Book> books, XMLStreamWriter writer) throws WriterException{
        try {
            LOGGER.info("Element writer started");
            
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeCharacters("\n");
            writer.writeStartElement("books");
            writer.writeCharacters("\n\t");
            
            for (Book book : books) {
                writeBook(book, writer);
            }
            
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.close();
            LOGGER.info("Element writer end");
        } catch (XMLStreamException ex){
            throw new WriterException(ex);
        }         
    }
    
    private void writeBook(Book book, XMLStreamWriter writer) throws WriterException{
        try {            
            writer.writeStartElement("book");
            writer.writeStartElement("name");
            writer.writeCharacters(book.getBookName());
            writer.writeEndElement();
            writer.writeCharacters("\n");
                
            chapters = book.getChapters();
            for (Chapter chapter : chapters) {
                writeChapter(chapter, writer);
            }
            writer.writeEndElement();
        } catch (XMLStreamException ex) {
            throw new WriterException(ex);
        }
    }
    
    private void writeChapter(Chapter chapter, XMLStreamWriter writer) throws WriterException{
        try{
            writer.writeStartElement("chapter");
            writer.writeStartElement("name");
            writer.writeCharacters(chapter.getChapterName());
            writer.writeEndElement();
            writer.writeCharacters("\n");
                    
            sections = chapter.getSections();
            for (Section section : sections) {
                writeSection(section, writer);
            }
            writer.writeEndElement();
        } catch (XMLStreamException ex){
            throw new WriterException(ex);
        }
    }
    
    private void writeSection(Section section, XMLStreamWriter writer) throws WriterException{
        try{
            writer.writeStartElement("section");
            writer.writeCharacters("\n\t");
            writer.writeStartElement("name");
            writer.writeCharacters(section.getSectionName());
            writer.writeEndElement();
            writer.writeCharacters("\n");
                        
            writer.writeStartElement("para");
            writer.writeCharacters(section.getText());
            writer.writeEndElement();
            writer.writeEndElement();
        } catch (XMLStreamException ex){
            throw new WriterException(ex);
        }
    }
}
