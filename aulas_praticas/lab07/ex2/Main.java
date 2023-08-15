public class Main {
    
    public static void main(String[] args) {
        
        // example 1
        InterfaceTextReader reader1 = new TextReader("exemplo1.txt");

        TermFilter t1 = new TermFilter(new TextReader("exemplo1.txt"));
        NormalizationFilter n1 = new NormalizationFilter(new TextReader("exemplo1.txt"));
        VowelFilter v1 = new VowelFilter(new TextReader("exemplo1.txt"));
        CapitalizationFilter c1 = new CapitalizationFilter(new TextReader("exemplo1.txt"));

        // variations 2
        VowelFilter vt1 = new VowelFilter(new TermFilter(new TextReader("exemplo1.txt")));
        VowelFilter vn1 = new VowelFilter(new TermFilter(new TextReader("exemplo1.txt")));
        NormalizationFilter nc1 = new NormalizationFilter(new CapitalizationFilter(new TextReader("exemplo1.txt")));

        // variations 3
        TermFilter tnc1 = new TermFilter(new NormalizationFilter(new CapitalizationFilter(new TextReader("exemplo1.txt"))));

        // variations 4
        VowelFilter all1 = new VowelFilter(new TermFilter(new NormalizationFilter(new CapitalizationFilter(new TextReader("exemplo1.txt")))));
        

        InterfaceTextReader lista1[] = {reader1, t1, n1, v1, c1, vt1, vn1, nc1, tnc1, all1};
        System.out.println("Example 1 with file -> exemplo1.txt");
        System.out.println();
        int i = 0;
        for (InterfaceTextReader tr1 : lista1){
            tr1.hasNext();
            if(tr1.next() != null){
                i++;
                System.out.printf("%d: %s\n", i, tr1.next());
            }
        }

        // example 2
        InterfaceTextReader reader2 = new TextReader("exemplo2.txt");

        TermFilter t2 = new TermFilter(new TextReader("exemplo2.txt"));
        NormalizationFilter n2 = new NormalizationFilter(new TextReader("exemplo2.txt"));
        VowelFilter v2 = new VowelFilter(new TextReader("exemplo2.txt"));
        CapitalizationFilter c2 = new CapitalizationFilter(new TextReader("exemplo2.txt"));

        // variations 2
        VowelFilter vt2 = new VowelFilter(new TermFilter(new TextReader("exemplo2.txt")));
        VowelFilter vn2 = new VowelFilter(new TermFilter(new TextReader("exemplo2.txt")));
        NormalizationFilter nc2 = new NormalizationFilter(new CapitalizationFilter(new TextReader("exemplo2.txt")));

        // variations 3
        TermFilter tnc2 = new TermFilter(new NormalizationFilter(new CapitalizationFilter(new TextReader("exemplo2.txt"))));

        // variations 4
        VowelFilter all2 = new VowelFilter(new TermFilter(new NormalizationFilter(new CapitalizationFilter(new TextReader("exemplo2.txt")))));
        

        InterfaceTextReader lista2[] = {reader2, t2, n2, v2, c2, vt2, vn2, nc2, tnc2, all2};
        System.out.println("Example 2 with file -> exemplo2.txt");
        System.out.println();
        int j = 0;
        for (InterfaceTextReader tr2 : lista2){
            tr2.hasNext();
            j++;
            System.out.printf("%d: %s\n", j, tr2.next());
        }
    }
}
