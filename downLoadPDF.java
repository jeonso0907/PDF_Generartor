import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

class downLoadPDF {

    public static void mergePDF(Map<String, String> links) {

        // Set a pdf merger
        PDFMergerUtility PDFmerger = new PDFMergerUtility();

        try {

            // Set a map iterator
            Iterator linksList = links.entrySet().iterator();

            // Iterate to merge all pdf files
            while (linksList.hasNext()) {
                Map.Entry link = (Map.Entry) linksList.next();

                // Print out the titles of the pdfs to keep in track
                System.out.println(link.getKey().toString());

                // Convert the pdf url as an input stream
                URL url = new URL(link.getValue().toString());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream is = connection.getInputStream();

                // Add the pdfs in the merger
                PDFmerger.addSource(is);
            }

            // Set a destintation to store the merged pdf
            PDFmerger.setDestinationFileName("C:/Users/jeons/OneDrive/Desktop/CSE_Slide_Sample/CSE_Slides.pdf");

            // Merge the pdf and create the pdf in the setted destination
            PDFmerger.mergeDocuments();

        } catch (Exception e) {
            System.out.println("Download failed! Please try again");
        }

    }

    public static void main(String[] args) {

    }
}