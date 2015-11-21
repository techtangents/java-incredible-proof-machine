package incredible;

@SuppressWarnings({"unused", "NewExceptionWithoutArguments"})
public class Session3 {

    private static UnsupportedOperationException todo() {
        return new UnsupportedOperationException();
    }

    private Session3() {
    }

    public static <A, B> Either<A, B> e1(final A a, final B b) {
        throw todo();
    }


}