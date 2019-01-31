package com.journaldev.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import java.io.File;

@RestController
public class PersonController {
	
	@RequestMapping("/")
	public String healthCheck() {
		readPdf();
		return "PDF file is read Successfully...";
	}
	
	public void readPdf() {

        try (PDDocument document = PDDocument.load(new File("C:/Input/Temp.pdf"))) {

            document.getClass();

            if (!document.isEncrypted()) {
			
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                //System.out.println("Text:" + st);

				// split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    System.out.println(line);
                }

            }

        } catch(Exception e) {
          e.printStackTrace();
        }

    }
	
}
