package incredible;

public abstract class Either<X, Y> {

    public abstract <T> T fold(final F<X, T> af, final F<Y, T> bf);

    public static <X, Y> Either<X, Y> a(final X x) {
        return new Either<X, Y>() {
            @Override
            public <T> T fold(final F<X, T> af, final F<Y, T> bf) {
                return af.apply(x);
            }
        };
    }

    public static <X, Y> Either<X, Y> b(final Y y) {
        return new Either<X, Y>() {
            @Override
            public <T> T fold(final F<X, T> xf, final F<Y, T> yf) {
                return yf.apply(y);
            }
        };
    }
}
