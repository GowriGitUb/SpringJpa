/**
 * 
 */
package com.org.soft.report;

import java.io.FileOutputStream;
import java.net.URL;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Gowrishankar B
 *
 */
public class ReportImage {

	public static void main(String[] args) {

		Document document = new Document();
		try
		{
		    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("AddImageExample.pdf"));
		    document.open();
		    document.add(new Paragraph("Image Example"));
		    String imageUrl = "http://www.eclipse.org/xtend/images/java8_logo.png";
		    Image image2 = Image.getInstance(new URL(imageUrl));
		    image2.setAbsolutePosition(100f, 550f);
		    image2.scaleAbsolute(200, 200);
		    document.add(image2);
		 
		    document.close();
		    writer.close();
		} catch (Exception e)
		{
		    e.printStackTrace();
		}
}
}
