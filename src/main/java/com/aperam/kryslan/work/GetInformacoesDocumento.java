package com.aperam.kryslan.work;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class GetInformacoesDocumento {

    public String[] PegarNomeDosArquivos(final File pasta){
        File[] arquivos = pasta.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".docx") && !name.toLowerCase().startsWith("~$");
                //Os arquivos do Word possúem na sua pasta salva arquivos ocultos que começam com '~$...' para impedir
                //que o programa pegue esses arquivos ocultos e também garantir que o programa pegue apenas documentos
                //do word.
            }
        });

        if (arquivos != null) {
            String[] nomeDosArquivos = new String[arquivos.length];
            for (int i=0; i<arquivos.length; i++) {
                if (arquivos[i].isFile()) {
                    if (!arquivos[i].isHidden()) {
                        nomeDosArquivos[i] = arquivos[i].getName();
                    }
                }
            }
            return nomeDosArquivos;
        }else{
            System.out.println("Nenhum arquivo encontrado!");
            return null;
        }
    }

    public XWPFWordExtractor[] pegarDocumentos(String[] nomeDosDocumentos){
        XWPFDocument docx = null;  //Objeto que controla o documento.
        int qtdDocumentos = nomeDosDocumentos.length;

        XWPFWordExtractor[] corpoDoDocumento = new XWPFWordExtractor[qtdDocumentos];  //Informações do documento.
        for(int i=0; i<qtdDocumentos; i++) {
            try {
                docx = new XWPFDocument(new FileInputStream(nomeDosDocumentos[i]));
            } catch (IOException e) {
                e.printStackTrace();  //TRATAR DEPOIS.
            }
            corpoDoDocumento[i] = new XWPFWordExtractor(docx);
        }
        return corpoDoDocumento;
    }
}
