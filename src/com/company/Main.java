package com.company;

public class Main
{

    public static void main(String[] args)
    {
	// write your code here
        System.out.println("Hola Mundo");
        var resultado =  sumar(5,25,48);

        Coche miCoche = new Coche();
        System.out.println("el coche tiene "+miCoche.incrementarPuertas(5)+" puertas");
        System.out.println("La suma es: "+resultado);
    }
public static int  sumar (int n1, int n2,int n3){
    int resultado = n1+n2+n3;
    return resultado;
}
 public static class Coche
    {
        public int cantPuerta=2;
        public int incrementarPuertas(int agregar)
        {
            this.cantPuerta+=agregar;
            return cantPuerta;
        }
    }
}
//- Crear una clase coche.
  //      - Dentro de la clase coche, una variable numérica que almacene el número de puertas que tiene.
    //    - Una función que incremente el número de puertas que tiene el coche.
      //  - Crear un objeto miCoche en el main y añadirle una puerta.
        //- Mostrar el número de puertas que tiene el objeto.
