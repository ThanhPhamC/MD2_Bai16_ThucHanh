package bai1;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap file duong dan: ");
        String filepath = sc.nextLine();
        Main readFileText = new Main();
        readFileText.ReadFileText(filepath);
    }

    public void ReadFileText(String filepath) {
        File file = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            file = new File(filepath);
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            System.out.println(" du lieu trong file la: ");
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            System.out.println("tong la: " + sum);
        } catch (RuntimeException ex1) {
            ex1.printStackTrace();
        } catch (FileNotFoundException ex2) {
            System.out.println("file bi rong");
        } catch (IOException ex3) {
            ex3.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}