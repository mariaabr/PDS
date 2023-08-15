public class CapitalizationFilter extends FilterDecorator{

    public CapitalizationFilter(InterfaceTextReader textreader){
        super(textreader);
    }

    @Override
    public String next(){
        String str = super.next();
        String words[] = str.split("\\s+");
        String final_str = "";
        for (String w : words){
            char word[] = w.toCharArray();
            word[0] = Character.toUpperCase(word[0]);
            word[w.length() - 1] = Character.toUpperCase(word[w.length() - 1]);
            for (char c : word){
                final_str += c;
            }
            final_str += " ";
        }

        return final_str;
    }
}