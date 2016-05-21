package incredible;

import static incredible.V.absurd;

public final class Session4Exercises {

    private static UnsupportedOperationException todo() {
        return new UnsupportedOperationException();
    }

    private Session4Exercises() {
    }

    // TIP: Use V.<A>absurd(v) to convert Void to any other type

    public static <A> A e1(final Void v) {
        return absurd(v);
    }

    public static <A> A e2a(final Void v) {
        return absurd(v);
    }

    public static <B> B e2b(final Void v) {
        return absurd(v);
    }

    public static <A> Either<Void, A> e3(final A a) {
        return Either.y(a);
    }

    public static <A> A e4(final Either<Void, A> e) {
        return e.fold(new F<Void, A>() {
            @Override
            public A apply(final Void v) {
                return absurd(v);
            }
        }, new F<A, A>() {
            @Override
            public A apply(final A a) {
                return a;
            }
        });
    }

    public static <A> Void e5(final Pair<Void, A> p) {
        return p.x;
    }

    public static <A> F<Void, A> e6() {
        return new F<Void, A>() {
            @Override
            public A apply(final Void v) {
                return absurd(v);
            }
        };
    }

    public static <A, B> Pair<F<A, Void>, F<B, Void>> e8(final F<Either<A, B>, Void> f) {
        return Pair.<F<A, Void>, F<B, Void>>p(new F<A, Void>() {
            @Override
            public Void apply(final A a) {
                return f.apply(Either.<A, B>x(a));
            }
        }, new F<B, Void>() {
            @Override
            public Void apply(final B b) {
                return f.apply(Either.<A, B>y(b));
            }
        });
    }

    public static <A, B> F<F<B, Void>, F<A, Void>> e7(final F<A, B> f) {
        return new F<F<B, Void>, F<A, Void>>() {
            @Override
            public F<A, Void> apply(final F<B, Void> bVoidF) {
                return new F<A, Void>() {
                    @Override
                    public Void apply(final A a) {
                        return absurd(bVoidF.apply(f.apply(a)));
                    }
                };
            }
        };
    }

    public static <A, B> F<Either<A, B>, Void> e9(final Pair<F<A, Void>, F<B, Void>> p) {
        return new F<Either<A, B>, Void>() {
            @Override
            public Void apply(final Either<A, B> abEither) {
                return abEither.fold(new F<A, Void>() {
                    @Override
                    public Void apply(final A a) {
                        return p.x.apply(a);
                    }
                }, new F<B, Void>() {
                    @Override
                    public Void apply(final B b) {
                        return p.y.apply(b);
                    }
                });
            }
        };
    }

    public static <A, B> F<Pair<A, B>, Void> e10(final Either<F<A, Void>, F<B, Void>> e) {
        return new F<Pair<A, B>, Void>() {
            @Override
            public Void apply(final Pair<A, B> abPair) {
                return e.fold(new F<F<A, Void>, Void>() {
                    @Override
                    public Void apply(final F<A, Void> aVoidF) {
                        return aVoidF.apply(abPair.x);
                    }
                }, new F<F<B, Void>, Void>() {
                    @Override
                    public Void apply(final F<B, Void> bVoidF) {
                        return bVoidF.apply(abPair.y);
                    }
                });
            }
        };
    }

    public static <A> F<A, Void> e11(final F<F<F<A, Void>, Void>, Void> f) {
        return new F<A, Void>() {
            @Override
            public Void apply(final A a) {
                return f.apply(new F<F<A, Void>, Void>() {
                    @Override
                    public Void apply(final F<A, Void> aVoidF) {
                        return aVoidF.apply(a);
                    }
                });
            }
        };
    }

    public static <A, B> F<A, B> e12(final Either<F<A, Void>, B> e) {
        return new F<A, B>() {
            @Override
            public B apply(final A a) {
                return e.fold(new F<F<A, Void>, B>() {
                    @Override
                    public B apply(final F<A, Void> aVoidF) {
                        return absurd(aVoidF.apply(a));
                    }
                }, new F<B, B>() {
                    @Override
                    public B apply(final B b) {
                        return b;
                    }
                });
            }
        };
    }

    public static <A, B> F<B, Void> e13(final F<A, Void> fav, final F<B, Void> fbv) {
        return new F<B, Void>() {
            @Override
            public Void apply(final B b) {
                return fbv.apply(b);
            }
        };
    }

    public static <A, B, C> F<Pair<Pair<A, B>, C>, Void> e14(final Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>> e) {
        return new F<Pair<Pair<A, B>, C>, Void>() {
            @Override
            public Void apply(final Pair<Pair<A, B>, C> p) {
                return e.fold(new F<Either<F<A, Void>, F<B, Void>>, Void>() {
                    @Override
                    public Void apply(final Either<F<A, Void>, F<B, Void>> ffEither) {
                        return ffEither.fold(new F<F<A, Void>, Void>() {
                            @Override
                            public Void apply(final F<A, Void> aVoidF) {
                                return aVoidF.apply(p.x.x);
                            }
                        }, new F<F<B, Void>, Void>() {
                            @Override
                            public Void apply(final F<B, Void> bVoidF) {
                                return bVoidF.apply(p.x.y);
                            }
                        });
                    }
                }, new F<F<C, Void>, Void>() {
                    @Override
                    public Void apply(final F<C, Void> cVoidF) {
                        return cVoidF.apply(p.y);
                    }
                });
            }
        };
    }
}