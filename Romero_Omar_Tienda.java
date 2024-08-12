package proyectoq3tienda;

import java.util.Scanner;

public class Romero_Omar_Tienda {

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter("\n");

        //inaguracion
        boolean inaguracion = false;

        //Elecciones de Usuario
        String eleccion, eleccion_producto, eleccion_tercero, eleccionpeso, confirmarcompra;

        //manejo de Caja
        double efectivo_caja = 0, deposito_efectivo;

        //Estados de la tienda
        boolean caja_abierta = true;

        //manejo caja
        int cantidadproductos;

        //display en codigo
        String producto = "";
        double precioproducto = 0;
        int kilos;
        double subtotal;
        double impuestos;
        double total;
        double descuento;

        //reportes
        int compradia = 0, ventadia = 0;
        double efectivoventas = 0, efectivocompras = 0;
        double mediocompra, medioventas;
        double maxventa = 0, maxcompra = 0;
        String maxventadisplay = "", maxcompradisplay = "";

        //stock
        int trigo = 0, avena = 0, maiz = 0, azucar = 0, stock;

        //compras
        int temptrigo, tempavena, tempmaiz, tempazucar;

        //vendidos
        int trigovendido = 0, avenavendida = 0, maizvendido = 0, azucarvendido = 0;

        //escapes
        boolean escape, regresokilo, regresotercero, regresoproducto;

        while (inaguracion == false) {
            System.out.println("***************************");
            System.out.println("Menu principal");
            System.out.println("***************************");
            System.out.println("1. Abrir Caja");
            System.out.println("2. Salir del Sistema");
            System.out.println("***************************");
            System.out.println("Seleccione una opcion: ");
            eleccion = lea.next();

            if (eleccion.equals("1")) {
                while (true) {
                    System.out.println("El efectivo en caja es de: " + efectivo_caja);
                    while (true) {
                        System.out.println("Cuanto efectivo desea ingresar a la caja?");
                        deposito_efectivo = lea.nextDouble();
                        if (deposito_efectivo > 0) {
                            efectivo_caja += deposito_efectivo;
                            System.out.println("Se ha ingresado la cantidad de Lps." + deposito_efectivo + " a la caja");
                            inaguracion = true;
                            System.out.println("!La tienda se ha inagurado!");
                            break;
                        } else {
                            System.out.println("!!AVISO!! Ingrese un valor mayor a CERO");
                        }
                    }
                    break;
                }
            } else if (eleccion.equals("2")) {
                break;
            } else {
                System.out.println("!!AVISO!! Ingrese una opcion valida");
            }
        }

