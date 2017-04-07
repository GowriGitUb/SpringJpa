/**
 * 
 */
package com.org.soft.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Gowrishankar B
 *
 */
public class ReportTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Document document = new Document();
		
		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("Report_Table.pdf"));
			document.open();
			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10f);
			
			float[] columnWidths = {1f,1f,1f};
			table.setWidths(columnWidths);
			
			PdfPCell cell1 = new PdfPCell(new Paragraph("Column1"));
			cell1.setBorder(1);
			cell1.setBorderColor(BaseColor.BLUE);
			cell1.setBackgroundColor(BaseColor.GREEN);
			cell1.setVerticalAlignment(Element.ALIGN_CENTER);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
			PdfPCell cell2 = new PdfPCell(new Paragraph("Column2"));
			cell2.setBorder(1);
			cell2.setBackgroundColor(BaseColor.DARK_GRAY);
			cell2.setBorderColor(BaseColor.MAGENTA);
			cell2.setVerticalAlignment(Element.ALIGN_JUSTIFIED);
			cell2.setHorizontalAlignment(Element.ANCHOR);
			
			PdfPCell cell3 = new PdfPCell(new Paragraph("Column3"));
			cell3.setBorder(3);
			cell3.setBackgroundColor(BaseColor.ORANGE);
			cell3.setBorderColor(BaseColor.PINK);
			cell3.setVerticalAlignment(Element.ALIGN_JUSTIFIED);
			cell3.setHorizontalAlignment(Element.ANCHOR);
			
			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			document.add(table);
			document.close();
			pdfWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

}
