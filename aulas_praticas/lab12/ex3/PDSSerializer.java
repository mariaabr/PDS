import java.lang.reflect.*;
import java.util.Arrays;

public class PDSSerializer {
    public static String fromObject(Object o) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        //Class cl= o.getClass();
        //Explore os metodos
        //cl.getMethods();
        //cl.getFields();
        //Vejao javadocdasclasses: Class, Method, Field, Modifier
        String Nameline, Priceline, Ownerline, Passageirosline;

        Class<?> cl = o.getClass();
        
        Field name = cl.getDeclaredField("name");
		name.setAccessible(true);
		String fieldName = (String)name.get(o);
		
		Field price = cl.getDeclaredField("size");
		price.setAccessible(true);
		Integer fieldPrice = (Integer)price.get(o);
        
		Field owner = cl.getDeclaredField("owner");
		owner.setAccessible(true);
		Owner fieldOwner = (Owner) owner.get(o);
		
		Field passageiros = cl.getDeclaredField("passageiros");
		passageiros.setAccessible(true);
		String[] fieldPassageiros = (String[])passageiros.get(o);

        Nameline = "Name: " + fieldName;
        Priceline = "Price: " + fieldPrice;
        Ownerline = "Owner: {\n" + fieldOwner + "\n}";
        Passageirosline = "Passageiros: " + Arrays.toString(fieldPassageiros);
		
        return Nameline + '\n' + Priceline + '\n' + Ownerline + '\n' + Passageirosline;
    }
}