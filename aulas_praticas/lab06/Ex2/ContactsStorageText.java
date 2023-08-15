import java.util.*;
import java.io.*;

public class ContactsStorageText implements ContactsStorageInterface{

    private File filetxt;
    private List<Contact> contactos;
    private String line;

    public ContactsStorageText(File filetxt){
        this.filetxt = filetxt;
    }

    public List<Contact> loadContacts(){

        contactos = new ArrayList<>();

        try {
            Scanner input = new Scanner(this.filetxt);

            while(input.hasNextLine()){
                line = input.nextLine();
    
                String[] info = line.split(":");
                // System.out.println(info[0]);
                // System.out.println(info[1]);
                contactos.add(new Contact(info[0], info[1])); 
            }
            
            input.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file!");
        }

        return contactos;
    }

    public boolean saveContacts (List<Contact> list){

        try{
            FileWriter filewrite = new FileWriter(this.filetxt);

            for(Contact contact : list){
                filewrite.write(contact.toString() + "\n");
            }

            filewrite.close();
            return true;
        } catch (IOException e){
            System.err.println("ERRO: falha a guardar o contacto!");
            e.printStackTrace();
            return false;
        }
    }
}