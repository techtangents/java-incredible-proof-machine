package incredible;

import static incredible.Pair.p;

public final class Session1Exercises {

    private static UnsupportedOperationException todo() {
        return new UnsupportedOperationException();
    }

    private Session1Exercises() {
    }

    public static <A> A e1(final A a) {
        return a;
    }

    public static <A, B> A e2(final A a, final B b) {
        return a;
    }

    public static <A, B> B e3_1(final A a, final B b) {
        return b;
    }

    public static <A, B> A e3_2(final A a, final B b) {
        return a;
    }

    public static <A, B> Pair<A, B> e4(final A a, final B b) {
        return p(a, b);
    }

    public static <A> Pair<A, A> e5(final A a) {
        return p(a, a);
    }

    public static <A, B> A e6(final Pair<A, B> p) {
        return p.x;
    }

    public static <A, B> A e7_1(final Pair<A, B> p) {
        return p.x;
    }

    public static <A, B> B e7_2(final Pair<A, B> p) {
        return p.y;
    }

    public static <A, B> Pair<A, B> e8(final Pair<A, B> p) {
        return p;
    }

    public static <A, B> Pair<B, A> e9(final Pair<A, B> p) {
        return p(p.y, p.x);
    }

    public static <A, B, C> A e10_1(final Pair<Pair<A, B>, C> p) {
        throw todo();
    }

    public static <A, B, C> B e10_2(final Pair<Pair<A, B>, C> p) {
        return p.x.y;
    }

    public static <A, B, C> C e10_3(final Pair<Pair<A, B>, C> p) {
        return p.y;
    }

    public static <A, B, C> Pair<A, C> e11(final Pair<Pair<A,B>, C> p) {
        return p(p.x.x, p.y);
    }

    public static <A, B, C> Pair<A, Pair<B, C>> e12(final Pair<Pair<A, B>, C> p) {
        return p(p.x.x, p(p.x.y, p.y));
    }

}
