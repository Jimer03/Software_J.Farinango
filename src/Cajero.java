

import java.util.Scanner;
public class Cajero {
    private static final String[] usuarios = {"1751370121", "0606316494", "1753811650", "1005462260"}; //Se registraron los usuarios
    private static final String[] claves = {"fernando", "samuel", "alexander", "bryan"}; //Se registraron las claves de acceso
    private static double saldo = 1000.0; //Se registró el saldo inicial del usuario
    private static String usuarioActual = "";  // Variable to store the current user

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion; //Declara la variable opción como entero.
        int salir = 1; //Declara la variable salir como entero, ademas iguala la variable a 1.

        /*En esta parte del código lo que nos esta diciendo es que se abrirá un menú donde se ingresará el usuario
        y la contraseña*/
        while (salir == 1) {
            // User authentication
            System.out.print("Ingrese su usuario: ");
            String usuario = scanner.next();
            System.out.print("Ingrese su contraseña: ");
            String clave = scanner.next();
            /* Aqui se procede A la autenticación del usuario para despues abrir un menu de opciones donde el usuario
            elegirá que hacer dentro del cajero
             */
            if (autenticarUsuario(usuario, clave)) {
                usuarioActual = usuario;
                do {
                    // Main menu
                    System.out.println("Simulador de Cajero Automático");
                    System.out.println("1. Consultar Saldo");
                    System.out.println("2. Retirar Dinero");
                    System.out.println("3. Depositar Dinero");
                    System.out.println("4. Transferir Dinero");
                    System.out.println("5. Salir");
                    System.out.print("Ingrese su opción: ");

                    opcion = scanner.nextInt();
                    /*En esta sección se muestran los casos que se realizarán dentro del menu ya antes mencionado*/
                    switch (opcion) {
                        case 1:
                            consultarSaldo();
                            break;
                        case 2:
                            retirarDinero();
                            break;
                        case 3:
                            depositarDinero();
                            break;
                        case 4:
                            transferirDinero();
                            break;
                        case 5:
                            System.out.println("Gracias por utilizar el simulador. ¡Hasta luego!");
                            salir = 0;  // Set salir to 0 to exit the main loop
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, elija nuevamente.");
                    }
                } while (opcion != 5);
            } else {
                // En esta parte muestra que si el usuario no realizo la operacion requerida imprimira un mensaje que diga vuelva a intentarlo
                System.out.println("Usuario o contraseña incorrectos. Inténtelo de nuevo.");
            }
        }
    }
    //Esta parte esta asignada a la consulta de saldo, donde imprimirá un mensaje donde se mostrará la cantidad de dinero dentro del cajero
    private static void consultarSaldo() {
        System.out.println("Su saldo actual es: $" + saldo);
    }
    // Esta función realizará la operación de retirar dinero
    private static void retirarDinero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad que desea retirar: $");
        double cantidad = scanner.nextDouble();

        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Su nuevo saldo es: $" + saldo);
        } else {
            System.out.println("Fondos insuficientes o cantidad no válida. Inténtelo de nuevo.");
        }
    }
    //Cumple la funco+ión de depositar dinero en la cuenta
    private static void depositarDinero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad que desea depositar: $");
        double cantidad = scanner.nextDouble();

        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Su nuevo saldo es: $" + saldo);
        } else {
            System.out.println("Cantidad no válida. Inténtelo de nuevo.");
        }
    }
        //Cumple la funcion de tranferir el dinero a otras cuentas
    private static void transferirDinero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cuenta de destino: ");
        String cuentaDestino = scanner.next();

        if (validarCuenta(cuentaDestino)) {
            System.out.print("Ingrese la cantidad que desea transferir: $");
            double cantidad = scanner.nextDouble();

            if (cantidad > 0 && cantidad <= saldo) {
                saldo -= cantidad;
                System.out.println("Transferencia exitosa. Su nuevo saldo es: $" + saldo);
            } else {
                System.out.println("Fondos insuficientes o cantidad no válida. Inténtelo de nuevo.");
            }
        } else {
            System.out.println("Cuenta de destino no válida. Inténtelo de nuevo.");
        }
    }
   //Aqui cumple la función de autenticar los usuarios y las contraseñas
    private static boolean autenticarUsuario(String usuario, String clave) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].equals(usuario) && claves[i].equals(clave)) {
                return true;
            }
        }
        return false;
    }
//Aui se validan las cuentas
    private static boolean validarCuenta(String cuenta) {
        for (String usuario : usuarios) {
            if (usuario.equals(cuenta)) {
                return true;
            }
        }
        return false;
    }
}