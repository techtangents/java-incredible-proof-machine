package incredible;

import static incredible.Pair.p;
import static incredible.V.absurd;

public final class Session5Exercises {

    private static UnsupportedOperationException todo() {
        return new UnsupportedOperationException();
    }

    private Session5Exercises() {
    }

    // TIP: Use V.<A>absurd(v) to convert Void to any other type
    // TIP: Use TND.<A>tnd() to get the TND block

    public static <A> Either<A, F<A, Void>> e1() {
        return TND.<A>tnd().fold(new F<A, Either<A, F<A, Void>>>() {
            @Override
            public Either<A, F<A, Void>> apply(final A a) {
                return Either.x(a);
            }
        }, new F<F<A, Void>, Either<A, F<A, Void>>>() {
            @Override
            public Either<A, F<A, Void>> apply(final F<A, Void> aVoidF) {
                return Either.y(aVoidF);
            }
        });
    }

    public static <A, B> F<A, B> e2(final F<F<B, Void>, F<A, Void>> f) {
        return new F<A, B>() {
            @Override
            public B apply(final A a) {
                return TND.<B>tnd().fold(new F<B, B>() {
                    @Override
                    public B apply(final B b) {
                        return b;
                    }
                }, new F<F<B, Void>, B>() {
                    @Override
                    public B apply(final F<B, Void> bVoidF) {
                        return absurd(f.apply(bVoidF).apply(a));
                    }
                });
            }
        };
    }

    public static <A, B> Either<F<A, Void>, F<B, Void>> e3(final F<Pair<A, B>, Void> f) {
        return TND.<A>tnd().fold(new F<A, Either<F<A, Void>, F<B, Void>>>() {
            @Override
            public Either<F<A, Void>, F<B, Void>> apply(final A a) {
                return TND.<B>tnd().fold(new F<B, Either<F<A, Void>, F<B, Void>>>() {
                    @Override
                    public Either<F<A, Void>, F<B, Void>> apply(final B b) {
                        return absurd(f.apply(p(a, b)));
                    }
                }, new F<F<B, Void>, Either<F<A, Void>, F<B, Void>>>() {
                    @Override
                    public Either<F<A, Void>, F<B, Void>> apply(final F<B, Void> bVoidF) {
                        return Either.y(bVoidF);
                    }
                });
            }
        }, new F<F<A, Void>, Either<F<A, Void>, F<B, Void>>>() {
            @Override
            public Either<F<A, Void>, F<B, Void>> apply(final F<A, Void> aVoidF) {
                return TND.<B>tnd().fold(new F<B, Either<F<A, Void>, F<B, Void>>>() {
                    @Override
                    public Either<F<A, Void>, F<B, Void>> apply(final B b) {
                        return Either.x(aVoidF);
                    }
                }, new F<F<B, Void>, Either<F<A, Void>, F<B, Void>>>() {
                    @Override
                    public Either<F<A, Void>, F<B, Void>> apply(final F<B, Void> bVoidF) {
                        return Either.y(bVoidF);
                    }
                });
            }
        });
    }

    public static <A> A e4(final F<F<A, Void>, Void> f) {
        return TND.<A>tnd().fold(new F<A, A>() {
            @Override
            public A apply(final A a) {
                return a;
            }
        }, new F<F<A, Void>, A>() {
            @Override
            public A apply(final F<A, Void> aVoidF) {
                return absurd(f.apply(aVoidF));
            }
        });
    }

    public static <A, B> Either<F<A, Void>, B> e5(final F<A, B> f) {
        return TND.<A>tnd().fold(new F<A, Either<F<A, Void>, B>>() {
            @Override
            public Either<F<A, Void>, B> apply(final A a) {
                return Either.y(f.apply(a));
            }
        }, new F<F<A, Void>, Either<F<A, Void>, B>>() {
            @Override
            public Either<F<A, Void>, B> apply(final F<A, Void> aVoidF) {
                return Either.x(aVoidF);
            }
        });
    }

    public static <A, B, C> Either<F<A, Void>, C> e6(final F<A, B> fab, final F<B, C> fbc) {
        return TND.<A>tnd().fold(new F<A, Either<F<A, Void>, C>>() {
            @Override
            public Either<F<A, Void>, C> apply(final A a) {
                return Either.y(fbc.apply(fab.apply(a)));
            }
        }, new F<F<A, Void>, Either<F<A, Void>, C>>() {
            @Override
            public Either<F<A, Void>, C> apply(final F<A, Void> aVoidF) {
                return Either.x(aVoidF);
            }
        });
    }

    public static <A, B, C> Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>> e7(final F<Pair<Pair<A, B>, C>, Void> f) {
        return TND.<A>tnd().fold(new F<A, Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>>>() {
            @Override
            public Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>> apply(final A a) {
                return TND.<B>tnd().fold(new F<B, Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>>>() {
                    @Override
                    public Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>> apply(final B b) {
                        return TND.<C>tnd().fold(new F<C, Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>>>() {
                            @Override
                            public Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>> apply(final C c) {
                                return absurd(f.apply(p(p(a, b), c)));
                            }
                        }, new F<F<C, Void>, Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>>>() {
                            @Override
                            public Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>> apply(final F<C, Void> cVoidF) {
                                return Either.y(cVoidF);
                            }
                        });
                    }
                }, new F<F<B, Void>, Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>>>() {
                    @Override
                    public Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>> apply(final F<B, Void> bVoidF) {
                        return Either.x(Either.<F<A, Void>, F<B, Void>>y(bVoidF));
                    }
                });
            }
        }, new F<F<A, Void>, Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>>>() {
            @Override
            public Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>> apply(final F<A, Void> aVoidF) {
                return Either.x(Either.<F<A, Void>, F<B, Void>>x(aVoidF));
            }
        });
    }

    public static <A, B> Pair<A, F<B, Void>> e8(final F<F<A, B>, Void> f) {
        return TND.<A>tnd().fold(new F<A, Pair<A, F<B, Void>>>() {
            @Override
            public Pair<A, F<B, Void>> apply(final A a) {
                return TND.<B>tnd().fold(new F<B, Pair<A, F<B, Void>>>() {
                    @Override
                    public Pair<A, F<B, Void>> apply(final B b) {
                        final F<B, Void> fbv = new F<B, Void>() {
                            @Override
                            public Void apply(final B b) {
                                return f.apply(new F<A, B>() {
                                    @Override
                                    public B apply(final A a) {
                                        return b;
                                    }
                                });
                            }
                        };
                        return p(a, fbv);
                    }
                }, new F<F<B, Void>, Pair<A, F<B, Void>>>() {
                    @Override
                    public Pair<A, F<B, Void>> apply(final F<B, Void> bVoidF) {
                        return p(a, bVoidF);
                    }
                });
            }
        }, new F<F<A, Void>, Pair<A, F<B, Void>>>() {
            @Override
            public Pair<A, F<B, Void>> apply(final F<A, Void> aVoidF) {
                return absurd(f.apply(new F<A, B>() {
                    @Override
                    public B apply(final A a) {
                        return absurd(aVoidF.apply(a));
                    }
                }));
            }
        });
    }
}