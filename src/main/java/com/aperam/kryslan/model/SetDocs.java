package com.aperam.kryslan.model;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

public class SetDocs {

    public static void main(String[] args){
        SetDocs st = new SetDocs();
        File documentoCriado = st.criaDocumento(null, null);
        st.escreveDocumento(documentoCriado, "teste");
    }
    public File criaDocumento(String nomeDocumento, String localDocumento){
        if(nomeDocumento == null){
            nomeDocumento = "Todas as ofertas";
        }
        File fileDocumento = new File(String.valueOf(getClass().getResource("/resources/DocumentoPadrao/defaltOferta.docx")));

        XWPFDocument documento = new XWPFDocument();

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(fileDocumento);

            documento.write(fileOutputStream);  //(IOExceotion)
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return fileDocumento;
    }

    public void escreveDocumento(File documento, String informacao){
        //CRIANDO DOCUMENTO
        XWPFDocument docs = null;
        try {
            docs = new XWPFDocument(new FileInputStream(documento));
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*//INSERINDO CABEÇALHO
        CTP ctpHeader = CTP.Factory.newInstance();
        CTR ctrHeader = ctpHeader.addNewR();
        CTText ctHeader = ctrHeader.addNewT();

        Image image = new ImageIcon(getClass().getResource("/Imagens/cabecalhoAperam.png")).getImage();
        //ctrHeader.set*/
    }
}
