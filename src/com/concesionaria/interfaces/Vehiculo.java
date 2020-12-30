package com.concesionaria.interfaces;

import java.text.DecimalFormat;

public  class Vehiculo   {
	private String marca;
	private String modelo;
	private Double precio;
	
	
	
	public Vehiculo(String marca, String modelo, Double precio){
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}
	public Vehiculo() {
		
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Double getPrecio() {
		return precio;
	}
	
	//Metodo para obtener el valor que se usara para el comparador, se retorna el numero en negativo para ordenar de mayor a menor.
	public Integer getIntPrecio() {
		return -this.precio.intValue();
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public String getPrecioFormateado() {
		DecimalFormat format =new DecimalFormat("00,000.00");
		return format.format(this.precio).toString();
	}
	
}
