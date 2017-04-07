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
 * @author Gowrishankar B
 *
 */
public class ReportAttributes {

	public static void main(String[] args) {

		Document document = new Document();
		
		
		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("Report_attributes.pdf"));
			document.open();
			document.add(new Paragraph("Report attributes are created for using this report"));
			document.addAuthor("GowriShankar BoopathyIndira");
			document.addCreationDate();
			System.out.println(document.addCreationDate());
			document.addCreator("BBIGS.com");
			document.addTitle("Set Report Attributes");
			document.addSubject("This report can show how create report with attributes");
			document.close();
			pdfWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
