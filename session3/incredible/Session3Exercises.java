package incredible;

import static incredible.Pair.p;

public final class Session3Exercises {

    private static UnsupportedOperationException todo() {
        return new UnsupportedOperationException();
    }

    private Session3Exercises() {
    }

    public static <A, B> Either<A, B> e1(final A a, final B b) {
        return Either.x(a);
//        return Either.y(b);  // <-- this is also correct
    }

    public static <A, B> Either<A, B> e2(final A a) {
        return Either.x(a);
    }

    public static <A, B> Either<A, B> e3(final B b) {
        return Either.y(b);
    }

    public static <A> Either<A, A> e4(final A a) {
        return Either.x(a);
//        return Either.y(a); // <--- this is also correct
    }

    public static <A, B> Either<B, A> e5(final Either<A, B> eab) {
        return eab.fold(new F<A, Either<B, A>>() {
            @Override
            public Either<B, A> apply(final A a) {
                return Either.y(a);
            }
        }, new F<B, Either<B, A>>() {
            @Override
            public Either<B, A> apply(final B b) {
                return Either.x(b);
            }
        });
    }

    public static <A, B, C> Either<Either<A, B>, C> e6(final Either<A, Either<B, C>> e) {
        return e.fold(new F<A, Either<Either<A, B>, C>>() {
            @Override
            public Either<Either<A, B>, C> apply(final A a) {
                return Either.x(Either.<A, B>x(a));
            }
        }, new F<Either<B, C>, Either<Either<A, B>, C>>() {
            @Override
            public Either<Either<A, B>, C> apply(final Either<B, C> bcEither) {
                return bcEither.fold(new F<B, Either<Either<A, B>, C>>() {
                    @Override
                    public Either<Either<A, B>, C> apply(final B b) {
                        return Either.x(Either.<A, B>y(b));
                    }
                }, new F<C, Either<Either<A, B>, C>>() {
                    @Override
                    public Either<Either<A, B>, C> apply(final C c) {
                        return Either.y(c);
                    }
                });
            }
        });
    }

    public static <A, B> Either<A, B> e7(final Pair<A, B> p) {
        return Either.x(p.x);
//        return Either.y(p.y); // <-- this is also correct
    }

    public static <A, B, C> Pair<Either<A, C>, Either<B, C>> e8(final Either<Pair<A, B>, C> e) {
        return e.fold(new F<Pair<A, B>, Pair<Either<A, C>, Either<B, C>>>() {
            @Override
            public Pair<Either<A, C>, Either<B, C>> apply(final Pair<A, B> abPair) {
                return p(Either.<A, C>x(abPair.x), Either.<B, C>x(abPair.y));
            }
        }, new F<C, Pair<Either<A, C>, Either<B, C>>>() {
            @Override
            public Pair<Either<A, C>, Either<B, C>> apply(final C c) {
                return p(Either.<A, C>y(c), Either.<B, C>y(c));
            }
        });
    }

    public static <A, B, C> Pair<F<A, C>, F<B, C>> e11(final F<Either<A, B>, C> f) {
        return Pair.<F<A, C>, F<B, C>>p(new F<A, C>() {
            @Override
            public C apply(final A a) {
                return f.apply(Either.<A, B>x(a));
            }
        }, new F<B, C>() {
            @Override
            public C apply(final B b) {
                return f.apply(Either.<A, B>y(b));
            }
        });
    }

    public static <A, B, C> F<A, Either<B, C>> e12(final Either<F<A, B>, F<A, C>> e) {
        throw todo();
    }
}