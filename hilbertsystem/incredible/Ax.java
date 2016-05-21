package incredible;

public final class Ax {
    private Ax() {}

    public static <A, B> F<A, F<B, A>> ax1() {
        throw new Error("Just use the types");
    }

    public static <A, B, C> F<F<A, F<B, C>>, F<F<A, B>, F<A, C>>> ax2() {
        throw new Error("Just use the types");
    }

    public static <A, B> F<F<Not<A>, Not<B>>, F<B, A>> ax3() {
        throw new Error("Just use the types");
    }
}