        while (inaguracion != false) {
            stock = (trigo + avena + maiz + azucar);
            escape = false;
            regresokilo = false;
            regresoproducto = false;
            temptrigo = 0;
            tempavena = 0;
            tempmaiz = 0;
            tempazucar = 0;
            mediocompra = (efectivocompras / compradia);
            medioventas = (efectivoventas / ventadia);
            System.out.println("***************************");
            System.out.println("Menu principal");
            System.out.println("***************************");
            System.out.println("1. Abrir Caja");
            if (caja_abierta == true) {
                System.out.println("2. Ventas");
                System.out.println("3. Compras");
                System.out.println("4. Reportes");
                System.out.println("5. Cierre Caja");
                System.out.println("6. Salir del Sistema");
            } else {
                System.out.println("2. Reportes");
                System.out.println("3. Salir del Sistema");
            }
            System.out.println("***************************");
            System.out.println("Seleccione una opcion: ");
            eleccion = lea.next();

            if (eleccion.equals("1")) {
                if (caja_abierta == true) {
                    while (true) {
                        System.out.println("El efectivo en caja es de: " + efectivo_caja);
                        while (true) {
                            System.out.println("Cuanto efectivo desea ingresar a la caja?");
                            deposito_efectivo = lea.nextDouble();
                            if (deposito_efectivo > 0) {
                                efectivo_caja += deposito_efectivo;
                                System.out.println("Se ha ingresado la cantidad de Lps." + deposito_efectivo + " a la caja");
                                break;
                            } else {
                                System.out.println("!!AVISO!! Ingrese un valor mayor a CERO");
                            }
                        }
                        break;
                    }
                } else {
                    System.out.println("Ha comenzado un nuevo dia, la caja ha sido abierta");
                    caja_abierta = true;
                }
            } else if (eleccion.equals("2") && caja_abierta == true) { //Ventas
                if (stock == 0) {
                    System.out.println("!!AVISO!! la tienda se encuentra sin productos, vuelva mas tarde.");
                } else {
                    System.out.println("Ha seleccionado la opcion Ventas");
                    while (escape == false) {
                        System.out.println("Seleccione que clase de cliente es [A,B,C]");
                        System.out.println("Si desea regresar al menu principal ingrese [salir]");
                        eleccion_tercero = lea.next();
                        if (eleccion_tercero.equalsIgnoreCase("a") || eleccion_tercero.equalsIgnoreCase("b") || eleccion_tercero.equalsIgnoreCase("c")) {
                            while (escape == false) {
                                regresoproducto = false;
                                System.out.println("Seleccione que producto desea vender con su respectivo codigo: ");
                                System.out.println("Si desea volver al menu principal ingrese [salir]");
                                System.out.println("*----------------------------------------------------------*");
                                System.out.println("Producto              Precio por Kg          Kg en almacen");
                                System.out.println("*----------------------------------------------------------*");
                                if (eleccion_tercero.equalsIgnoreCase("a")) {
                                    System.out.println("1. Azucar               Lps.30.00        Kg." + azucar);
                                    System.out.println("2. Avena               Lps.25.00        Kg." + avena);
                                    System.out.println("3. Trigo               Lps.32.00        Kg." + trigo);
                                    System.out.println("4. Maiz               Lps.20.00        Kg." + maiz);
                                } else if (eleccion_tercero.equalsIgnoreCase("b")) {
                                    System.out.println("1. Azucar               Lps.30.00        Kg." + azucar);
                                    System.out.println("2. Avena               Lps.25.00        Kg." + avena);
                                    System.out.println("3. Trigo               Lps.32.00        Kg." + trigo);
                                } else if (eleccion_tercero.equalsIgnoreCase("c")) {
                                    System.out.println("1. Maiz               Lps.20.00        Kg." + maiz);
                                }
                                System.out.println("*----------------------------------------------------------*");
                                eleccion_producto = lea.next();
                                if ((eleccion_tercero.equalsIgnoreCase("a") && (eleccion_producto.equalsIgnoreCase("1") || eleccion_producto.equalsIgnoreCase("2") || eleccion_producto.equalsIgnoreCase("3") || eleccion_producto.equalsIgnoreCase("4"))) || (eleccion_tercero.equalsIgnoreCase("b") && (eleccion_producto.equalsIgnoreCase("1") || eleccion_producto.equalsIgnoreCase("2") || eleccion_producto.equalsIgnoreCase("3"))) || (eleccion_tercero.equalsIgnoreCase("c") && eleccion_producto.equalsIgnoreCase("1"))) {
                                    if (eleccion_tercero.equalsIgnoreCase("a")) {
                                        if (eleccion_producto.equalsIgnoreCase("1")) {
                                            if (azucar > 0) {
                                                producto = "Azucar";
                                                precioproducto = 30;
                                            } else {
                                                System.out.println("Lo sentimos mucho, no tenemos disponible este producto");
                                                escape = true;
                                            }
                                        } else if (eleccion_producto.equalsIgnoreCase("2")) {
                                            if (avena > 0) {
                                                producto = "Avena";
                                                precioproducto = 25;
                                            } else {
                                                System.out.println("Lo sentimos mucho, no tenemos disponible este producto");
                                                escape = true;
                                            }
                                        } else if (eleccion_producto.equalsIgnoreCase("3")) {
                                            if (trigo > 0) {
                                                producto = "Trigo";
                                                precioproducto = 32;
                                            } else {
                                                System.out.println("Lo sentimos mucho, no tenemos disponible este producto");
                                                escape = true;
                                            }
                                        } else if (eleccion_producto.equalsIgnoreCase("4")) {
                                            if (maiz > 0) {
                                                producto = "Maiz";
                                                precioproducto = 20;
                                            } else {
                                                System.out.println("Lo sentimos mucho, no tenemos disponible este producto");
                                                escape = true;
                                            }
                                        }
                                    } else if (eleccion_tercero.equalsIgnoreCase("b")) {
                                        if (eleccion_producto.equalsIgnoreCase("1")) {
                                            if (azucar > 0) {
                                                producto = "Azucar";
                                                precioproducto = 30;
                                            } else {
                                                System.out.println("Lo sentimos mucho, no tenemos disponible este producto");
                                                escape = true;
                                            }
                                        } else if (eleccion_producto.equalsIgnoreCase("2")) {
                                            if (avena > 0) {
                                                producto = "Avena";
                                                precioproducto = 25;
                                            } else {
                                                System.out.println("Lo sentimos mucho, no tenemos disponible este producto");
                                                escape = true;
                                            }
                                        } else if (eleccion_producto.equalsIgnoreCase("3")) {
                                            if (trigo > 0) {
                                                producto = "Trigo";
                                                precioproducto = 32;
                                            } else {
                                                System.out.println("Lo sentimos mucho, no tenemos disponible este producto");
                                                escape = true;
                                            }
                                        }
                                    } else if (eleccion_tercero.equalsIgnoreCase("c")) {
                                        if (eleccion_producto.equalsIgnoreCase("1")) {
                                            if (maiz > 0) {
                                                producto = "Maiz";
                                                precioproducto = 20;
                                            } else {
                                                System.out.println("Lo sentimos mucho, no tenemos disponible este producto");
                                                escape = true;
                                            }
                                        }
                                    }
                                    while (escape == false && !regresoproducto == true) {
                                        regresokilo = false;
                                        System.out.println("Ha escogido " + producto + " como producto, cuantos kilogramos de este desea?");
                                        System.out.println("Si desea hacer un cambio en el producto seleccionado ingrese [regresar], si desea volver al menu principal ingrese [salir]");
                                        eleccionpeso = lea.next();
                                        if (eleccionpeso.equalsIgnoreCase("salir")) {
                                            escape = true;
                                        } else if (eleccionpeso.equalsIgnoreCase("regresar")) {
                                            regresoproducto = true;
                                        } else {
                                            try {
                                                kilos = Integer.parseInt(eleccionpeso);
                                                if (kilos > 0) {
                                                    if (eleccion_tercero.equalsIgnoreCase("a")) {
                                                        if (eleccion_producto.equalsIgnoreCase("1")) {
                                                            if (kilos > azucar) {
                                                                System.out.println("Lo sentimos mucho, no tenemos disponible esa cantidad de Kilogramos");
                                                                escape = true;
                                                            }
                                                        } else if (eleccion_producto.equalsIgnoreCase("2")) {
                                                            if (kilos > avena) {
                                                                System.out.println("Lo sentimos mucho, no tenemos disponible esa cantidad de Kilogramos");
                                                                escape = true;
                                                            }
                                                        } else if (eleccion_producto.equalsIgnoreCase("3")) {
                                                            if (kilos > trigo) {
                                                                System.out.println("Lo sentimos mucho, no tenemos disponible esa cantidad de Kilogramos");
                                                                escape = true;
                                                            }
                                                        } else if (eleccion_producto.equalsIgnoreCase("4")) {
                                                            if (kilos > maiz) {
                                                                System.out.println("Lo sentimos mucho, no tenemos disponible esa cantidad de Kilogramos");
                                                                escape = true;
                                                            }
                                                        }
                                                    } else if (eleccion_tercero.equalsIgnoreCase("b")) {
                                                        if (eleccion_producto.equalsIgnoreCase("1")) {
                                                            if (kilos > azucar) {
                                                                System.out.println("Lo sentimos mucho, no tenemos disponible esa cantidad de Kilogramos");
                                                                escape = true;
                                                            }
                                                        } else if (eleccion_producto.equalsIgnoreCase("2")) {
                                                            if (kilos > avena) {
                                                                System.out.println("Lo sentimos mucho, no tenemos disponible esa cantidad de Kilogramos");
                                                                escape = true;
                                                            }
                                                        } else if (eleccion_producto.equalsIgnoreCase("3")) {
                                                            if (kilos > trigo) {
                                                                System.out.println("Lo sentimos mucho, no tenemos disponible esa cantidad de Kilogramos");
                                                                escape = true;
                                                            }
                                                        }
                                                    }
                                                    while (escape == false && !regresokilo == true) {
                                                        if (producto.equalsIgnoreCase("Azucar")) {
                                                            tempazucar += kilos;
                                                        } else if (producto.equalsIgnoreCase("avena")) {
                                                            tempavena += kilos;
                                                        } else if (producto.equalsIgnoreCase("trigo")) {
                                                            temptrigo += kilos;
                                                        } else if (producto.equalsIgnoreCase("Maiz")) {
                                                            tempmaiz += kilos;
                                                        }
                                                        System.out.println("Ha seleccionado " + kilos + " kilos de " + producto);
                                                        System.out.println("Si desea agregar otro producto ingrese [agregar], si desea volver a cambiar los kilogramos escriba [regresar] si desea confirmar la compra ingrese [confirmar]");
                                                        confirmarcompra = lea.next();

                                                        if (confirmarcompra.equalsIgnoreCase("confirmar")) {
                                                            subtotal = (tempazucar * 30 + tempavena * 25 + temptrigo * 32 + tempmaiz * 20);
                                                            impuestos = subtotal * 0.07;
                                                            if (subtotal > 5000) {
                                                                descuento = subtotal * 0.10;
                                                            } else if (subtotal >= 1000) {
                                                                descuento = subtotal * 0.05;
                                                            } else {
                                                                descuento = 0;
                                                            }
                                                            total = subtotal + impuestos - descuento;
                                                            if (total > maxventa) {
                                                                maxventa = total;
                                                                maxventadisplay = "";
                                                            }
                                                            System.out.println("*********Factura*********");
                                                            if (tempazucar > 0) {
                                                                if (total > maxventa) {
                                                                    maxventadisplay += "Azucar ";
                                                                }
                                                                System.out.println("Producto:  Azucar");
                                                                System.out.println("Precio por Kg:  Lps.30");
                                                                System.out.println("Cantidad de Kg: " + tempazucar);
                                                            }
                                                            if (tempavena > 0) {
                                                                if (total > maxventa) {
                                                                    maxventadisplay += "Avena ";
                                                                }
                                                                System.out.println("Producto:  Avena");
                                                                System.out.println("Precio por Kg:  Lps.30");
                                                                System.out.println("Cantidad de Kg: " + tempavena);
                                                            }
                                                            if (temptrigo > 0) {
                                                                if (total > maxventa) {
                                                                    maxventadisplay += "Trigo ";
                                                                }
                                                                System.out.println("Producto:  Trigo");
                                                                System.out.println("Precio por Kg:  Lps.30");
                                                                System.out.println("Cantidad de Kg: " + temptrigo);
                                                            }
                                                            if (tempmaiz > 0) {
                                                                if (total > maxventa) {
                                                                    maxventadisplay += "Maiz ";
                                                                }
                                                                System.out.println("Producto:  Maiz");
                                                                System.out.println("Precio por Kg:  Lps.20");
                                                                System.out.println("Cantidad de Kg: " + tempmaiz);
                                                            }
                                                            System.out.println("Subtotal:       Lps." + subtotal);
                                                            if (descuento > 0) {
                                                                System.out.println("Descuento:     Lps." + descuento);
                                                            }
                                                            System.out.println("Impuesto del 7% Lps." + impuestos);
                                                            System.out.println("Total:          Lps." + total);
                                                            efectivo_caja += total;

                                                            maizvendido += tempmaiz;
                                                            trigovendido += temptrigo;
                                                            avenavendida += tempavena;
                                                            azucarvendido += tempazucar;

                                                            maiz -= tempmaiz;
                                                            trigo -= temptrigo;
                                                            avena -= tempavena;
                                                            azucar -= tempazucar;
                                                            ventadia++;
                                                            efectivoventas += total;
                                                            escape = true;
                                                        } else if (confirmarcompra.equalsIgnoreCase("agregar")) {
                                                            regresoproducto = true;
                                                            regresokilo = true;
                                                        } else if (confirmarcompra.equalsIgnoreCase("regresar")) {
                                                            if (producto.equalsIgnoreCase("maiz")) {
                                                                tempmaiz -= kilos;
                                                            } else if (producto.equalsIgnoreCase("trigo")) {
                                                                temptrigo -= kilos;
                                                            } else if (producto.equalsIgnoreCase("avena")) {
                                                                tempavena -= kilos;
                                                            } else if (producto.equalsIgnoreCase("azucar")) {
                                                                tempazucar -= kilos;
                                                            }
                                                            regresokilo = true;
                                                        } else {
                                                            System.out.println("!!AVISO!! ingrese una respuesta valida");
                                                        }
                                                    }

                                                } else {
                                                    System.out.println("!!AVISO!! ingrese una cantidad de kilogramos adecuada");
                                                }
                                            } catch (NumberFormatException e) {
                                                System.out.println("!!AVISO!! Ingrese una cantidad de kilogramos");
                                            }
                                        }
                                    }

                                } else if (eleccion_producto.equalsIgnoreCase("salir")) {
                                    System.out.println("Regresando al menu...");
                                    escape = true;
                                } else {
                                    System.out.println("!!AVISO!! ingrese un tipo de producto valido");
                                }

                            }
                        } else if (eleccion_tercero.equalsIgnoreCase("salir")) {
                            System.out.println("Regresando al menu...");
                            escape = true;
                        } else {
                            System.out.println("!!AVISO!! Ingrese un tipo de proveedor valido");
                        }
                    }

                }

            } else if (eleccion.equals("3") && caja_abierta == true) { //Compras no se pide otro
                if (efectivo_caja == 0) {
                    System.out.println("!!AVISO!! La caja no tiene fondos suficientes para hacer alguna compra");
                } else if (efectivo_caja > 0) {
                    System.out.println("Ha seleccionado la opcion Compras");
                    while (escape == false) {
                        System.out.println("Seleccione que clase de Proveedor es [A,B,C]");
                        System.out.println("Si desea regresar al menu principal ingrese [salir]");
                        eleccion_tercero = lea.next();
                        if (eleccion_tercero.equalsIgnoreCase("a") || eleccion_tercero.equalsIgnoreCase("b") || eleccion_tercero.equalsIgnoreCase("c")) {
                            regresotercero = false;
                            while (escape == false && !regresotercero == true) {
                                regresoproducto = false;
                                System.out.println("Seleccione que producto desea comprar con su respectivo codigo: ");
                                System.out.println("Si desea hacer un cambio en el proveedor ingrese [regresar], si desea volver al menu principal ingrese [salir]");
                                System.out.println("*----------------------------------------------------------*");
                                System.out.println("Producto              Precio por Kg");
                                System.out.println("*----------------------------------------------------------*");
                                if (eleccion_tercero.equalsIgnoreCase("b")) {
                                    System.out.println("1. Avena               Lps.20.00");
                                    System.out.println("2. Trigo               Lps.30.00");
                                } else if (eleccion_tercero.equalsIgnoreCase("a")) {
                                    System.out.println("1. Azucar              Lps.25.00");
                                    System.out.println("2. Maiz                Lps.18.00");
                                } else if (eleccion_tercero.equalsIgnoreCase("c")) {
                                    System.out.println("1. Avena               Lps.22.00");
                                }
                                System.out.println("*----------------------------------------------------------*");
                                eleccion_producto = lea.next();
                                if (eleccion_producto.equalsIgnoreCase("1") || (eleccion_producto.equalsIgnoreCase("2") && (eleccion_tercero.equalsIgnoreCase("b") || eleccion_tercero.equalsIgnoreCase("a")))) {
                                    if (eleccion_tercero.equalsIgnoreCase("b")) {
                                        if (eleccion_producto.equalsIgnoreCase("1")) {
                                            producto = "Avena";
                                            precioproducto = 20;
                                        } else if (eleccion_producto.equalsIgnoreCase("2")) {
                                            producto = "Trigo";
                                            precioproducto = 30;
                                        }
                                    } else if (eleccion_tercero.equalsIgnoreCase("a")) {
                                        if (eleccion_producto.equalsIgnoreCase("1")) {
                                            producto = "Azucar";
                                            precioproducto = 25;
                                        } else if (eleccion_producto.equalsIgnoreCase("2")) {
                                            producto = "Maiz";
                                            precioproducto = 18;
                                        }
                                    } else if (eleccion_tercero.equalsIgnoreCase("c")) {
                                        if (eleccion_producto.equalsIgnoreCase("1")) {
                                            producto = "Avena";
                                            precioproducto = 22;
                                        }
                                    }

                                    while (escape == false && !regresoproducto == true) {
                                        System.out.println("Ha escogido " + producto + " como producto, cuantos kilogramos de este desea?");
                                        System.out.println("Si desea hacer un cambio en el producto seleccionado ingrese [regresar], si desea volver al menu principal ingrese [salir]");
                                        eleccionpeso = lea.next();
                                        regresokilo = false;
                                        if (eleccionpeso.equalsIgnoreCase("salir")) {
                                            escape = true;
                                        } else if (eleccionpeso.equalsIgnoreCase("regresar")) {
                                            regresoproducto = true;
                                        } else {
                                            try {
                                                kilos = Integer.parseInt(eleccionpeso);
                                                if (kilos > 0) {
                                                    while (escape == false && !regresokilo == true) {
                                                        System.out.println("Ha seleccionado " + kilos + " kilos de " + producto);
                                                        System.out.println("Si desea confirmar la compra ingrese [confirmar]");
                                                        System.out.println("Si desea hacer un cambio en la cantidad de kilos del producto ingrese [regresar], si desea volver al menu principal ingrese [salir]");
                                                        confirmarcompra = lea.next();

                                                        if (confirmarcompra.equalsIgnoreCase("regresar")) {
                                                            regresokilo = true;
                                                        } else if (confirmarcompra.equalsIgnoreCase("salir")) {
                                                            escape = true;
                                                        } else if (confirmarcompra.equalsIgnoreCase("confirmar")) {
                                                            subtotal = kilos * precioproducto;
                                                            impuestos = subtotal * 0.07;
                                                            total = subtotal + impuestos;
                                                            if (efectivo_caja > total) {
                                                                System.out.println("*********FACTURA*********");
                                                                System.out.println("Producto " + producto);
                                                                System.out.println("Precio por Kg:  Lps." + precioproducto);
                                                                System.out.println("Cantidad de Kg: " + kilos);
                                                                System.out.println("Subtotal:       Lps." + subtotal);
                                                                System.out.println("Impuesto del 7% Lps." + impuestos);
                                                                System.out.println("Total:          Lps." + total);
                                                                efectivo_caja -= total;

                                                                if (producto.equalsIgnoreCase("maiz")) {
                                                                    maiz += kilos;
                                                                } else if (producto.equalsIgnoreCase("trigo")) {
                                                                    trigo += kilos;
                                                                } else if (producto.equalsIgnoreCase("avena")) {
                                                                    avena += kilos;
                                                                } else if (producto.equalsIgnoreCase("azucar")) {
                                                                    azucar += kilos;
                                                                }
                                                                if (total > maxcompra) {
                                                                    maxcompra = total;
                                                                    maxcompradisplay = producto;
                                                                }
                                                                efectivocompras += total;
                                                                compradia++;
                                                                escape = true;
                                                            } else {
                                                                System.out.println("!!AVISO!! No cuenta con el efectivo suficiente para efectuar la compra");
                                                                System.out.println("Regresando al menu principal...");
                                                                escape = true;
                                                            }
                                                        } else {
                                                            System.out.println("!!AVISO!! Ingrese una opcion valida");
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("!!AVISO!! Ingrese una cantidad de kilogramos adecuada");
                                                }
                                            } catch (NumberFormatException e) {
                                                System.out.println("!!AVISO!! Ingrese una cantidad de kilogramos");
                                            }
                                        }
                                    }
                                } else if (eleccion_producto.equalsIgnoreCase("regresar")) {
                                    System.out.println("Regresando al menu de seleccion de proveedor");
                                    regresotercero = true;
                                } else if (eleccion_producto.equalsIgnoreCase("salir")) {
                                    System.out.println("Regresando al menu principal...");
                                    escape = true;
                                } else {
                                    System.out.println("!!AVISO!! Ingrese un codigo de producto valido");
                                }
                            }
                        } else if (eleccion_tercero.equalsIgnoreCase("salir")) {
                            System.out.println("Regresando al menu");
                            escape = true;
                        } else {
                            System.out.println("!!AVISO!! Ingrese un tipo de proveedor valido");
                        }
                    }
                }
            } else if ((eleccion.equals("4") && caja_abierta == true) || (eleccion.equals("2") && caja_abierta == false)) { //reportes
                System.out.println("***********REPORTES***********");
                System.out.println("");
                System.out.println("Cantitad actual de efectivo en caja:");
                System.out.println("Lps." + efectivo_caja);
                System.out.println("");
                System.out.println("Numero de Compras y Ventas realizadas en el dia");
                System.out.println("Numero de compras hoy: " + compradia);
                System.out.println("Numero de ventas hoy: " + ventadia);
                System.out.println("");
                System.out.println("Volumen total de Compras y Ventas ");
                System.out.println("Volumen compras: Lps." + efectivocompras);
                System.out.println("Volumen ventas:  Lps." + efectivoventas);
                System.out.println("Margen de ganancias: Lps." + (efectivoventas - efectivocompras));
                System.out.println("");
                System.out.println("Valor Medio de Compra y Venta");
                System.out.println("Valor medio de compras: Lps." + mediocompra);
                System.out.println("Valor medio de ventas: Lps." + medioventas);
                System.out.println("");
                System.out.println("Venta y Compra con mas ganancia");
                if (maxventa > 0) {
                    System.out.println("Venta con mas ganancia: Lps." + maxventa + " Producto: " + maxventadisplay);
                } else {
                    System.out.println("No se han vendido productos");
                }
                if (maxcompra > 0) {
                    System.out.println("Compra con mas ganancia: Lps." + maxcompra + " Producto: " + maxcompradisplay);
                } else {
                    System.out.println("No se han comprado productos");
                }
                System.out.println("");
                int top1 = azucarvendido;
                int top2 = avenavendida;
                int top3 = trigovendido;
                int top4 = maizvendido;

                String producto1 = "Azucar";
                String producto2 = "Avena";
                String producto3 = "Trigo";
                String producto4 = "Maiz";

                if (top1 < top2) {
                    int tempCantidad = top1;
                    String tempProducto = producto1;
                    top1 = top2;
                    producto1 = producto2;
                    top2 = tempCantidad;
                    producto2 = tempProducto;
                }
                if (top1 < top3) {
                    int tempCantidad = top1;
                    String tempProducto = producto1;
                    top1 = top3;
                    producto1 = producto3;
                    top3 = tempCantidad;
                    producto3 = tempProducto;
                }
                if (top1 < top4) {
                    int tempCantidad = top1;
                    String tempProducto = producto1;
                    top1 = top4;
                    producto1 = producto4;
                    top4 = tempCantidad;
                    producto4 = tempProducto;
                }

                if (top2 < top3) {
                    int tempCantidad = top2;
                    String tempProducto = producto2;
                    top2 = top3;
                    producto2 = producto3;
                    top3 = tempCantidad;
                    producto3 = tempProducto;
                }
                if (top2 < top4) {
                    int tempCantidad = top2;
                    String tempProducto = producto2;
                    top2 = top4;
                    producto2 = producto4;
                    top4 = tempCantidad;
                    producto4 = tempProducto;
                }

                if (top3 < top4) {
                    int tempCantidad = top3;
                    String tempProducto = producto3;
                    top3 = top4;
                    producto3 = producto4;
                    top4 = tempCantidad;
                    producto4 = tempProducto;
                }
                System.out.println("Producto Estrella");
                if (ventadia > 0) {
                    System.out.println("Producto Estrella: " + producto1 + ": " + top1);
                } else {
                    System.out.println("No se han comprado productos");
                }
                System.out.println("");
                System.out.println("Ranking de productos");
                if (ventadia > 0) {
                    System.out.println("1." + producto1 + ": " + top1);
                    System.out.println("2." + producto2 + ": " + top2);
                    System.out.println("3." + producto3 + ": " + top3);
                    System.out.println("4." + producto4 + ": " + top4);
                    System.out.println("");
                } else {
                    System.out.println("No se han comprado productos");
                }
                System.out.println("");

            } else if (eleccion.equals("5")) {
                System.out.println("Ha seleccionado cierre de caja");
                System.out.println("El efectivo en caja es de: " + efectivo_caja);
                while (true) {
                    System.out.println("Cuanto de este efectivo desea guardar en el banco? (La cantidad maxima de deposito al banco es de Lps." + efectivo_caja * 0.60 + ")");
                    deposito_efectivo = lea.nextDouble();
                    if (deposito_efectivo <= efectivo_caja * 0.60 && deposito_efectivo >= 0) {
                        System.out.println("Se ha depositado la cantidad de Lps." + deposito_efectivo + " al banco");
                        efectivo_caja -= deposito_efectivo;
                        compradia = 0;
                        ventadia = 0;
                        efectivoventas = 0;
                        efectivocompras = 0;
                        maxventa = 0;
                        maxcompra = 0;
                        maxventadisplay = "";
                        maxcompradisplay = "";
                        maizvendido = 0;
                        trigovendido = 0;
                        avenavendida = 0;
                        azucarvendido = 0;
                        caja_abierta = false;
                        break;
                    } else if (deposito_efectivo > efectivo_caja * 0.60) {
                        System.out.println("!!AVISO!! La cantidad maxima de deposito al banco es de Lps." + efectivo_caja * 0.60);
                    } else {
                        System.out.println("!!AVISO!! Ingrese un valor mayor a CERO");
                    }
                }
            } else if (eleccion.equals("6") && caja_abierta == true || eleccion.equals("3") && caja_abierta == false) {
                System.out.println("Saliendo del sistema, muchas gracias!");
                break;
            } else {
                System.out.println("***************************");
                System.out.println("!!AVISO!! seleccione una opcion valida");
            }

        }

    }
}
//un agradecimiento a mi papa a mi mama a mi hermana a mi otra hermana a mi novia a mi tio a mi tia a mi otra tia a mi otro tio a mi primo a mi prima a mi otra prima a mi gato a mi tortuga a mi otra tortuga a mi abuela a mi abuelo a mi

