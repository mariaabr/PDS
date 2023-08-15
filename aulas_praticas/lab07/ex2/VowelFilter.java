public class VowelFilter extends FilterDecorator{

    public VowelFilter(InterfaceTextReader textreader){
        super(textreader);
    }

    @Override
    public String next(){

        String str = super.next();
        return str.replaceAll("[AEIOUaeiouáéíóúã]", "");        
    }
}