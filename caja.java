public class Caja<T extends Comparable<T>> {
    private Object[] elementos;
    private int cantidad;

    // Crea una caja con la capacidad fija indicada
    public Caja(int capacidad) {
        this.elementos = new Object[capacidad];
        this.cantidad = 0;
    }

    // Agrega un elemento; si la caja esta llena lanza excepcion
    public void agregar(T elemento) {
        if (cantidad == elementos.length) {
            throw new IllegalStateException(
                "La caja esta llena (capacidad maxima: " + elementos.length + ")");
        }
        elementos[cantidad] = elemento;
        cantidad++;
    }

    // Devuelve el elemento mayor; si la caja esta vacia lanza excepcion
    public T obtenerMayor() {
        validarNoVacia();
        T mayor = obtener(0);
        for (int i = 1; i < cantidad; i++) {
            if (obtener(i).compareTo(mayor) > 0) {
                mayor = obtener(i);
            }
        }
        return mayor;
    }

    // Devuelve el elemento menor; si la caja esta vacia lanza excepcion
    public T obtenerMenor() {
        validarNoVacia();
        T menor = obtener(0);
        for (int i = 1; i < cantidad; i++) {
            if (obtener(i).compareTo(menor) < 0) {
                menor = obtener(i);
            }
        }
        return menor;
    }

    private void validarNoVacia() {
        if (cantidad == 0) {
            throw new IllegalStateException("La caja esta vacia, no hay elementos que comparar");
        }
    }

    @SuppressWarnings("unchecked")
    private T obtener(int i) {
        return (T) elementos[i];
    }
}