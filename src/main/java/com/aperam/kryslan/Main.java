package com.aperam.kryslan;

import com.aperam.kryslan.work.GetInformacoesDocumento;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.File;

public class Main {
    private static String diretorioDosArquivos = "C:\\Users\\wwwkr\\Desktop\\Provisorios\\intellij projetos\\Ofertas";
    private static File folder = new File(diretorioDosArquivos);

    public static void main(String[] args){
        GetInformacoesDocumento infoDocs = new GetInformacoesDocumento();

        String[] nomeDosDocumentos = infoDocs.PegarNomeDosArquivos(folder);

        XWPFWordExtractor[] documentos = infoDocs.pegarDocumentos(nomeDosDocumentos);

        for (String documento: nomeDosDocumentos) {
            System.out.println(documento);
        }
    }
}
