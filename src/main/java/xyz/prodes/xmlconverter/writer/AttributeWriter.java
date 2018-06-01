/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.prodes.xmlconverter.writer;

import java.io.FileOutputStream;
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
 * @author АРТЁМ
 */
public class AttributeWriter implements Writer{
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
            LOGGER.info("Attribute writer started");
            
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
            
            LOGGER.info("Attribute writer end");
        } catch (XMLStreamException ex){
            throw new WriterException(ex);
        }         
    }
    
    private void writeBook(Book book, XMLStreamWriter writer) throws WriterException{
        try {            
            writer.writeStartElement("book");
            writer.writeAttribute("name", book.getBookName());
            writer.writeCharacters("\n\t");
                
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
            writer.writeAttribute("name", chapter.getChapterName());
            writer.writeCharacters("\n\t");
                    
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
            writer.writeAttribute("name", section.getSectionName());
            writer.writeCharacters("\n\t");
                        
            writer.writeStartElement("text");
            writer.writeCharacters(section.getText());
            writer.writeEndElement();
            writer.writeEndElement();
        } catch (XMLStreamException ex){
            throw new WriterException(ex);
        }
    }
}
