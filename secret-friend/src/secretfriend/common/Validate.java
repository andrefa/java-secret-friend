package secretfriend.common;

/**
 * Utilit�rios para realizar verifica��es em tempo de execu��o.
 * 
 */
public final class Validate {

    /**
     * 
     */
    private Validate() {
        // Somente m�todos utilit�rios.
    }

    /**
     * Verifica que uma refer�ncia n�o � <tt>null</tt>.
     * 
     * @param <T> tipo da refer�ncia.
     * @param instance refer�ncia.
     * @return a refer�ncia.
     */
    public static final <T> T notNull(final T instance) {
        return notNull(instance, null);
    }

    /**
     * Verifica que uma refer�ncia n�o � <tt>null</tt>.
     * 
     * @param <T> tipo da refer�ncia.
     * @param instance refer�ncia.
     * @param errorMessage mensagem de erro caso a refer�ncia seja <tt>null</tt>.
     * @return a refer�ncia.
     */
    public static final <T> T notNull(final T instance, final String errorMessage) {
        if (instance == null) {
            throw new IllegalArgumentException(errorMessage);
        }
        return instance;
    }

    /**
     * Verifica se uma refer�ncia � nula.
     * 
     * @param <T> tipo da refer�ncia.
     * @param instance refer�ncia.
     * @return {@code true} se for nula, caso contr�rio {@code false}.
     */
    public static <T> boolean isNull(final T instance) {
        return instance == null;
    }
    
    /**
     * Verifica se uma refer�ncia n�o � nula.
     * 
     * @param <T> tipo da refer�ncia.
     * @param instance refer�ncia.
     * @return {@code true} se n�o for nula, caso contr�rio {@code false}.
     */
    public static <T> boolean isNotNull(final T instance) {
        return instance != null;
    }

}