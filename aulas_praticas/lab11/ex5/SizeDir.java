import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class SizeDir {

    public AtomicLong getSizeOfDirectory(String path, boolean recursive) {

        Path directory = Paths.get(path);
        AtomicLong size = new AtomicLong(0);

        try {
            Files.walkFileTree(directory, new SimpleFileVisitor<>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

                    String[] dir = ((String) (directory + "")).split("/");
                    String[] path = ((String) (file + "")).split("/");

                    String dirName = path[path.length - 2];
                    String fileName = path[path.length - 1];

                    if (!dirName.equals(dir[dir.length - 1])) {
                        if (recursive) {
                            fileName = dirName + "/" + fileName;
                        } else {
                            return FileVisitResult.CONTINUE;
                        }
                    }

                    System.out.printf("./%-45s %5.1f (kB)\n", fileName, Double.valueOf(attrs.size())/1024);
                    size.addAndGet(attrs.size() / 1024);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) {
                    System.out.printf("Failed to get size of %s%n%s", file, e);
                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (IOException e) {
            System.err.printf("%s", e.getMessage());
        }
        return size;
    }
}
