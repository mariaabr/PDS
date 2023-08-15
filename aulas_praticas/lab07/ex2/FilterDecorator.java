abstract class FilterDecorator implements InterfaceTextReader{
    
    protected InterfaceTextReader textreader;

    FilterDecorator(InterfaceTextReader textreader) {
        this.textreader = textreader;
    }

    public boolean hasNext(){
        return textreader.hasNext();
    }

    public String next(){
        return textreader.next();
    }
}