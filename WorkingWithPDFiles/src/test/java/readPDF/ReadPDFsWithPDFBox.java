package readPDF;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.testng.annotations.Test;

public class ReadPDFsWithPDFBox {

	
	@Test(priority = 1)
	public void readTextFromPDF() {
		try {
			File file = new File("C:/Users/DELL/OneDrive/Documents/File_pdf.pdf");
			PDDocument document = PDDocument.load(file); 
			System.out.println("No Of Pages:"+document.getNumberOfPages());
			PDFTextStripper textReader = new PDFTextStripper();
			String textOnPDF = textReader.getText(document);
		//	System.out.println(textOnPDF);
			System.out.println(textOnPDF.contains("Digital Documents—"));
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 2)
	public void RetrieveSignatureFields() {

				try {
				File file = new File("C:/Users/DELL/OneDrive/Documents/File_pdf.pdf");
				PDDocument document = PDDocument.load(file); 
				System.out.println("No Of Pages:"+document.getNumberOfPages());
								
				List list = document.getSignatureFields();
				System.out.println("all signature fields from the document: "+list);				 
				
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	@Test(priority = 3)
	public void addApageToPDF() {

				try {
				File file = new File("C:/Users/DELL/OneDrive/Documents/File_pdf.pdf");
				PDDocument document = PDDocument.load(file); 
				System.out.println("No Of Pages:"+document.getNumberOfPages());
							
				PDPage page = new PDPage();
				document.addPage(page);
				document.save("C:/Users/DELL/OneDrive/Documents/File2_pdf.pdf");
				System.out.println(document.getNumberOfPages());
			//	FileInputStream fis = new FileInputStream("C:/Users/DELL/OneDrive/Desktop/Kranthi_passport photo.jpg");
				
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
