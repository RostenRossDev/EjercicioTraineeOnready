package com.concesionaria.vehiculos;

import java.text.DecimalFormat;

import com.concesionaria.interfaces.Vehiculo;

public class Motocicleta extends Vehiculo{


	private String cilindrada;
	
	public Motocicleta(String marca,  String modelo, Double precio, String cilindrada) {
		// TODO Auto-generated constructor stub

		super(marca, modelo, precio);
		this.cilindrada=cilindrada;
	}
	
	
	public Motocicleta() {}
	
	 public String getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Marca: ".concat(this.getMarca()).concat(" // Modelo: ")
						.concat(this.getModelo()).concat(" // Cilindrada: ").concat(this.cilindrada.toString())
						.concat(" // Precio: $").concat(this.getPrecioFormateado());
	}
	
}
