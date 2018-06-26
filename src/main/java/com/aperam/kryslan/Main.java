package com.aperam.kryslan;

import com.aperam.kryslan.model.GetDocs;
import com.aperam.kryslan.model.SetDocs;
import com.aperam.kryslan.model.Tools;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.*;

public class Main {
    private static String diretorioDosArquivos = "C:\\Users\\wwwkr\\Desktop\\Provisorios\\intellij projetos\\Ofertas";
    private static String arquivoColado = diretorioDosArquivos + "\\Todas as ofertas.docx";
    private static File folder = new File(diretorioDosArquivos);

    public static void main(String[] args) {
        GetDocs getDocs = new GetDocs();
        SetDocs setDocs = new SetDocs();
        Tools tools = new Tools();

        String[] nomeDosDocumentos = getDocs.PegarNomeDosArquivos(folder);  //Pega o nome dos documentos.

        //COPIA "defaltOferta.docx", pois ele é o padrão de documento com cabeçalho e rodapé prontos.
        File file = new File("src/main/resources/DocumentoPadrao/defaltOferta.docx");
        String absolutePathDoc1 = file.getAbsolutePath();  //Adiciona o caminho onde o executável está no HD ao caminho especificado: Ex: localExe + "src/main/..."
        tools.copiaColaArquivo(absolutePathDoc1, arquivoColado);

        XWPFWordExtractor[] documentos = getDocs.pegarDocumentos(nomeDosDocumentos);

        System.out.println(documentos);

    }
}