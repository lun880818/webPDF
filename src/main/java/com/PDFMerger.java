package com;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class PDFMerger {
    public static void main(String[] args) {
        String inputDir = "C:\\javaOcp\\1z0-900考題範例\\仿真試題-遮答案版";
        String outputFile = "C:\\javaOcp\\1z0-900考題範例\\仿真試題-遮答案版\\merged_output.pdf";

        try {
            mergePDFs(inputDir, outputFile);
            System.out.println("PDF檔案已成功合併。test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mergePDFs(String inputDir, String outputFile) throws IOException {
        PDFMergerUtility merger = new PDFMergerUtility();
        File dir = new File(inputDir);
        File[] pdfFiles = dir.listFiles((d, name) -> name.endsWith(".pdf"));

        if (pdfFiles != null) {
            Arrays.sort(pdfFiles);
            for (File pdf : pdfFiles) {
                merger.addSource(pdf);
            }
        }

        merger.setDestinationFileName(outputFile);
        merger.mergeDocuments(null);
    }
}