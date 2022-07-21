package readPDF;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.testautomationguru.utility.PDFUtil;

public class ReadPDFWithPDFUtil {

	@Test(priority = 1)
	public void getTextFromPDF() {

	//	File file= new File("C:/Users/DELL/OneDrive/Documents/File_pdf.pdf");
		String fileLocation = "C:\\Users\\DELL\\Downloads\\sample-pdf-with-images.pdf";
		
		PDFUtil pdfUtil = new PDFUtil();
		try {
				String text = pdfUtil.getText(fileLocation, 2);
				System.out.println(text);
			
			} catch (IOException e) {
				e.printStackTrace();
		}
	}
	@Test(priority = 2)
	public void extractImagesFromPDF() {

		String fileLocation = "C:\\Users\\DELL\\Downloads\\sample-pdf-with-images.pdf";
		String DownloadimgsToFolder = "C:/Users/DELL/OneDrive/Documents/DownloadedImagesfromPDF";
		
		PDFUtil pdfUtil = new PDFUtil();
		try {
			pdfUtil.setImageDestinationPath(DownloadimgsToFolder);
			pdfUtil.extractImages(fileLocation); 			//extract images
			System.out.println("images downloaded");
			System.out.println(pdfUtil.getText(fileLocation, 2));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
