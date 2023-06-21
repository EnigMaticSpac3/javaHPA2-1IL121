/*
 * Integrantes:
 * - Jorge González   | 8-1002-2167
 * - Diego Ramos      | 8-1002-1456
 * - Amy Him          | 3-753-2253
 * - Jefferson Chacon | 20-70-7314
 */

import javax.swing.*;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        // Objeto de la clase
        MundoM     mates    = new MundoM();
        Adivinanza adi      = new Adivinanza();
        Ecuacion   ecuacion = new Ecuacion();

        // Objeto Random
        Random rand = new Random();
        int random;
        
        // Imagenes
        ImageIcon img_bien1 = new ImageIcon("./imgs/bien1.png");
        ImageIcon img_bien2 = new ImageIcon("./imgs/bien2.jpg");
        ImageIcon img_bien3 = new ImageIcon("./imgs/bien3.jpg");
        ImageIcon img_mot1 = new ImageIcon("./imgs/motivador1.png");
        ImageIcon img_mot2 = new ImageIcon("./imgs/motivador2.jpg");
        ImageIcon img_mot3 = new ImageIcon("./imgs/motivador3.jpg");
        ImageIcon imgs[] = {img_bien1, img_bien2, img_bien3, img_mot1, img_mot2, img_mot3};

        // Variables

        // Preguntas
        String adivinanzas[] = {"¿De que color es el caballo blanco de napoleon?", "Cuando llueve y sale el sol, todos los colores los tengo yo", "De rayas es mi pijama, aunque nunca me meto en la cama.", "Lenta dicen que es porque solo asoma la cabeza las patas y los pies"};
        // Respuestas en pequeños arreglos que se muestran como opciones
        String respA[][]     = {{"Blanco", "Negro", "Azul"}, {"Barco", "Arcoiris", "Gato"}, {"Zorro", "Cebra", "Jirafa"}, {"Caracol", "Cocodrilo", "Tortuga"}};
        // posicion de la respuesta correcta en las opciones dadas
        int respCA[]         = {0, 1, 1, 2};
        String pregunta, problema = "";
        String respuestas[];
        String opcionS, respS = "", tiempoTomado = "";
        int respCorrecta, opcion = 0, num1, num2, resultado;
        // contadores
        int continuar = 0, contCorrectas = 0, contIntentos = 0, contIncorrectas = 0;
        char op; // operador
        int i; // para el for
        boolean bien = true;

        // Tiempo        
        long tiempoInicio, tiempoInicioJuego, tiempoFinal, tiempoTotal, minutos, segundos;

        // Arreglos
        char OPERADORES[]     = {'+', '-', '/', '*'};
        
        // INICIANDO EL PROGRAMA
        JOptionPane.showMessageDialog(null, "Bienvenido al Mundo de las Operaciones Matemáticas", "Mundo de las Operaciones Matematicas", JOptionPane.PLAIN_MESSAGE, null);
        JOptionPane.showMessageDialog(null, "Comencemos con una adivinanza\nTu puedes!", "Mundo de las Operaciones Matematicas", JOptionPane.PLAIN_MESSAGE, null);

        // ADIVINAZA ANTES DE ENTRAR AL MENÚ
        do {
            if (contIntentos == 3) {
                JOptionPane.showMessageDialog(null, "Lo siento, se te acabaron los intentos.", "Mundo de las matemáticas", JOptionPane.INFORMATION_MESSAGE, null);
                
                opcion = JOptionPane.showConfirmDialog(null, "Deseas intentarlo otra vez?", tiempoTomado, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                // reiniciamos los intentos
                if (opcion == JOptionPane.YES_OPTION) {
                    contIntentos = 0;
                } else {
                    JOptionPane.showMessageDialog(null, "Gracias por jugar!", "Mundo de las matemáticas", JOptionPane.INFORMATION_MESSAGE, null);
                    System.exit(0);
                }
                // break;
            }
            bien = true;
            opcion = JOptionPane.NO_OPTION;
            // generar random para la adivinanza
            random = rand.nextInt(adivinanzas.length);
            // generar pregunta random a mostrar
            adi.asignar(adivinanzas, respA, respCA, random);
            // guardamos la pregunta y sus respuestas
            pregunta        = adi.generarPregunta();
            respuestas      = adi.generarRespuestas(); 
            respCorrecta    = adi.generarRespCorrecta();
    
            int n = JOptionPane.showOptionDialog(null, pregunta, "Adivina!\tIntento " + (contIntentos+1) + "/" + "3", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, imgs[mates.generarNum(0, 2)], respuestas, null);
    
            System.out.println("Respuesta correcta: " + respuestas[respCorrecta]);
            System.out.println("Respuesta del usuario: " + respuestas[n]);
    
            if (n == respCorrecta) {
                JOptionPane.showMessageDialog(null, "Correcto!", "Mundo de las matemáticas", JOptionPane.INFORMATION_MESSAGE, imgs[mates.generarNum(0, 2)]);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrecto!\nVuelve a intentarlo", "Mundo de las matemáticas", JOptionPane.ERROR_MESSAGE, imgs[mates.generarNum(3, 5)]);
                bien = false;
                contIntentos++;
            }
        } while (!bien || opcion == JOptionPane.YES_OPTION);

        // MENU
        do {
            do {
                bien = true;
                opcionS = JOptionPane.showInputDialog(null,
                "Elige una opcion\n"
                + "1. Calculos Mentales\n"
                + "2. Adivina si puedes\n"
                + "3. Salir\n", 
                "Bienvenido al Mundo de las Operaciones Matematicas", JOptionPane.INFORMATION_MESSAGE);    
                
                // si el usuario cancela
                if (opcionS == null) {
                    opcion = JOptionPane.showConfirmDialog(null, "Desea salir del Programa?", "Mundo Matemáticas - Salir del Desafío", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
                    if (opcion == JOptionPane.NO_OPTION) {
                        bien = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "Gracias por jugar!\n", "Mundo de las Matematicas", JOptionPane.PLAIN_MESSAGE, null);
                        System.exit(0);
                    }
                }
            } while (!bien);

            try {
                opcion = Integer.parseInt(opcionS);

                if (opcion < 1 || opcion > 3) {
                    bien = false;
                    JOptionPane.showMessageDialog(null, "Lo siento, la opcion que elegiste no esta en el menu\nVuelve a elegir", "La opcion no esta en Menu", JOptionPane.ERROR_MESSAGE, null);
                }

            } catch (NumberFormatException e) {
                bien = false;
                JOptionPane.showMessageDialog(null, "Lo siento, las opciones se eligen con numeros!\nVuelve a elegir", "La opcion no esta en Menu", JOptionPane.ERROR_MESSAGE, null);
            }
                
            // OPCIONES DEL MENU
            switch(opcion) {
                
                // Opcion 1
                case 1:

                // tiempo inicio del juego
                tiempoInicioJuego = System.currentTimeMillis();
                JOptionPane.showMessageDialog(null, "Calculos Mentales\n"
                    + "Debes responder correctamente 7 preguntas\n"
                    + "Tu puedes!\n",
                    "Calculos Mentales", JOptionPane.PLAIN_MESSAGE, null);
                    contCorrectas = 0;
                    for (i = 0; i < 7;) {
                        num1      = mates.generarNum(2, 9);
                        num2      = mates.generarNum(2, 9);
                        op        = mates.generarOperador(OPERADORES);

                        // si hay division, que el resultado sea entero
                        if (op == '/') {
                            while (num1 % num2 != 0) {
                                num1 = mates.generarNum(2, 9);
                                num2 = mates.generarNum(2, 9);
                            }
                        }
                        resultado = mates.calcularResultado(num1, num2, op);
                        
                        do {
                            // tiempo de inicio
                            tiempoInicio = System.currentTimeMillis();
                            bien = true;
                            
                            respS = JOptionPane.showInputDialog(null,
                            "Responde lo siguiente\n"
                            + num1 + " " + op + " " + num2 + " = ?\n", 
                            "Calculos Mentales  -  Desafio " + (i+1) + "/7", 
                            JOptionPane.QUESTION_MESSAGE);

                            // si el usuario cancela
                            if (respS == null) {
                                opcion = JOptionPane.showConfirmDialog(null, "Desea Salir del Desafío?", "Adivina si puedes - Salir del Desafío", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
                                if (opcion == JOptionPane.NO_OPTION) {
                                    bien = false;
                                    break;
                                } else {
                                    i = 7;
                                    break;
                                }
                            }

                            try {
                                if (Integer.parseInt(respS) != resultado) {
                                    bien = false;
                                    JOptionPane.showMessageDialog(null, "Lo siento, la respuesta es incorrecta\nVuelve a intentarlo", "Calculos Mentales", JOptionPane.ERROR_MESSAGE, imgs[mates.generarNum(3, 5)]);
                                } else {
                                    // tiempo final
                                    tiempoFinal = System.currentTimeMillis();
                                    // tiempo total
                                    tiempoTotal = tiempoFinal - tiempoInicio;
                                    // tiempo total en minutos
                                    minutos = (tiempoTotal / 1000) / 60;
                                    // tiempo en segundos
                                    segundos = (tiempoTotal / 1000) % 60;

                                    if (minutos != 0) {
                                        tiempoTomado = "Te tomaste un tiempo de: " + minutos + " minutos y " + segundos + " segundos";
                                    } else {
                                        tiempoTomado = "Te tomaste un tiempo de: " + segundos + " segundos";
                                    }
                                    JOptionPane.showMessageDialog(null, "Correcto!\n"
                                    + tiempoTomado, "Calculos Mentales", JOptionPane.INFORMATION_MESSAGE, imgs[mates.generarNum(0, 2)]);
                                    i++;
                                    contCorrectas++;
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El numero ingresado no es valido.\nVuelve a intentarlo", "Incorrecto", JOptionPane.ERROR_MESSAGE, null);
                                bien = false;
                            }
            
                        } while (!bien);
                        
                    }
                    tiempoFinal = System.currentTimeMillis();
                    // tiempo total
                    tiempoTotal = tiempoFinal - tiempoInicioJuego;
                    minutos = (tiempoTotal / 1000) / 60;
                    segundos = (tiempoTotal / 1000) % 60;

                    if (minutos != 0) {
                        tiempoTomado = "Te tomaste un tiempo de: " + minutos + " minutos y " + segundos + " segundos";
                    } else {
                        tiempoTomado = "Te tomaste un tiempo de: " + segundos + " segundos";
                    }
                    if (contCorrectas < 7) {
                        JOptionPane.showMessageDialog(null, "No desanimes!\n"
                        + "No has completado el desafio de Calculos Mentales\n"
                        + "Pero eso no quiere decir que no lo puedas intentar otra vez!\n",
                        "Calculos Mentales", JOptionPane.PLAIN_MESSAGE, imgs[mates.generarNum(3, 5)]);
                    } else {
                        JOptionPane.showMessageDialog(null, "Felicidades!\n"
                        + "Has completado el desafio de Calculos Mentales\n"
                        + tiempoTomado, 
                        "Calculos Mentales", JOptionPane.PLAIN_MESSAGE, imgs[mates.generarNum(0, 2)]);
                    }
                    break;

                // Opcion 2
                case 2:
                    // tiempo de inicio
                    tiempoInicio = System.currentTimeMillis();
                    JOptionPane.showMessageDialog(null, "Instrucciones\n"
                    + "Debes llenar con el numero que falta\n"
                    + "Por ejemplo:\n"
                    + "20 - ? = 15\n"
                    + "La respuesta es 5 porque 20-5=15\n", "Adivina si puedes", JOptionPane.PLAIN_MESSAGE, null);
    
                    // arreglo de trabajo
                    int[] terminos = new int[3];
                    // reiniciamos contador de correctas e incorrectas
                    contCorrectas = 0;
                    contIncorrectas = 0;
                    do {
                        bien = true;
                        // reiniciamos contador de intentos
                        contIntentos = 0;
                        do {
                            // generar los terminos
                            num1 = mates.generarNum(0, 99);
                            num2 = mates.generarNum(0, 99);
                            // generar el operador
                            op = mates.generarOperador(OPERADORES);
                            // si hay division, que el resultado sea entero
                            if (op == '/') {
                                while (num1 % num2 != 0) {
                                    num1 = mates.generarNum(2, 9);
                                    num2 = mates.generarNum(2, 9);
                                }
                            }
                            // generar el resultado
                            resultado = mates.calcularResultado(num1, num2, op);
    
                        } while (resultado > 100);
    
                        // guardar en el arreglo de trabajo los terminos
                        terminos[0] = num1;
                        terminos[1] = num2;
                        terminos[2] = resultado;
    
                        // generar random para el termino a desaparecer
                        random = rand.nextInt(terminos.length);
    
                        // cargar el arreglo a la clase
                        ecuacion.cargarTerminos(num1, num2, resultado);
    
                        // resultado de la ecuacion
                        resultado = terminos[random];
    
                        do {
                            bien = true;
                            // preguntamos si ya tiene 3 incorrectas
                            if (contIntentos == 3) {
                                JOptionPane.showMessageDialog(null, "Chanfles!, ya tienes 3 incorrectas\nPuedes intentar otra vez", "Adivina si puedes", JOptionPane.WARNING_MESSAGE, imgs[mates.generarNum(3, 5)]);
    
                                JOptionPane.showMessageDialog(null, "La respuesta de\n"
                                + problema + "\n"
                                + "Era: " + resultado,
                                "Adivina si puedes!", JOptionPane.INFORMATION_MESSAGE, null);
    
                                contIntentos = 0;
                                contIncorrectas++;
                                break;
                            }
                            // generar ecuacion
                            problema = ecuacion.generarEcuacion(random, op);
                            // tiempo de inicio
                            tiempoInicio = System.currentTimeMillis();

                            respS = JOptionPane.showInputDialog(null,
                            "Responde lo siguiente:\n\n" + problema,
                            "Adivina si puedes!     Intento " + (contIntentos+1) + "/" + "3", JOptionPane.QUESTION_MESSAGE);
                            
                            // si el usuario cancela
                            if (respS == null) {
                                opcion = JOptionPane.showConfirmDialog(null, "Desea Salir del Desafío?", "Adivina si puedes - Salir del Desafío", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
                                if (opcion == JOptionPane.NO_OPTION) {
                                    bien = false;
                                    break;
                                } else {
                                    break;
                                }
                            }
        
                            try {
                                if (Integer.parseInt(respS) != resultado) {
                                    bien = false;
                                    JOptionPane.showMessageDialog(null, "Lo siento, la respuesta es incorrecta\nVuelve a intentarlo", "Adivina si puedes", JOptionPane.ERROR_MESSAGE, imgs[mates.generarNum(3, 5)]);
                                    contIntentos++;
                                } else {
                                    // tiempo final
                                    tiempoFinal = System.currentTimeMillis();
                                    // tiempo total
                                    tiempoTotal = tiempoFinal - tiempoInicio;
                                    minutos  = (tiempoTotal / 1000) / 60;
                                    segundos = (tiempoTotal / 1000) % 60;

                                    if (minutos != 0) {
                                        tiempoTomado = "Te tomaste un tiempo de: " + minutos + " minutos y " + segundos + " segundos";
                                    } else {
                                        tiempoTomado = "Te tomaste un tiempo de: " + segundos + " segundos";
                                    }
                                    JOptionPane.showMessageDialog(null, "Correcto!\n"
                                    + tiempoTomado, "Adivina si puedes", JOptionPane.INFORMATION_MESSAGE, imgs[mates.generarNum(0, 2)]);
                                    contCorrectas++;
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El numero ingresado no es valido.\nVuelve a intentarlo", "Incorrecto", JOptionPane.ERROR_MESSAGE, null);
                                bien = false;
                            }
                        } while (!bien);

                        // tiempo final
                        tiempoFinal = System.currentTimeMillis();
                        // tiempo total
                        tiempoTotal = tiempoFinal - tiempoInicio;
                        // tiempo en minutos
                        minutos = (tiempoTotal / 1000) / 60;
                        // tiempo en segundos
                        segundos = (tiempoTotal / 1000) % 60;

                        continuar = JOptionPane.showConfirmDialog(null, "Te tomaste un tiempo de " + minutos + " minutos y " + segundos + " segundos\n\n"
                        +"¿Deseas realizar otra adivinanza?", "Continuar?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                    } while (continuar == JOptionPane.YES_OPTION);
    
                    JOptionPane.showMessageDialog(null, "Sea cual sea el resultado lo hicistes muy bien\n"
                    + "Obtuviste\n"
                    + "Respuestas Buenas\n"
                    + ": " + contCorrectas +"\n"
                    + "Respuestas Malas\n"
                    + ": " + contIncorrectas + "\n",
                    "Adivina si puedes", JOptionPane.PLAIN_MESSAGE, null);
                    break;

                    // Opcion 3
                    case 3:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida", "Mundo de las Matematicas", JOptionPane.ERROR_MESSAGE, null);
                        break;
                }
            // preguntamos si desea continuar
            // if (opcion != 3) {
            //     opcion = JOptionPane.showConfirmDialog(null, "¿Deseas realizar otro desafio?", "Continuar? - Mundo de las Matematicas", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
            // }

        } while (opcion == JOptionPane.YES_OPTION || opcion != 3);
        JOptionPane.showMessageDialog(null, "Gracias por jugar!\n", "Mundo de las Matematicas", JOptionPane.PLAIN_MESSAGE, null);

    }
}