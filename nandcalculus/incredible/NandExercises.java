package incredible;

@SuppressWarnings({"unused", "NewExceptionWithoutArguments"})
public final class NandExercises {

    private NandExercises() {
    }

    private static UnsupportedOperationException todo() {
        return new UnsupportedOperationException();
    }

    public static <A, B> N<B, A> e1(final N<A, B> n) {
        throw todo();
    }

    public static <A> N<N<A, A>, N<A, A>> e1(final A a) {
        throw todo();
    }

    public static <A> N<N<A, A>, A> e3() {
        throw todo();
    }

    public static <A> A e4(final N<N<A, A>, N<A, A>> n) {
        throw todo();
    }

    public static <A, B> N<N<A, B>, N<A, B>> e5(final A a, final B b) {
        throw todo();
    }

    public static <A, B> A e6a(final N<N<A, B>, N<A, B>> n) {
        throw todo();
    }

    public static <A, B> B e6b(final N<N<A, B>, N<A, B>> n) {
        throw todo();
    }


}
