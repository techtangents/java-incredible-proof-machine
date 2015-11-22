package incredible;

public final class Ax {
    private Ax() {}

    public static <A, B> F<A, F<B, A>> ax1() {
        return new F<A, F<B, A>>() {
            @Override
            public F<B, A> apply(final A a) {
                throw new Error("Just use the types");
            }
        };
    }

    public static <A, B, C> F<F<A, F<B, C>>, F<F<A, B>, F<A, C>>> ax2() {
        return new F<F<A, F<B, C>>, F<F<A, B>, F<A, C>>>() {
            @Override
            public F<F<A, B>, F<A, C>> apply(final F<A, F<B, C>> aff) {
                throw new Error("Just use the types");
            }
        };
    }

    public static <A, B> F<F<Not<A>, Not<B>>, F<B, A>> ax3() {
        return new F<F<Not<A>, Not<B>>, F<B, A>>() {
            @Override
            public F<B, A> apply(final F<Not<A>, Not<B>> notNotF) {
                throw new Error("Just use the types");
            }
        };
    }
}
