package com.easytrip.backend.converters;

import java.util.ArrayList;
import java.util.List;

/*Se crea una clase abstracta que funcionará como intermedio para convertir los datos desde Data hacia Entities y viceversa */
/*La clase abstracta converter recibe dos parámetros E y D (Entidad y Data) */
public abstract class Converter<E, D> {

    /*
     * Se crea un método abstrcato que va a manejar la entidad recibiendo la Data
     * como objeto
     */
    public abstract E toEntity(D object);

    /*
     * Se crea un método abstrcato que va a manejar la Data recibiendo la Entidad
     * como objeto
     */
    public abstract D toData(E object);

    /*
     * - - -- -- Se crea un método que traerá la lista de Data y la filtratá para
     * sacar lo que necesitan las entidades
     * public List<E> toEntity(List<D> list){
     * return list.stream()
     * .map(object -> toEntity(object))
     * .collect(Collectors.toList());
     * }
     * 
     * - -- - - -- - Se crea un método que traerá la lista de Entity y la filtratá
     * para sacar lo que necesitan las Data
     * public List<D> toData(List<E> list){
     * return list.stream()
     * .map(object -> toData(object))
     * .collect(Collectors.toList());
     * }
     */
    /*
     * Se crea un método que traerá la lista de Data y la filtratá para sacar lo que
     * necesitan las entidades
     */
    public List<E> toEntity(List<D> list) {
        ArrayList<E> salida = new ArrayList<>();
        for (D object : list) {
            salida.add(toEntity(object));
        }
        return salida;
    }

    /*
     * Se crea un método que traerá la lista de Entity y la filtratá para sacar lo
     * que necesitan las Data
     */
    public List<D> toData(List<E> list) {
        ArrayList<D> salida = new ArrayList<>();
        for (E object : list) {
            salida.add(toData(object));
        }
        return salida;
    }
}
