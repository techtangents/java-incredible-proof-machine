package incredible;

public final class HilbertExercises {

    private HilbertExercises() {
    }

    private static UnsupportedOperationException todo() {
        return new UnsupportedOperationException();
    }

    public static <A> F<A, A> e1() {
        throw todo();
    }

    public static <A, B> F<Not<A>, F<A, B>> e2() {
        throw todo();
    }

    public static <A, B> F<F<A, B>, F<F<Not<A>, B>, B>> e3() {
        throw todo();
    }
}
