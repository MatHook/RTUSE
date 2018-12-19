package OOPPractice.Prac2;

public class TestAuthor {
    public static void main(String[] args) {
        testAuthorInit();
        testAuthorGenders();
        testAuthorToString();

        System.out.println("Work");
    }

    private static void doAssert(boolean stat) {
        if (!stat)
            throw new AssertionError("Assertion is wrong");
    }

    private static void testAuthorInit() {
        Author author = new Author("iNa Hook", "t.me/iNaHook", 'M');

        doAssert(author.getMail().equals("t.me/iNaHook"));
        doAssert(author.getName().equals("iNa Hook"));
        doAssert(author.getSex() == 'M');
    }

    private static void testAuthorGenders() {
        Author author1 = new Author("a1", "a1", 'M');
        Author author2 = new Author("a2", "a2", 'F');
        Author author3 = new Author("a3", "a3", 'U');
    }

    private static void testAuthorToString() {
        Author author = new Author("iNa Hook", "t.me/iNaHook", 'M');

        doAssert(author.toString().equals("Name: iNa Hook is M gender. Meet via t.me/iNaHook"));
    }
}
