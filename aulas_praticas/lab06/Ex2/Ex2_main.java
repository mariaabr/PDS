import java.io.*;

public class Ex2_main {
    public static void main(String[] args) {
        
        //file creation and writing
        File file = new File("contactos1.txt");

        try {

            file.createNewFile();
            FileWriter file_writer = new FileWriter(file);
        
            file_writer.write("João: 937 487 209 \n");
            file_writer.write("Carlão: 934 645 243 \n");
            
            file_writer.close();
        } catch (Exception e) {
            System.out.println("Error creating file!");
        }


        Contact contacto1 = new Contact("Roberta", "967 483 546");
        Contact contacto2 = new Contact("Ofélia", "932 224 567");
        Contact contacto3 = new Contact("Josefina", "923 111 397");
        Contact contacto4 = new Contact("Artéfio", "918 765 485");

        ContactsStorageText contactos = new ContactsStorageText(file);
        ContactsStorageBinary contactos_binary = new ContactsStorageBinary(file); 
        DatabaseContacts lista_contactos = new DatabaseContacts();

        lista_contactos.add(contacto1);
        lista_contactos.add(contacto2);
        lista_contactos.add(contacto3);

        System.out.println();
        lista_contactos.remove(contacto3);

        lista_contactos.openAndLoad(contactos);
        lista_contactos.saveAndClose();
        lista_contactos.saveAndClose(contactos);
        System.out.println();
        
        if(!lista_contactos.exist(contacto1)){
            System.out.printf("O contacto %s não existe na lista de contactos!\n", contacto1);
        }
        if(!lista_contactos.exist(contacto4)){
            System.out.printf("O contacto %s não existe na lista de contactos!\n", contacto4);
        }
        System.out.println();
        lista_contactos.getByName("João");
        lista_contactos.getByName("Carolina");
        
        System.out.println();
        lista_contactos.openAndLoad(contactos_binary);
        lista_contactos.saveAndClose();
        lista_contactos.saveAndClose(contactos_binary);
                
        // testar remove -> done
        // testar exist -> done
        // testar getByName -> done
        // testar openAndLoad? -> done
        // testar saveAndClose? -> done 2x

    }    
}