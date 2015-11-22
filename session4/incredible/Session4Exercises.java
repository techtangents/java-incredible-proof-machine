package incredible;

public final class Session4Exercises {

    private static UnsupportedOperationException todo() {
        return new UnsupportedOperationException();
    }

    private Session4Exercises() {
    }

    // TIP: Use V.<A>absurd(v) to convert Void to any other type

    public static <A> A e1(final Void v) {
        throw todo();
    }

    public static <A> A e2a(final Void v) {
        throw todo();
    }

    public static <B> B e2b(final Void v) {
        throw todo();
    }

    public static <A> Either<Void, A> e3(final A a) {
        throw todo();
    }

    public static <A> A e4(final Either<Void, A> e) {
        throw todo();
    }

    public static <A> Void e5(final Pair<Void, A> p) {
        throw todo();
    }

    public static <A> F<Void, A> e6() {
        throw todo();
    }

    public static <A, B> Pair<F<A, Void>, F<B, Void>> e8(final F<Either<A, B>, Void> f) {
        throw todo();
    }

    public static <A, B> F<F<B, Void>, F<A, Void>> e7(final F<A, B> f) {
        throw todo();
    }

    public static <A, B> F<Either<A, B>, Void> e9(final Pair<F<A, Void>, F<B, Void>> p) {
        throw todo();
    }

    public static <A, B> F<Pair<A, B>, Void> e10(final Either<F<A, Void>, F<B, Void>> e) {
        throw todo();
    }

    public static <A> F<A, Void> e11(final F<F<F<A, Void>, Void>, Void> f) {
        throw todo();
    }

    public static <A, B> F<A, B> e12(final Either<F<A, Void>, B> e) {
        throw todo();
    }

    public static <A, B> F<B, Void> e13(final F<A, Void> fav, final F<B, Void> fbv) {
        throw todo();
    }

    public static <A, B, C> F<Pair<Pair<A, B>, C>, Void> e14(final Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>> e) {
        throw todo();
    }
}