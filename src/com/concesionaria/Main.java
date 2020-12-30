package com.concesionaria;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.concesionaria.interfaces.Vehiculo;
import com.concesionaria.vehiculos.FabricaVeiculos;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creamos arreglo de vihiculios
		List<Vehiculo> veiculosList=cargarVehiculos();
				
		
		//Convertimos la lista a un TreeSet para ordenar la lista por precio.
		
		SortedSet<Vehiculo> veiculosSorted = cargarSortedSet(veiculosList);
		
		//mostramos el mensaje por consola
		mostrarMsjPorConsola(veiculosSorted, veiculosList );

	}
	
	public static void mostrarMsjPorConsola(SortedSet<Vehiculo> veiculos, List<Vehiculo> veiculosList) {
		veiculosList.stream().map(e-> e).forEach(System.out::println);
		
		mostrarSeparador();
		
		VeiculoMasCaro(veiculos);
		
		veiculoMasBarato(veiculos);
		
		modeloConLetraYMasVeces(veiculosList);
		
		
		mostrarSeparador();
		
		System.out.println("Vehículos ordenados por precio de mayor a menor: ");
		
		veiculos.stream().map(e->e.getMarca()+" "+e.getModelo()).forEach(System.out::println);;

	}
	public static void mostrarSeparador() {
		System.out.println("=============================");
	}
	public static void VeiculoMasCaro(SortedSet<Vehiculo> veiculos) {
		Vehiculo v = veiculos.first();
		System.out.println("Vehículo mas caro: ".concat(v.getMarca()).concat(" ").concat(v.getModelo()));
	}
	
	public static void veiculoMasBarato(SortedSet<Vehiculo> veiculos) {
		Vehiculo v = veiculos.last();
		System.out.println("Vehículo mas barato: ".concat(v.getMarca()).concat(" ").concat(v.getModelo()));
	}
	
	public static void modeloConLetraYMasVeces(List<Vehiculo> veiculos) {
		List<String> veiculosfFiltrados = filtarModelosPorLetraY(veiculos);
		System.out.print("Vehiculo que contiene en el modelo la letra `Y´ : ");
		for (String string : veiculosfFiltrados) {
			System.out.println(string);
		}
		
				
	}
	
	private static List<String> filtarModelosPorLetraY(List<Vehiculo> veiculos) {
		List<String> modelosConLetraY =new ArrayList<>();
		for (Vehiculo v : veiculos) {
			if(v.getModelo().toUpperCase().contains("Y")) {
				modelosConLetraY.add(v.getMarca().concat(" ").concat(v.getModelo()).concat(" ").concat(v.getPrecioFormateado()));
			}
		
		}
		return modelosConLetraY;
	}
	
	public static List<Vehiculo> cargarVehiculos(){
		List<Vehiculo>veiculos = new ArrayList<>();
//para crear el veiculo hay que indicarle el tipo 'moto' u 'auto' debido a que se usa una clase fabrica para crear los objetos
		veiculos.add(FabricaVeiculos.getVeiculo("auto", "Peugeot", "206", 200000.00, 4, null));
		veiculos.add(FabricaVeiculos.getVeiculo("moto","Honda", "Titan", 60000.00, null, "125cc"));
		veiculos.add(FabricaVeiculos.getVeiculo("auto","Peugeot", "208", 250000.00, 5, null));
		veiculos.add(FabricaVeiculos.getVeiculo("moto","Yamaha", "YBR", 80500.50, null, "160cc"));
		return veiculos;
	}

	public static SortedSet<Vehiculo> cargarSortedSet(List<Vehiculo> veiculos){
		Comparator<Vehiculo> byPrecio = Comparator.comparingInt(Vehiculo::getIntPrecio);
		Supplier <TreeSet<Vehiculo>> veiculo = () -> new TreeSet<Vehiculo>(byPrecio);
		SortedSet<Vehiculo> veiculosSet = veiculos.stream().map(e ->e).collect(Collectors.toCollection(veiculo));
		return veiculosSet;
	}
}
