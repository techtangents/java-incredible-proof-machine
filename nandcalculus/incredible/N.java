package incredible;

/** type-level Nand */
public final class N<A, B> {

    private N() {}

    public static <A, B> N<A, B> nandI1(final F<A, N<B, B>> f) {
        return new N<A, B>();
    }

    public static <A, B> N<B, B> nandE1(final A a, final N<B, A> n) {
        return new N<B, B>();
    }

    public static <A, B> B nandE2(final A a, final N<N<B, B>, A> n) {
        throw new Error("Just use the types");
    }
}
