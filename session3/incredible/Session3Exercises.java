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
        return eab.fold(Either::y, Either::x);
    }

    public static <A, B, C> Either<Either<A, B>, C> e6(final Either<A, Either<B, C>> e) {
        return e.fold(a -> Either.x(Either.<A, B>x(a)), bcEither -> bcEither.fold(b -> Either.x(Either.y(b)), Either::y));
    }

    public static <A, B> Either<A, B> e7(final Pair<A, B> p) {
        return Either.x(p.x);
//        return Either.y(p.y); // <-- this is also correct
    }

    public static <A, B, C> Pair<Either<A, C>, Either<B, C>> e8(final Either<Pair<A, B>, C> e) {
        return e.fold(abPair -> p(Either.x(abPair.x), Either.x(abPair.y)), c -> p(Either.y(c), Either.y(c)));
    }

    public static <A, B, C> Pair<F<A, C>, F<B, C>> e11(final F<Either<A, B>, C> f) {
        return p(a -> f.apply(Either.x(a)), b -> f.apply(Either.y(b)));
    }

    public static <A, B, C> F<A, Either<B, C>> e12(final Either<F<A, B>, F<A, C>> e) {
        return e.fold(abf -> a -> Either.x(abf.apply(a)), acf -> a -> Either.y(acf.apply(a)));
    }
}