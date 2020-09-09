package concurrent.examples.checker;

import concurrent.entity.Book;

public class InitialSkipChecker extends Checker {

    @Override
    public void check() {
        try {

            Book bookA = new Book();
            printer.print(bookA.getName());

            Book bookB = new Book("A love Story with God.");
            printer.print(bookB.getName());

            Book book = (Book)unsafe.allocateInstance(Book.class);
            book.setName("Boy, do better.");
            printer.print(book.getName());

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

}
