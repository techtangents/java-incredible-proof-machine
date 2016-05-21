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
        return e.fold(V::absurd, a -> a);
    }

    public static <A> Void e5(final Pair<Void, A> p) {
        return p.x;
    }

    public static <A> F<Void, A> e6() {
        return V::absurd;
    }

    public static <A, B> Pair<F<A, Void>, F<B, Void>> e8(final F<Either<A, B>, Void> f) {
        return Pair.p(a -> f.apply(Either.x(a)), b -> f.apply(Either.y(b)));
    }

    public static <A, B> F<F<B, Void>, F<A, Void>> e7(final F<A, B> f) {
        return bVoidF -> a -> absurd(bVoidF.apply(f.apply(a)));
    }

    public static <A, B> F<Either<A, B>, Void> e9(final Pair<F<A, Void>, F<B, Void>> p) {
        return abEither -> abEither.fold(p.x, p.y);
    }

    public static <A, B> F<Pair<A, B>, Void> e10(final Either<F<A, Void>, F<B, Void>> e) {
        return abPair -> e.fold(aVoidF -> aVoidF.apply(abPair.x), bVoidF -> bVoidF.apply(abPair.y));
    }

    public static <A> F<A, Void> e11(final F<F<F<A, Void>, Void>, Void> f) {
        return a -> f.apply(aVoidF -> aVoidF.apply(a));
    }

    public static <A, B> F<A, B> e12(final Either<F<A, Void>, B> e) {
        return a -> e.fold(aVoidF -> absurd(aVoidF.apply(a)), b -> b);
    }

    public static <A, B> F<B, Void> e13(final F<A, Void> fav, final F<B, Void> fbv) {
        return fbv;
    }

    public static <A, B, C> F<Pair<Pair<A, B>, C>, Void> e14(final Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>> e) {
        return p -> e.fold(ffEither -> ffEither.fold(aVoidF -> aVoidF.apply(p.x.x), bVoidF -> bVoidF.apply(p.x.y)), cVoidF -> cVoidF.apply(p.y));
    }
}