import java.text.Normalizer;

public class NormalizationFilter extends FilterDecorator{

    public NormalizationFilter(InterfaceTextReader textreader){
        super(textreader);
    }

    @Override
    public String next(){

        String str = super.next();
        str = Normalizer.normalize(str, Normalizer.Form.NFD)
            .replaceAll("[^\\p{ASCII}]", "");
        str = str.replaceAll("[\\p{Punct}]", "");

        return str;
    }
}