/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificationemail;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Arrays;
/**
 *
 * @author Patrick
 */
public class FileHelper {
    final String FILE_NAME = "accounts.sdv";
    BufferedReader reader;
    PrintWriter writer;
    public FileHelper(){
        //nothing
    }
    
    public static void main(String[] args){
        System.out.println("Testing FileHelper class...");
        FileHelper f = new FileHelper();
        String[] accounts = f.readAccounts();
    }
    String[] readAccounts(){
        String[] accounts = new String[100];
        int count = 0;
        try{
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line = reader.readLine();
            while(line != null){
                accounts[count] = line;
                count++;
                line = reader.readLine();
            }
        }
        catch (FileNotFoundException f){
            System.out.println("File Not Found: "+ f);
        }
        catch (IOException i){
            System.out.println("Cannot Read File: "+ i);
        }
        return Arrays.copyOfRange(accounts,0, count);
    }
    void writeAccounts(String[] lines){
        try{
            writer = new PrintWriter(new FileWriter(FILE_NAME));
            for(int i = 0; i < lines.length;i++){
                writer.println(lines[i]);
            }
            writer.close();
        }
        catch (IOException i){
            System.out.println("Cannot Open File");
        }
    }
    
}
