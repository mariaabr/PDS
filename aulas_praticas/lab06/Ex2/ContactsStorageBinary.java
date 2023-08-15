import java.util.*;
import java.io.*;

public class ContactsStorageBinary implements ContactsStorageInterface{

    private File filebin;
    private List<Contact> contactos;
    private String line;

    public ContactsStorageBinary(File filebin){
        this.filebin = filebin;
    }

    public List<Contact> loadContacts(){

        contactos = new ArrayList<>();

        try {
            BufferedReader input = new BufferedReader( new FileReader(this.filebin));

            line = input.readLine();

            if(line != null){
                String[] info = line.split(":");
                contactos.add(new Contact(info[0], info[1]));
            }
            
            input.close();
            
        } catch (IOException e) {
            System.out.println("Error opening the file!");
        }

        return contactos;
    }

    public boolean saveContacts (List<Contact> list){

        try{
            BufferedWriter filewrite = new BufferedWriter(new FileWriter(this.filebin));

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