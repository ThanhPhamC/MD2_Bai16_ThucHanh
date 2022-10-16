package bai2;

import bai1.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteFile {
    public static void main(String[] args) {
    }
    public List<Integer> readFileText(String filepath) {
        List<Integer> numbers = new ArrayList<>();
        File file = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            file = new File(filepath);
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
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
        return numbers;
    }
    public void writeFile(String filepath, int max)  {
        File file = new File(filepath);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        OutputStreamWriter osw=new OutputStreamWriter(fos);
        BufferedWriter bw=new BufferedWriter(osw);
        String line="";
        line= "so max la: " +max;
        try {
            bw.write(line);
            bw.flush();
            bw.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
