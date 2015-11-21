package incredible;

public abstract class Either<A, B> {

    public abstract <T> T fold(final F<A, T> af, final F<B, T> bf);

    public static <A, B> Either<A, B> a(final A a) {
        return new Either<A, B>() {
            @Override
            public <T> T fold(final F<A, T> af, final F<B, T> bf) {
                return af.apply(a);
            }
        };
    }

    public static <A, B> Either<A, B> b(final B b) {
        return new Either<A, B>() {
            @Override
            public <T> T fold(final F<A, T> af, final F<B, T> bf) {
                return bf.apply(b);
            }
        };
    }
}
