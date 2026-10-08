public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Par<String, Integer>[] productos = new Par[4];
        productos[0] = new Par<>("Combustible", 500);
        productos[1] = new Par<>("Oxigeno", 300);
        productos[2] = new Par<>("Agua", 450);
        productos[3] = new Par<>("Repuestos", 120);

        Integer[] cantidades = new Integer[productos.length];
        for (int i = 0; i < productos.length; i++) {
            cantidades[i] = productos[i].getValor();
        }

        Integer maxCantidad = Utilidades.maximo(cantidades);

        Caja<Integer> caja = new Caja<>(productos.length);
        for (Integer c : cantidades) {
            caja.agregar(c);
        }
        System.out.println("Mayor en la caja: " + caja.obtenerMayor());
        System.out.println("Menor en la caja: " + caja.obtenerMenor());

        for (Par<String, Integer> p : productos) {
            if (p.getValor().equals(maxCantidad)) {
                System.out.println("Producto con mayor cantidad: " + p);
            }
        }

        Utilidades.intercambiar(cantidades, 0, 3);
        System.out.println("Veces que aparece 300: " + Utilidades.contar(cantidades, 300));
    }
}