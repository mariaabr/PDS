import java.util.*;

public class DatabaseContacts implements ContactsInterface{
        
    private ContactsStorageInterface store;
    private List<Contact> contactos;

    public DatabaseContacts(){
        this.contactos = new ArrayList<>();
    }

    public void openAndLoad(ContactsStorageInterface store){

        this.store = store;
        for(Contact contact : store.loadContacts()){
            if(!this.exist(contact)){
                contactos.add(contact);
            }
        }

        System.out.println("----------------Contactos:------------------\n");
        for(Contact contact : contactos){
            System.out.println(contact);
        }
        System.out.println("--------------------------------------------\n");
    }

    public void saveAndClose(){
        
        if(this.store.saveContacts(contactos)){
            System.out.println("Contacto(s) guardado(s) com sucesso!");
        } else {
            System.out.println("ERRO: contacto(s) não gurdado(s)...");
        }
    }

    public void saveAndClose(ContactsStorageInterface store){
        if(this.store.saveContacts(contactos)){
            System.out.println("Contacto(s) guardado(s) com sucesso!");
        } else {
            System.out.println("ERRO: contacto(s) não gurdado(s)...");
        }
    }

    public boolean exist(Contact contact){
        if(contactos.contains(contact)){
            System.out.printf("O contacto %s existe na lista de contactos!\n", contact);
            return true;
        }
        return false;
    }

    public Contact getByName(String name){
        for(Contact num : contactos){
            if(num.getName().equals(name)){
                System.out.printf("%s \n", num);
                return num;
            }
        }
        System.out.printf("Não há nenhum contacto com o nome %s.\n", name);
        return null;
    }

    public boolean add(Contact contact){
        if(contactos.contains(contact)){
            System.out.printf("Contacto %s já existente!\n", contact);
            return false;
        }
        contactos.add(contact);
        System.out.printf("Contacto %s adicionado com sucesso!\n", contact);
        return true;
    }

    public boolean remove(Contact contact){
        if(contactos.contains(contact)){
            contactos.remove(contact);
            System.out.printf("Contacto %s removido com sucesso!\n", contact);
            return true;
        }
        System.out.printf("Contacto %s não existente existente!\n", contact);
        return false;
    }

    // @Override
    // public List<Contact> loadContacts() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'loadContacts'");
    // }

    // @Override
    // public boolean saveContacts(List<Contact> list) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'saveContacts'");
    // }
}