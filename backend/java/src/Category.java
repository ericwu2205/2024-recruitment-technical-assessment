package src;

public class Category implements Comparable<Category> {
    int count;
    String name;

    public Category(int count, String name) {
        this.count = count;
        this.name = name;
    }

    @Override
    public int compareTo(Category c2) {
        if (count != c2.count) {
            return c2.count - count;
        } else {
            return (name).compareTo(c2.name);
        }
    }
}
