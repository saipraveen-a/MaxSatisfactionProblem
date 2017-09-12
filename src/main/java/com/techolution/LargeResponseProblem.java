package main.java.com.techolution;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LargeResponseProblem {

  private static final String NEWLINE = "\n";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String fileName = br.readLine();

    generateBytesFile(fileName + ".txt");

    br.close();
  }

  private static void generateBytesFile(String fileName) throws IOException {
    InputStream is = null;
    BufferedReader br = null;
    try {
      is = LargeResponseProblem.class.getResourceAsStream(fileName);
      br = new BufferedReader(new InputStreamReader(is));

      String line = null;
      Pattern pattern = Pattern.compile("([^\"]\\S*|\".+?\")\\s*");

      int largeRecordCount = 0;
      int largeRecordBytesSize = 0;
      while ((line = br.readLine()) != null) {
        Matcher m = pattern.matcher(line);
        String bytesSize = null;
        while (m.find()) {
          bytesSize = m.group(1);
        }
        int logRecordBytes = Integer.parseInt(bytesSize);
        if (logRecordBytes > 5000) {
          largeRecordCount++;
          largeRecordBytesSize += logRecordBytes;
        }
      }

      StringBuffer fileContent = new StringBuffer();
      fileContent.append(largeRecordCount).append(NEWLINE).append(largeRecordBytesSize);

      writeOutputFile("bytes_" + fileName, fileContent.toString());

    } finally {
      if (is != null)
        is.close();
      if (br != null)
        br.close();
    }
  }

  private static void writeOutputFile(String fileName, String content) throws IOException {
    BufferedWriter bw = null;

    try {
      bw = new BufferedWriter(new FileWriter(fileName));
      bw.write(content);
    } finally {
      bw.close();
    }
  }
}
