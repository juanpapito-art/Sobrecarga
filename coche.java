package claseoverloading;

public class Coche {
    
    private String color;
    private int velocidad;
    private float tamaño;
    private int distanciaRecorrida;
    private double combustible;
    private int temperatura; // NUEVO: Temperatura del motor (°C)
    
    public Coche(String color, int velocidad, float tamaño) {
        this.color = color;
        this.velocidad = velocidad;
        this.tamaño = tamaño;
        this.distanciaRecorrida = 0;
        this.combustible = 100.0;
        this.temperatura = 20; // NUEVO: Temperatura ambiente inicial
    }
    
    // Sobrecarga 1: avanzar distancia por defecto (10m)
    public void avanzar() {
        avanzar(10);
    }
    
    // Sobrecarga 2: avanzar con metros específicos
    public void avanzar(int metros) {
        avanzar(metros, velocidad);
    }
    
    // Sobrecarga 3: avanzar con metros y velocidad personalizada
    public void avanzar(int metros, int velocidadActual) {
        double consumo = metros * 0.5;
        
        if (combustible >= consumo) {
            distanciaRecorrida += metros;
            combustible -= consumo;
            
            // NUEVO: Aumentar temperatura según velocidad y distancia
            int incrementoTemp = (int)((velocidadActual / 10) + (metros / 20));
            temperatura += incrementoTemp;
            
            // Limitar temperatura máxima a 120°C
            if (temperatura > 120) {
                temperatura = 120;
            }
            
            System.out.println("Coche " + color + " avanzó " + metros + "m a " + 
                             velocidadActual + " km/h (Combustible: " + 
                             String.format("%.1f", combustible) + "%)");
            
            // NUEVO: Mostrar estado de temperatura
            mostrarTemperatura();
            
            // NUEVO: Advertencia de sobrecalentamiento
            if (temperatura >= 100) {
                System.out.println("⚠️ ¡ADVERTENCIA! Motor sobrecalentado - Riesgo de daño");
            }
        } else {
            System.out.println("Coche " + color + " se quedó sin combustible!");
        }
    }
    
    // NUEVO MÉTODO: Mostrar estado de temperatura
    public void mostrarTemperatura() {
        String estado;
        
        if (temperatura >= 100) {
            estado = "🔥 CRÍTICO";
        } else if (temperatura >= 80) {
            estado = "🌡️ CALIENTE";
        } else if (temperatura >= 60) {
            estado = "☀️ TEMPLADO";
        } else {
            estado = "❄️ NORMAL";
        }
        
        System.out.println("   └─ Temperatura motor: " + temperatura + "°C " + estado);
    }
    
    public void parar() {
        // NUEVO: Enfriar motor al parar
        int enfriamiento = 15;
        temperatura -= enfriamiento;
        
        if (temperatura < 20) {
            temperatura = 20; // Temperatura mínima ambiente
        }
        
        System.out.println("Coche " + color + " se detuvo");
        System.out.println("   └─ Motor enfriándose... -" + enfriamiento + "°C");
        mostrarTemperatura();
    }
    
    public void girarIzquierda() {
        System.out.println("⬅️ Coche " + color + " giró a la izquierda");
    }
    
    public void girarDerecha() {
        System.out.println("➡️ Coche " + color + " giró a la derecha");
    }
    
    public void repostar() {
        combustible = 100.0;
        System.out.println("Coche " + color + " repostado al 100%");
        
        // NUEVO: Aprovechar para enfriar motor durante repostaje
        temperatura = 30;
        System.out.println("   └─ Motor enfriado durante el repostaje (30°C)");
    }
    
    // Getters
    public String getColor() { return color; }
    public int getDistanciaRecorrida() { return distanciaRecorrida; }
    public double getCombustible() { return combustible; }
    public int getTemperatura() { return temperatura; } // NUEVO
}
