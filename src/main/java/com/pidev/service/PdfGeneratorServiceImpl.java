package com.pidev.service;

import java.io.FileNotFoundException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

public class PdfGeneratorServiceImpl implements PdfGeneratorService{
	
	public void pdfCreation(){
		
		String filePath = "C:\\Users\\fatma\\Desktop\\pi 4eme\\pdf\\test.pdf";
		
		try {
			PdfWriter writer = new PdfWriter(filePath);
			PdfDocument pdfDocument = new PdfDocument(writer);
			pdfDocument.addNewPage();
			Document document = new Document(pdfDocument);
			document.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
