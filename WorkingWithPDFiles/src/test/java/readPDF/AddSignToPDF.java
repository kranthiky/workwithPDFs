package readPDF;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureOptions;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigProperties;

public class AddSignToPDF {
		static SignatureOptions options;
	    static PDVisibleSigProperties visibleSignatureProperties;
	    
	public static void main(String[] args) throws IOException {
		File sign = new File("C:/Users/DELL/OneDrive/Desktop/Kranthi_passport photo.jpg");
	 	File filePDF = new File("C:/Users/DELL/OneDrive/Documents/File_pdf.pdf");
		signPDF(sign,filePDF);
	}

	public static void signPDF(File sign,File filePDF) throws IOException {
		 
		if (sign == null || !sign.exists()) {
	        throw new IOException("Document for signing does not exist");
	    }
		
		    FileOutputStream signdFile = new FileOutputStream(sign);
		    PDDocument doc = PDDocument.load(filePDF);
		    // create signature dictionary
		    PDSignature signature = new PDSignature();
		    signature.setFilter(PDSignature.FILTER_ADOBE_PPKLITE); // default filter
		    // subfilter for basic and PAdES Part 2 signatures
		    signature.setSubFilter(PDSignature.SUBFILTER_ADBE_PKCS7_DETACHED);
		    signature.setName("Johny");
		    signature.setLocation("Vpt");
		    signature.setReason("reason for signature");
		    // the signing date, needed for valid signature
		    signature.setSignDate(Calendar.getInstance());
	    // register signature dictionary and sign interface
		    if (visibleSignatureProperties != null && visibleSignatureProperties.isVisualSignEnabled()) {
		        options = new SignatureOptions();
		        options.setVisualSignature(visibleSignatureProperties);
		        options.setPage(visibleSignatureProperties.getPage() - 1);
		        doc.addSignature(signature, options);
		        doc.save("C:/Users/DELL/OneDrive/Documents/File5_pdf.pdf");
		    } else {
		        doc.addSignature(signature);
		        doc.save("C:/Users/DELL/OneDrive/Documents/File5_pdf.pdf");
		    }

		    doc.saveIncremental(signdFile);
		    doc.close();

		    IOUtils.closeQuietly(options);
		    System.out.println("Sign added");
		}
	}

