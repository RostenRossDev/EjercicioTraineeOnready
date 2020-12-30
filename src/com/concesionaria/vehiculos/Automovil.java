package com.concesionaria.vehiculos;

import java.text.DecimalFormat;

import com.concesionaria.interfaces.Vehiculo;

public class Automovil extends Vehiculo {

	private Integer puertas;
	
	public Automovil(String marca, String modelo, Double precio, Integer puertas) {
		super(marca, modelo, precio);
		this.puertas=puertas;
	}
	
	public Integer getPuertas() {
		return this.puertas;
	}
	
	public void setPuertas(Integer puertas) {
		this.puertas=puertas;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Marca: ".concat(this.getMarca()).concat(" // Modelo: ")
						.concat(this.getModelo()).concat(" // Puertas: ").concat(this.puertas.toString())
						.concat(" // Precio: $").concat(this.getPrecioFormateado());
	}
	
	
	
}
