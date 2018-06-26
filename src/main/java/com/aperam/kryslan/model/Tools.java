package com.aperam.kryslan.model;

import java.io.*;
import java.nio.channels.FileChannel;

public class Tools {

    public void copiaColaArquivo(String localArquivoCopiado, String localArquivoColado) {
        FileChannel src = null;
        try {
            src = new FileInputStream(new File(localArquivoCopiado)).getChannel();
        } catch (FileNotFoundException e) {System.out.println("Arquivo não encontrado: " + e);}

        FileChannel dest = null;
        try {
            dest = new FileOutputStream(new File(localArquivoColado)).getChannel();
        } catch (FileNotFoundException e) {System.out.println("Arquivo não encontrado: " + e);}

        try {
            dest.transferFrom(src, 0, src.size());
            dest.close();
        } catch (IOException e) {System.out.println("Arquivo não encontrado: "+e);}
    }
}
