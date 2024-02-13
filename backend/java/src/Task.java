package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;

public class Task {
    public record File(
        int id,
        String name,
        List<String> categories,
        int parent,
        int size
    ) {}

    /**
     * Task 1
     */
    public static List<String> leafFiles(List<File> files) {
        List<Integer> parentList = new ArrayList<>();
        List<String> leafList = new ArrayList<>();
        for (File f : files) {
            if (f.parent != -1) {
                parentList.add(f.parent);
            }
        }

        for (File f : files) {
            if (!parentList.contains(f.id)) {
                leafList.add(f.name);
            }
        }

        return leafList;
    }

    /**
     * Task 2
     */
    public static List<String> kLargestCategories(List<File> files, int k) {
        HashMap<String, Integer> catCount =  new HashMap<>();
        List<Category> categories = new ArrayList<>();
        List<String> names = new ArrayList<>();

        for (File file : files) {
            for (String category : file.categories) {
                if (catCount.containsKey(category)) {
                    catCount.put(category, catCount.get(category) + 1);
                } else {
                    catCount.put(category, 1);
                }
            }
        }

        for (String category : catCount.keySet()) {
            categories.add(new Category(catCount.get(category), category));
        }

        Collections.sort(categories);

        for (Category c : categories) {
            names.add(c.name);
        }

        return names.subList(0, k);
    }

    /**
     * Task 3
     */
    public static int largestFileSize(List<File> files) {
        HashMap<Integer, List<File>> childMap = new HashMap<>();
        // intialise a child map
        for (File file : files) {
            if (file.parent != -1) {
                childMap.putIfAbsent(file.parent, new ArrayList<>());
                childMap.get(file.parent).add(file);
            }
        }

        int largestSize = 0;
        for (File file : files) {
            int totalSize = calculateTotalSize(file, childMap);
            if (totalSize > largestSize) {
                largestSize = totalSize;
            }
        }

        return largestSize;
    }

    public static int calculateTotalSize(File file, HashMap<Integer, List<File>> childMap) {
        if (!childMap.containsKey(file.id)) {
            return file.size;
        } else {
            int totalSize = file.size;
            for (File f : childMap.get(file.id)) {
                totalSize += calculateTotalSize(f, childMap);
            }

            return totalSize;
        }
    }

    public static void main(String[] args) {
        List<File> testFiles = List.of(
            new File(1, "Document.txt", List.of("Documents"), 3, 1024),
            new File(2, "Image.jpg", List.of("Media", "Photos"), 34, 2048),
            new File(3, "Folder", List.of("Folder"), -1, 0),
            new File(5, "Spreadsheet.xlsx", List.of("Documents", "Excel"), 3, 4096),
            new File(8, "Backup.zip", List.of("Backup"), 233, 8192),
            new File(13, "Presentation.pptx", List.of("Documents", "Presentation"), 3, 3072),
            new File(21, "Video.mp4", List.of("Media", "Videos"), 34, 6144),
            new File(34, "Folder2", List.of("Folder"), 3, 0),
            new File(55, "Code.py", List.of("Programming"), -1, 1536),
            new File(89, "Audio.mp3", List.of("Media", "Audio"), 34, 2560),
            new File(144, "Spreadsheet2.xlsx", List.of("Documents", "Excel"), 3, 2048),
            new File(233, "Folder3", List.of("Folder"), -1, 4096)
        );
        
        List<String> leafFiles = leafFiles(testFiles);
        leafFiles.sort(null);

        assert leafFiles.equals(List.of(
            "Audio.mp3",
            "Backup.zip",
            "Code.py",
            "Document.txt",
            "Image.jpg",
            "Presentation.pptx",
            "Spreadsheet.xlsx",
            "Spreadsheet2.xlsx",
            "Video.mp4"
        ));

        assert kLargestCategories(testFiles, 3).equals(List.of(
            "Documents", "Folder", "Media"
        ));

        assert largestFileSize(testFiles) == 20992;

        // Random test

        List<File> testFiles1 = List.of(
            new File(1, "Document.txt", List.of("Documents"), 3, 1024),
            new File(2, "Image.jpg", List.of("Media", "Photos"), 34, 2048),
            new File(3, "Folder", List.of("Folder"), -1, 0)
        );

        assert kLargestCategories(testFiles1, 3).equals(List.of(
            "Documents", "Folder", "Media"
        ));

        List<String> leafFiles1 = leafFiles(testFiles1);
        leafFiles.sort(null);
        assert leafFiles1.equals(List.of(
            "Document.txt",
            "Image.jpg"
        ));
        assert largestFileSize(testFiles1) == 2048;

    }
}