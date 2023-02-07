import java.util.Scanner;

interface Despegar {
    public void despegar();
}

interface Aterrizar {
    public void aterrizar();
}

abstract class NaveEspacial {
    String propulsion;
    boolean tripulacion;
    int velocidad_maxima;

    public NaveEspacial(String propulsion, boolean tripulacion, int velocidad_maxima) {
        this.propulsion = propulsion;
        this.tripulacion = tripulacion;
        this.velocidad_maxima = velocidad_maxima;
    }
}

class NaveComercial extends NaveEspacial implements Despegar, Aterrizar {
    public NaveComercial(String propulsion, boolean tripulacion, int velocidad) {
        super(propulsion, tripulacion, velocidad);
    }

    @Override
    public void despegar() {
        System.out.println("La nave comercial ha despegado con éxito utilizando propulsión "+propulsion);
    }

    @Override
    public void aterrizar() {
        System.out.println("La nave comercial ha aterrizado con éxito en una plataforma comercial.");
    }
}

class NaveDeCombate extends NaveEspacial implements Despegar, Aterrizar {
    public NaveDeCombate(String propulsion, boolean tripulacion, int velocidad) {
        super(propulsion, tripulacion, velocidad);
    }

    @Override
    public void despegar() {
        System.out.println("La nave de combate ha despegado con éxito utilizando propulsión  "+propulsion);
    }

    @Override
    public void aterrizar() {
        System.out.println("La nave de combate ha aterrizado con éxito en una base militar.");
    }
}

class NaveExploradora extends NaveEspacial implements Despegar, Aterrizar {
    public NaveExploradora(String propulsion, boolean tripulacion, int velocidad) {
        super(propulsion, tripulacion, velocidad);
    }

    @Override
    public void despegar() {
        System.out.println("La nave exploradora ha despegado con éxito utilizando propulsión  "+propulsion);
    }

    @Override
    public void aterrizar() {
        System.out.println("La nave exploradora ha aterrizado con éxito en un planeta desconocido.");
    }
}

class NaveDeTransporte extends NaveEspacial implements Despegar, Aterrizar {
    public NaveDeTransporte(String propulsion, boolean tripulacion, int velocidad) {
        super(propulsion, tripulacion, velocidad);
    }

    @Override
    public void despegar() {
        System.out.println("La nave de transporte ha despegado con éxito utilizando propulsión "+propulsion);
    }

    @Override
    public void aterrizar() {
        System.out.println("La nave de transporte ha aterrizado con éxito en un planeta desconocido.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el tipo de nave (Comercial, Combate, Exploradora, Transporte): ");
        String tipoNave = sc.nextLine();
        
        System.out.print("Ingrese la propulsión: ");
        String propulsion = sc.nextLine();
        
        System.out.print("¿Hay tripulación? (Sí/No): ");
        boolean tripulacion = sc.nextLine().equalsIgnoreCase("Sí");
        
        System.out.print("Ingrese la velocidad: ");
        int velocidad = sc.nextInt();
        
        
        NaveEspacial nave = null;
        switch (tipoNave.toLowerCase()) {
            case "comercial":
                nave = new NaveComercial(propulsion,tripulacion,velocidad);
                break;
            case "combate":
                nave = new NaveDeCombate(propulsion,tripulacion,velocidad);
                break;
            case "exploradora":
                nave = new NaveExploradora(propulsion,tripulacion,velocidad);
                break;
            case "transporte":
                nave = new NaveDeTransporte(propulsion,tripulacion,velocidad);
                break;
            default:
                System.out.println("Tipo de nave no válido");
                break;
        }
        if(nave != null){
            ((Despegar) nave).despegar();
            ((Aterrizar) nave).aterrizar();
        }
    }
}



