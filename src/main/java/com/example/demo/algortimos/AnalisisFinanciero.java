package com.example.demo.algortimos;

public class AnalisisFinanciero {

    // Clase para empaquetar el resultado completo
    public static class ResultadoRacha {
        public int sumaMaxima;
        public int indiceInicio;
        public int indiceFin;

        public ResultadoRacha(int sumaMaxima, int indiceInicio, int indiceFin) {
            this.sumaMaxima = sumaMaxima;
            this.indiceInicio = indiceInicio;
            this.indiceFin = indiceFin;
        }
    }

    public static ResultadoRacha encontrarMejorPeriodo(int[] fluctuacionesDiarias) {
        // Casos base: arreglo vacío
        if (fluctuacionesDiarias == null || fluctuacionesDiarias.length == 0) {
            return new ResultadoRacha(0, -1, -1);
        }

        int maximoActual = fluctuacionesDiarias[0];
        int maximoGlobal = fluctuacionesDiarias[0];

        int inicioGlobal = 0;
        int finGlobal = 0;
        int inicioTemporal = 0; // Rastrea dónde empieza el subarreglo actual

        for (int i = 1; i < fluctuacionesDiarias.length; i++) {
            int gananciaHoy = fluctuacionesDiarias[i];

            // ¿Es mejor arrastrar la racha anterior o empezar de cero hoy?
            if (gananciaHoy > maximoActual + gananciaHoy) {
                maximoActual = gananciaHoy;
                inicioTemporal = i; // Marcamos que una nueva racha potencial empieza hoy
            } else {
                maximoActual = maximoActual + gananciaHoy;
            }

            // ¿Esta racha actual superó nuestro récord histórico?
            if (maximoActual > maximoGlobal) {
                maximoGlobal = maximoActual;
                inicioGlobal = inicioTemporal; // Confirmamos el inicio oficial de la mejor racha
                finGlobal = i;                // El fin oficial es el día de hoy
            }
        }

        return new ResultadoRacha(maximoGlobal, inicioGlobal, finGlobal);
    }

    // Método principal para probar el escenario financiero
    public static void main(String[] args) {
        // Ejemplo: Ganancias y pérdidas diarias de una acción en 9 días
        // Día 0: Perdió $2, Día 1: Ganó $1, Día 2: Perdió $3, Día 3: Ganó $4, etc.
        int[] rendimientoAccion = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        ResultadoRacha racha = encontrarMejorPeriodo(rendimientoAccion);

        System.out.println("=== REPORTE DE RENDIMIENTO ===");
        System.out.println("Máxima ganancia acumulada obtenida: $" + racha.sumaMaxima);
        System.out.println("La mejor racha continua comenzó en el Día: " + racha.indiceInicio);
        System.out.println("La mejor racha continua terminó en el Día: " + racha.indiceFin);

        // Mostrar los elementos que componen la racha
        System.out.print("Días que componen la racha: [");
        for (int i = racha.indiceInicio; i <= racha.indiceFin; i++) {
            System.out.print(rendimientoAccion[i] + (i == racha.indiceFin ? "" : ", "));
        }
        System.out.println("]");
    }
}
