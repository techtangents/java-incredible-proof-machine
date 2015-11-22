package incredible;

public final class TND {
    private TND() {
    }

    /**
     * The TND block.
     * The returned value shouldn't actually be called in real code,
     * just referred to in types.
     * @param <P>
     * @return
     */
    public static <P> Either<P, F<P, Void>> tnd() {
        return Either.bottom();
    }
}
