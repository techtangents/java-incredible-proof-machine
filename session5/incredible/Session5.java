package incredible;

@SuppressWarnings({"unused", "NewExceptionWithoutArguments"})
public final class Session5 {

    private static UnsupportedOperationException todo() {
        return new UnsupportedOperationException();
    }

    private Session5() {
    }

    // TIP: Use V.<A>absurd(v) to convert Void to any other type
    // TIP: Use TND.<A>tnd() to get the TND block

    public static <A> Either<A, F<A, Void>> e1() {
        throw todo();
    }

    public static <A, B> F<A, B> e2(final F<F<B, Void>, F<A, Void>> f) {
        throw todo();
    }

    public static <A, B> Either<F<A, Void>, F<B, Void>> e3(final F<Pair<A, B>, Void> f) {
        throw todo();
    }

    public static <A> A e4(final F<F<A, Void>, Void> f) {
        throw todo();
    }

    public static <A, B> Either<F<A, Void>, B> e5(final F<A, B> f) {
        throw todo();
    }

    public static <A, B, C> Either<F<A, Void>, C> e6(final F<A, B> fab, final F<B, C> fbc) {
        throw todo();
    }

    public static <A, B, C> Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>> e7(final F<Pair<Pair<A, B>, C>, Void> f) {
        throw todo();
    }

    public static <A, B> Pair<A, F<B, Void>> e8(final F<F<A, B>, Void> f) {
        throw todo();
    }

}