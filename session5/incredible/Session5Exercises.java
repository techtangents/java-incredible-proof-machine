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
        return TND.<A>tnd().fold(Either::x, Either::y);
    }

    public static <A, B> F<A, B> e2(final F<F<B, Void>, F<A, Void>> f) {
        return a -> TND.<B>tnd().fold(b -> b, bVoidF -> absurd(f.apply(bVoidF).apply(a)));
    }

    public static <A, B> Either<F<A, Void>, F<B, Void>> e3(final F<Pair<A, B>, Void> f) {
        return TND.<A>tnd().fold(a -> TND.<B>tnd().fold(b -> absurd(f.apply(p(a, b))), Either::y), aVoidF -> TND.<B>tnd().fold(b -> Either.x(aVoidF), Either::y));
    }

    public static <A> A e4(final F<F<A, Void>, Void> f) {
        return TND.<A>tnd().fold(a -> a, aVoidF -> absurd(f.apply(aVoidF)));
    }

    public static <A, B> Either<F<A, Void>, B> e5(final F<A, B> f) {
        return TND.<A>tnd().fold(a -> Either.y(f.apply(a)), Either::x);
    }

    public static <A, B, C> Either<F<A, Void>, C> e6(final F<A, B> fab, final F<B, C> fbc) {
        return TND.<A>tnd().fold(a -> Either.y(fbc.apply(fab.apply(a))), Either::x);
    }

    public static <A, B, C> Either<Either<F<A, Void>, F<B, Void>>, F<C, Void>> e7(final F<Pair<Pair<A, B>, C>, Void> f) {
        return TND.<A>tnd().fold(a -> TND.<B>tnd().fold(b -> TND.<C>tnd().fold(c -> absurd(f.apply(p(p(a, b), c))), Either::y), bVoidF -> Either.x(Either.y(bVoidF))), aVoidF -> Either.x(Either.x(aVoidF)));
    }

    public static <A, B> Pair<A, F<B, Void>> e8(final F<F<A, B>, Void> f) {
        return TND.<A>tnd().fold(a -> TND.<B>tnd().fold(b -> p(a, b1 -> f.apply(a1 -> b1)), bVoidF -> p(a, bVoidF)), aVoidF -> absurd(f.apply(a -> absurd(aVoidF.apply(a)))));
    }
}