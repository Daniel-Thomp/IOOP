package Game;

public class Book {
    private String title;
    private String author;
    private int pages;
    private String skill;

    Book(String title, String author, int pages, String skill) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.skill = skill;

    }

    public void printDetails() {
        printHelper(new String[] { title, author, Integer.toString(pages), skill });
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getSkill() {
        return skill;
    }

    public static void printHelper(String[] toPrint) {
        int maxLen = 0;
        for (String field : toPrint) {
            if (field.length() > maxLen) {
                maxLen = field.length();
            }
        }
        for (String field : toPrint) {
            rainbowPrint(field, maxLen + 2);
        }
    }

    private static void rainbowPrint(String text, int len) {
        System.out.println();
        int totalPadding = len - text.length();
        int left = totalPadding / 2;
        int right = totalPadding - left;
        text = ">".repeat(left) + " " + text + " " + "<".repeat(right);
        for (int i = 0; i < text.length(); i++) {
            System.out.print("\u001B[0;" + (91 + i % 6) + "m" + text.charAt(i));
        }
        System.out.println("\u001B[0;0m");
    }
}
