package secretfriend.common;

/**
 * Utilitários para realizar verificações em tempo de execução.
 * 
 */
public final class Validate {

    /**
     * 
     */
    private Validate() {
        // Somente métodos utilitários.
    }

    /**
     * Verifica que uma referência não é <tt>null</tt>.
     * 
     * @param <T> tipo da referência.
     * @param instance referência.
     * @return a referência.
     */
    public static final <T> T notNull(final T instance) {
        return notNull(instance, null);
    }

    /**
     * Verifica que uma referência não é <tt>null</tt>.
     * 
     * @param <T> tipo da referência.
     * @param instance referência.
     * @param errorMessage mensagem de erro caso a referência seja <tt>null</tt>.
     * @return a referência.
     */
    public static final <T> T notNull(final T instance, final String errorMessage) {
        if (instance == null) {
            throw new IllegalArgumentException(errorMessage);
        }
        return instance;
    }

    /**
     * Verifica se uma referência é nula.
     * 
     * @param <T> tipo da referência.
     * @param instance referência.
     * @return {@code true} se for nula, caso contrário {@code false}.
     */
    public static <T> boolean isNull(final T instance) {
        return instance == null;
    }
    
    /**
     * Verifica se uma referência não é nula.
     * 
     * @param <T> tipo da referência.
     * @param instance referência.
     * @return {@code true} se não for nula, caso contrário {@code false}.
     */
    public static <T> boolean isNotNull(final T instance) {
        return instance != null;
    }

}