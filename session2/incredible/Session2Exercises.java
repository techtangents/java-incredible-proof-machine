package incredible;

import static incredible.Pair.p;

public final class Session2Exercises {

    private static UnsupportedOperationException todo() {
        return new UnsupportedOperationException();
    }

    private Session2Exercises() {
    }

    public static <A, B> B e1(final A a, final F<A, B> f) {
        return f.apply(a);
    }

    public static <A> A e2(final A a, final F<A, A> f) {
        return f.apply(a);
    }

    public static <A, B, C> C e3(final A a, final F<A, B> fab, final F<B, C> fbc) {
        return fbc.apply(fab.apply(a));
    }

    public static <A, B, C, D> D e4(final A a, final F<A, B> fab, final F<A, C> fac, final F<C, D> fcd, final F<B, D> fbd) {
        return fbd.apply(fab.apply(a));
    }

    public static <A, B, C> F<Pair<A, B>, C> e5(final F<A, C> fac, final F<B, C> fbc) {
        return new F<Pair<A, B>, C>() {
            @Override
            public C apply(final Pair<A, B> abPair) {
                return fac.apply(abPair.x);
            }
        };
    }

    public static <A, B, C> F<A, C> e6(final F<A, B> fab, final F<A, F<B, C>> fafbc) {
        return new F<A, C>() {
            @Override
            public C apply(final A a) {
                return fafbc.apply(a).apply(fab.apply(a));
            }
        };
    }

    public static <A, B> F<A, B> e7(final B b) {
        return new F<A, B>() {
            @Override
            public B apply(final A a) {
                return b;
            }
        };
    }

    public static <A, B, C> F<B, C> e8(final Pair<F<A, B>, F<B, A>> p, final F<A, C> fac) {
        return new F<B, C>() {
            @Override
            public C apply(final B b) {
                return fac.apply(p.y.apply(b));
            }
        };
    }

    public static <A, B, C> F<A, F<B, C>> e9(final F<Pair<A, B>, C> f) {
        return new F<A, F<B, C>>() {
            @Override
            public F<B, C> apply(final A a) {
                return new F<B, C>() {
                    @Override
                    public C apply(final B b) {
                        return f.apply(p(a, b));
                    }
                };
            }
        };
    }

    public static <A, B, C> F<Pair<A, B>, C> e10(final F<A, F<B, C>> f) {
        return new F<Pair<A, B>, C>() {
            @Override
            public C apply(final Pair<A, B> p) {
                return f.apply(p.x).apply(p.y);
            }
        };
    }

    public static <A, B, C> F<A, Pair<B, C>> e11(final Pair<F<A, B>, F<A, C>> p) {
        return new F<A, Pair<B, C>>() {
            @Override
            public Pair<B, C> apply(final A a) {
                return p(p.x.apply(a), p.y.apply(a));
            }
        };
    }
}