public class Demo {
    public static void main(String[] args) throws NoSuchFieldException {
        Ship s = new Ship("BelaRia", 200);
        s.setOwner(new Owner("Manuel"));
        s.setPassageiros(new String[]{"Manuel", "Amilcar"});
        try{
            System.out.println(PDSSerializer.fromObject(s));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}