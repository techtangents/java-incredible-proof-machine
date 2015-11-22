package incredible;

public final class Session1Exercises {

    private static UnsupportedOperationException todo() {
        return new UnsupportedOperationException();
    }

    private Session1Exercises() {
    }

    public static <A> A e1(final A a) {
        throw todo();
    }

    public static <A, B> A e2(final A a, final B b) {
        throw todo();
    }

    public static <A, B> B e3_1(final A a, final B b) {
        throw todo();
    }

    public static <A, B> A e3_2(final A a, final B b) {
        throw todo();
    }

    public static <A, B> Pair<A, B> e4(final A a, final B b) {
        throw todo();
    }

    public static <A> Pair<A, A> e5(final A a) {
        throw todo();
    }

    public static <A, B> A e6(final Pair<A, B> p) {
        throw todo();
    }

    public static <A, B> A e7_1(final Pair<A, B> p) {
        throw todo();
    }

    public static <A, B> B e7_2(final Pair<A, B> p) {
        throw todo();
    }

    public static <A, B> Pair<A, B> e8(final Pair<A, B> p) {
        throw todo();
    }

    public static <A, B> Pair<B, A> e9(final Pair<A, B> p) {
        throw todo();
    }

    public static <A, B, C> A e10_1(final Pair<Pair<A, B>, C> p) {
        throw todo();
    }

    public static <A, B, C> B e10_2(final Pair<Pair<A, B>, C> p) {
        throw todo();
    }

    public static <A, B, C> C e10_3(final Pair<Pair<A, B>, C> p) {
        throw todo();
    }

    public static <A, B, C> Pair<A, C> e11(final Pair<Pair<A,B>, C> p) {
        throw todo();
    }

    public static <A, B, C> Pair<A, Pair<B, C>> e12(final Pair<Pair<A, B>, C> p) {
        throw todo();
    }

}
