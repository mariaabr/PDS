public class TermFilter extends FilterDecorator{

    public TermFilter(InterfaceTextReader textreader){
        super(textreader);
    }

    // public boolean hasNext(){

    // }

    @Override
    public String next(){
        String str = super.next();
        String words[] = str.split("\\s+");
        String final_str = "";
        for(String w:words){
            final_str += w;
            final_str += "\n";
        }

        return final_str;

    }
}