package personal;

public class Test {

    public static void printInfo(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void findBook(String[] array, String book) {
        String rst = "Book not found";
        for (String i : array) {
            if (i.equals(book)) {
                rst = "Book found";
                break;
            }
        }
        System.out.println(rst);
    }

    public static String[] fill(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = "book #" + (i + 1);
        }
        return array;
    }

    public static String[] fillReverse(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[array.length - 1 - i] = "book #" + (i + 1);
        }
        return array;
    }

    public static void main(String[] args) {
        String[] books = new String[10];
        fill(books);
        printInfo(books);
        fillReverse(books);
        printInfo(books);
        String sBook = "book #55";
        findBook(books, sBook);
    }
}

