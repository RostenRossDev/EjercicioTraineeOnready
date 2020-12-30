package com.concesionaria.vehiculos;

import com.concesionaria.interfaces.Vehiculo;

public class FabricaVeiculos {

	public static Vehiculo getVeiculo(String tipo, String marca, String modelo, Double precio, Integer puertas, String cilindrada) {		
		if(tipo.equals("auto")) {
			Vehiculo auto= new Automovil(marca, modelo, precio, puertas);
			return auto;
		}else {
			Vehiculo moto= new Motocicleta(marca, modelo, precio, cilindrada);
			return moto;
		}
	}
}
