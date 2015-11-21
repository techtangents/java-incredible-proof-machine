package incredible;

@SuppressWarnings({"unused", "NewExceptionWithoutArguments"})
public final class Session2 {

    private static UnsupportedOperationException todo() {
        return new UnsupportedOperationException();
    }

    private Session2() {
    }

    public static <A, B> B e1(final A a, final F<A, B> f) {
        throw todo();
    }

    public static <A> A e2(final A a, final F<A, A> f) {
        throw todo();
    }

    public static <A, B, C> C e3(final A a, final F<A, B> fab, final F<B, C> fbc) {
        throw todo();
    }

    public static <A, B, C, D> D e4(final A a, final F<A, B> fab, final F<A, C> fac, final F<C, D> fcd, final F<B, D> fbd) {
        throw todo();
    }

    public static <A, B, C> F<Pair<A, B>, C> e5(final F<A, C> fac, final F<B, C> fbc) {
        throw todo();
    }

    public static <A, B, C> F<A, C> e6(final F<A, B> fab, final F<A, F<B, C>> fafbc) {
        throw todo();
    }

    public static <A, B> F<A, B> e7(final B b) {
        throw todo();
    }

    public static <A, B, C> F<B, C> e8(final Pair<F<A, B>, F<B, A>> p, final F<A, C> fac) {
        throw todo();
    }

    public static <A, B, C> F<A, F<B, C>> e9(final F<Pair<A, B>, C> f) {
        throw todo();
    }

    public static <A, B, C> F<Pair<A, B>, C> e10(final F<A, F<B, C>> f) {
        throw todo();
    }

    public static <A, B, C> F<A, Pair<B, C>> e11(final Pair<F<A, B>, F<A, C>> p) {
        throw todo();
    }
}