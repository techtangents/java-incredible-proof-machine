package incredible;

public abstract class Either<X, Y> {

    public abstract <T> T fold(final F<X, T> af, final F<Y, T> bf);

    public static <X, Y> Either<X, Y> x(final X x) {
        return new Either<X, Y>() {
            @Override
            public <T> T fold(final F<X, T> af, final F<Y, T> bf) {
                return af.apply(x);
            }
        };
    }

    public static <X, Y> Either<X, Y> y(final Y y) {
        return new Either<X, Y>() {
            @Override
            public <T> T fold(final F<X, T> xf, final F<Y, T> yf) {
                return yf.apply(y);
            }
        };
    }

    public static <X, Y> Either<X, Y> bottom() {
        return new Either<X, Y>() {
            @Override
            public <T> T fold(final F<X, T> af, final F<Y, T> bf) {
                throw new Error("Impossible");
            }
        };
    }
}
