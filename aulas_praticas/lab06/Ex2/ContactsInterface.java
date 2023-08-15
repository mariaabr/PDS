public interface ContactsInterface {
    public void openAndLoad(ContactsStorageInterface store);
    public void saveAndClose();
    public void saveAndClose(ContactsStorageInterface store);
    public boolean exist(Contact contact); // done
    public Contact getByName(String name); // done
    public boolean add(Contact contact); // done
    public boolean remove(Contact contact); // done
}