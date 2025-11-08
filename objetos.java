package claseoverloading;

public class Objetos {
    public static void main(String[] args) {
        System.out.println("SIMULADOR DE COCHES");
        
        // Crear los coches
        Coche miCoche = new Coche("verde", 80, 3.2f); 
        Coche tuCoche = new Coche("rojo", 120, 4.1f);
        Coche suCoche = new Coche("amarillo", 100, 3.4f);
        
        System.out.println("\nESCENA 1: Prueba de sobrecarga");
        
        miCoche.avanzar();
        miCoche.avanzar(50);
        miCoche.avanzar(30, 100);
        miCoche.girarDerecha();
        miCoche.parar();
        
        System.out.println("\nESCENA 2: Carrera corta");
        
        tuCoche.avanzar(80, 130);
        suCoche.avanzar(80, 110);
        miCoche.avanzar(80);
        
        tuCoche.avanzar(60, 140);
        suCoche.avanzar(60, 120);
        miCoche.avanzar(60, 90); 
        
        // NUEVO: Ver temperatura final de cada coche
        System.out.println("\n--- Estado de temperatura tras la carrera ---");
        System.out.print("Coche " + tuCoche.getColor() + ": ");
        tuCoche.mostrarTemperatura();
        System.out.print("Coche " + suCoche.getColor() + ": ");
        suCoche.mostrarTemperatura();
        System.out.print("Coche " + miCoche.getColor() + ": ");
        miCoche.mostrarTemperatura();
        
        System.out.println("\nRESULTADOS");
        System.out.println("Coche " + tuCoche.getColor() + ": " + 
                         tuCoche.getDistanciaRecorrida() + "m | Temp: " + 
                         tuCoche.getTemperatura() + "°C");
        System.out.println("Coche " + suCoche.getColor() + ": " + 
                         suCoche.getDistanciaRecorrida() + "m | Temp: " + 
                         suCoche.getTemperatura() + "°C");
        System.out.println("Coche " + miCoche.getColor() + ": " + 
                         miCoche.getDistanciaRecorrida() + "m | Temp: " + 
                         miCoche.getTemperatura() + "°C");
        
        System.out.println("\nRepostaje");
        
        miCoche.repostar();
        miCoche.avanzar(100, 120);
        miCoche.girarIzquierda();
        miCoche.avanzar(50);
        miCoche.parar();
        
        System.out.println("\nFIN");
    }
}
