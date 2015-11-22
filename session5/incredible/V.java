package incredible;

public final class V {

    private V(){}

    /** ⊥ → A */
    public static <A> A absurd(final Void v) {
        throw new Error("impossible");
    }
}
