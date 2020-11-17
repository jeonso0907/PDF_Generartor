import java.util.LinkedHashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class getURL {

    public static Map<String, String> pdfLinkGenerator2231(String meetingNum) {

        Map<String, String> pdfLinks = new LinkedHashMap<>();

        try {
            // Get String of the meeting number and combine it with a default URL
            String url = "http://web.cse.ohio-state.edu/software/2231/web-sw2/generated/s" + meetingNum + ".html";

            // Connect the jsoup with this url and get this html as a document
            Document doc = Jsoup.connect(url).get();

            // Get the links from the html
            Elements links = doc.getElementsByTag("a");

            // Iterate and store all the pdf links to the map
            for (Element link : links) {
                String linkHref = "http://web.cse.ohio-state.edu/software/2231/web-sw2/";
                linkHref += link.attr("href").substring(3);
                String linkText = link.text();
                pdfLinks.put(linkText, linkHref);
            }

        } catch (Exception e) {

        }

        // Return the titles and links of pdfs in this html
        return pdfLinks;
    }

    public static Map<String, String> pdfLinkGenerator2221(String meetingNum) {

        Map<String, String> pdfLinks = new LinkedHashMap<>();

        try {
            // Get String of the meeting number and combine it with a default URL
            String url = "http://web.cse.ohio-state.edu/software/2221/web-sw1/generated/s" + meetingNum + ".html";

            // Connect the jsoup with this url and get this html as a document
            Document doc = Jsoup.connect(url).get();

            // Get the links from the html
            Elements links = doc.getElementsByTag("a");

            // Iterate and store all the pdf links to the map
            for (Element link : links) {
                String linkHref = "http://web.cse.ohio-state.edu/software/2221/web-sw1/";
                linkHref += link.attr("href").substring(3);
                String linkText = link.text();
                pdfLinks.put(linkText, linkHref);
            }

        } catch (Exception e) {

        }

        // Return the titles and links of pdfs in this html
        return pdfLinks;
    }

    public static void main(String[] args) {

    }
}