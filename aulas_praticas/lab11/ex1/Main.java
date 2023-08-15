package lab11.ex1;

public class Main {
    
    public static void main(String[] args) {
        
        Telemovel[] telemoveis = { new Telemovel("NOKIA", "I8", 356.12, "16GB", "1 CAMARAS"),
        new Telemovel("HUAWEI", "X4", 234.12, "32GB", "3 CAMARAS"),
        new Telemovel("APPLE", "A13", 612.45, "128GB", "4 CAMARAS"),
        new Telemovel("HUAWEI", "GYT8", 334.75, "64GB", "4 CAMARAS"),
        new Telemovel("SAMSUNG", "I7", 336.27, "32GB", "1 CAMARAS"),
        new Telemovel("NOKIA", "X13", 665.23, "64GB", "2 CAMARAS"),
        new Telemovel("XIAOMI", "LL8", 823.00, "128GB", "3 CAMARAS") };

        ContextWithSorting bub = new ContextWithSorting(new BubbleSort());
        bub.sort(telemoveis);

        ContextWithSorting merge = new ContextWithSorting(new MergeSort());
        merge.sort(telemoveis);

        ContextWithSorting quick = new ContextWithSorting(new QuickSort());
        quick.sort(telemoveis);
    }
}
