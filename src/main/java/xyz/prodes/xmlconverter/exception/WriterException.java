/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.prodes.xmlconverter.exception;

/**
 *
 * @author АРТЁМ
 */
public class WriterException extends XMLException{

    public WriterException (Exception ex){
        super(ex);
    }
}
