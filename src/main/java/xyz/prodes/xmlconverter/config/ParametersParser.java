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
public class ParametersParser {
    public Parameters parseArgs(String[] args){
        Parameters params = new Parameters();                
        for (int i = 0; i < args.length-1; i+=2) {
            String argumentName = args[i];
            String argumentValue = args[i+1];
            switch(argumentName){
                case "-i":                    
                    params.setInput(argumentValue);                    
                    break;
                case "-o":
                    params.setOutput(argumentValue);                    
                    break;
                case "-p":
                    argumentValue = argumentValue.toUpperCase();
                    ParserType parserType = ParserType.valueOf(argumentValue);
                    params.setParser(parserType);                    
                    break;
                case "-w":
                    argumentValue = argumentValue.toUpperCase();
                    WriterType writerType = WriterType.valueOf(argumentValue);
                    params.setWriter(writerType);                   
                    break;
                default :
                    throw new IllegalArgumentException("Wrong format of arguments = " + args);
            }
        }
        return params;
    }
}
