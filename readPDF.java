import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class readPDF {

    public static String numConverter(int i) {

        String num = "";

        // Store the number as a string based on its digits
        if (i < 10) {
            num = "00" + Integer.toString(i);
        } else if (i < 100) {
            num = "0" + Integer.toString(i);
        } else if (i < 1000) {
            num = Integer.toString(i);
        }

        return num;
    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        // Prompt the user to determind the scale of the files to parse
        System.out.println();
        System.out.println("Enter your CSE course number(2221 or 2231)");
        System.out.print("Or type nothing to exit: ");
        int cseNum = scnr.nextInt();
        ArrayList<Integer> cA = new ArrayList<>();
        cA.add(2221);
        cA.add(2231);

        // Prompt again until the user type nothing or an appropriate course number
        while (!cA.contains(cseNum)) {
            if (Integer.toString(cseNum).isEmpty()) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            System.out.println();
            System.out.println("Wrong CSE number, type again");
            System.out.println("Enter your CSE course number(2221 or 2231)");
            System.out.print("Or type nothing to exit: ");
            cseNum = scnr.nextInt();
        }

        System.out.println();
        System.out.print("Enter the starting course meeting number: ");
        int startNum = scnr.nextInt();
        System.out.print("Enter the ending course meething number: ");
        int endNum = scnr.nextInt();

        // Create a directory to store a pdf
        fileGenerator.generateDirectory();

        // Set a linked map to store the pdf links
        Map<String, String> links = new LinkedHashMap<>();

        // Loop to get pdf links from each html and store them in the map
        for (int i = startNum; i <= endNum; i++) {

            String meetingNum = numConverter(i);

            if (cseNum == 2231) {
                links.putAll(getURL.pdfLinkGenerator2231(meetingNum));
            } else if (cseNum == 2221) {
                links.putAll(getURL.pdfLinkGenerator2221(meetingNum));
            }

        }

        // Download the pdf files and merge them in a one pdf
        downLoadPDF.mergePDF(links);

        // Print out the success message
        System.out.println("Download success");

        scnr.close();
    }

}