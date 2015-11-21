package incredible;

@SuppressWarnings({"unused", "NewExceptionWithoutArguments"})
public final class Session3 {

    private static UnsupportedOperationException todo() {
        return new UnsupportedOperationException();
    }

    private Session3() {
    }

    public static <A, B> Either<A, B> e1(final A a, final B b) {
        throw todo();
    }

    public static <A, B> Either<A, B> e2(final A a) {
        throw todo();
    }

    public static <A, B> Either<A, B> e3(final B b) {
        throw todo();
    }

    public static <A> Either<A, A> e4(final A a) {
        throw todo();
    }

    public static <A, B> Either<B, A> e5(final Either<A, B> eab) {
        throw todo();
    }

    public static <A, B, C> Either<Either<A, B>, C> e6(final Either<A, Either<B, C>> e) {
        throw todo();
    }

    public static <A, B> Either<A, B> e7(final Pair<A, B> p) {
        throw todo();
    }

    public static <A, B, C> Pair<Either<A, C>, Either<B, C>> e8(final Either<Pair<A, B>, C> e) {
        throw todo();
    }

    public static <A, B, C> Pair<F<A, C>, F<B, C>> e11(final F<Either<A, B>, C> f) {
        throw todo();
    }

    public static <A, B, C> F<A, Either<B, C>> e12(final Either<F<A, B>, F<A, C>> e) {
        throw todo();
    }
}