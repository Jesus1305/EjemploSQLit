package co.quindio.sena.ejemplosqlite.entidades;

import java.io.Serializable;

/**
 * Created by CHENAO on 7/05/2017.
 */

public class Usuario implements  Serializable{

    private Integer id;
    private String nombre;
    private String total;
    private String size;
    private String extra;
    private String comentarios;
    private String cantidad;

    public Usuario(Integer id, String nombre, String size, String extra, String comentarios,String cantidad, String total) {
        this.id = id;
        this.nombre = nombre;
        this.total = total;
        this.cantidad=cantidad;
        this.comentarios=comentarios;
        this.extra=extra;
        this.size=size;
    }

    public Usuario(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
