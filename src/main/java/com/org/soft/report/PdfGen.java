/**
 * 
 */
package com.org.soft.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author samy
 *
 */
public class PdfGen {

	public static void main(String[] args) {

		Document document = new Document();
		
		try{
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("Hello.pdf"));
			document.open();
			document.add(new Paragraph("Welcome"));
			document.close();
			pdfWriter.close();
		}catch(DocumentException exception){
			exception.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
