package paquete1;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cantidad, saldo_inicial, saldo;
        String nombre, apellido, dni;
        Cuenta cuentas[] = new Cuenta[10];
        boolean salir = false;
        int opcion, numero_cuenta = 0, contador_cuentas = 0;


        System.out.println("Introduce tus datos de cliente a continuacion: \nNombre");
        nombre = sc.nextLine();
        sc.nextLine();
        System.out.println("Introduce tus datos de cliente a continuacion: \nApellido");
        apellido = sc.nextLine();
        sc.nextLine();
        System.out.println("Introduce tus datos de cliente a continuacion: \nDNI");
        dni = sc.nextLine();
        sc.nextLine();


        System.out.println("Crea tu primera cuenta! \nIntroduce el saldo inicial");
        saldo_inicial = sc.nextDouble();
        cuentas[0] = new Cuenta(numero_cuenta, saldo_inicial);
        Cliente cliente_actual = new Cliente(nombre, apellido, dni, cuentas);
        do {
            System.out.println("\nBienvenido " + nombre +
                    "\nQue operacion quieres hacer\n1. Consultar saldo" +
                    "\n2. Ingresar dinero\n3. Retirar dinero\n4. Crear cuenta adicional\n5. Salir");
            opcion = sc.nextInt();


            if (opcion == 1) {
                if (contador_cuentas == 0) {
                    saldo = cliente_actual.consultar_saldo(cuentas[0].getNumeroCuenta());
                    System.out.println("Su saldo actual es de: " + saldo);
                }
                else {
                    System.out.println("Sobre que cuenta quieres realizar la operacion: ");
                    numero_cuenta = sc.nextInt();
                    saldo = cliente_actual.consultar_saldo(cuentas[numero_cuenta].getNumeroCuenta());
                    System.out.println("Su saldo actual es de: " + saldo);
                }
            }
            else if (opcion == 2) {
                if (contador_cuentas == 0) {
                    System.out.println("Cuanto dinero quieres ingresar: ");
                    cantidad = sc.nextDouble();
                    cliente_actual.ingresar_dinero(cuentas[0].getNumeroCuenta(), cantidad);
                    saldo = cliente_actual.consultar_saldo(cuentas[0].getNumeroCuenta());
                    System.out.println("Su saldo tras el ingreso es de: " + saldo);
                }
                else{
                    System.out.println("Cuanto dinero quieres ingresar: ");
                    cantidad = sc.nextDouble();
                    System.out.println("Sobre que cuenta quieres realizar la operacion: ");
                    numero_cuenta = sc.nextInt();
                    cliente_actual.ingresar_dinero(cuentas[numero_cuenta].getNumeroCuenta(), cantidad);
                    saldo = cliente_actual.consultar_saldo(cuentas[0].getNumeroCuenta());
                    System.out.println("Su saldo tras el ingreso es de: " + saldo);
                }
            }
            else if (opcion == 3) {
                if (contador_cuentas == 0) {
                    System.out.println("Cuanto dinero quieres retirar: ");
                    cantidad = sc.nextDouble();
                    cliente_actual.retirar_dinero(cuentas[0].getNumeroCuenta(), cantidad);
                    saldo = cliente_actual.consultar_saldo(cuentas[0].getNumeroCuenta());
                    System.out.println("Su saldo tras la retirada es de: " + saldo);
                }
                else{
                    System.out.println("Cuanto dinero quieres retirar: ");
                    cantidad = sc.nextDouble();
                    System.out.println("Sobre que cuenta quieres realizar la operacion: ");
                    numero_cuenta = sc.nextInt();
                    cliente_actual.retirar_dinero(cuentas[numero_cuenta].getNumeroCuenta(), cantidad);
                    saldo = cliente_actual.consultar_saldo(cuentas[numero_cuenta].getNumeroCuenta());
                    System.out.println("Su saldo tras la retirada es de: " + saldo);
                }
            }
            else if (opcion == 4) {
                System.out.println("Crea otra cuenta! \nIntroduce el saldo inicial");
                saldo_inicial = sc.nextDouble();
                contador_cuentas++;
                cuentas[contador_cuentas] = new Cuenta(contador_cuentas, saldo_inicial);
            }
            else if (opcion == 5) {
                salir = true;
            }
            else{
                System.out.println("Operacion no valida");
            }

        } while (!salir);
    }
}