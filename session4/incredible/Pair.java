package incredible;

public final class Pair<X, Y> {
    public final X x;
    public final Y y;

    private Pair(final X x, final Y y) {
        this.x = x;
        this.y = y;
    }

    public static <X, Y> Pair<X, Y> p(final X x, final Y y) {
        return new Pair<X, Y>(x, y);
    }
}
