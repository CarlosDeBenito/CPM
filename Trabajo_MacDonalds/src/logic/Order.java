package logic;

import java.util.*;

public class Order {

	private List<Product> orderList = null;

	public List<Product> getOrderList() {
		return orderList;
	}

	public Order() {
		orderList = new ArrayList<Product>();
	}

	public void add(Product item, int units) {
		Product itemInOrder = null;

		for (Product a : orderList) {
			if (a.getCode().equals(item.getCode()))
				itemInOrder = a;
		}

		if (itemInOrder == null) {
			Product itemToOrder = new Product(item);
			itemToOrder.setUnits(units);
			orderList.add(itemToOrder);
		} else {
			int totalUnits = itemInOrder.getUnits() + units;
			itemInOrder.setUnits(totalUnits);
		}
	}

	public void remove(Product item, int units) {
		Product itemInOrder = null;

		for (Product a : orderList) {
			if (a.getCode().equals(item.getCode()))
				itemInOrder = a;
		}

		if (itemInOrder != null) {
			int totalUnits = itemInOrder.getUnits() - units;
			itemInOrder.setUnits(totalUnits);
			if(totalUnits==0)
				orderList.remove(itemInOrder);
		}
	}

	public boolean existeElProducto(Product item) {
		boolean existe = false;
		for (Product a : orderList) {
			if (a.getCode().equals(item.getCode())) {
				existe = true;
				return existe;
			}
		}
		return existe;
	}
	
	public int unidadesDelPedido(Product item) {
		int uds=0;
		for (Product a : orderList) {
			if (a.getCode().equals(item.getCode())) {
				return a.getUnits();
			}
		}
		return uds;
	}

	public float calcTotal() {
		float total = 0.0f;
		for (Product a : orderList) {
			total += a.getPrice() * a.getUnits();
		}
		return total;
	}

	public float calcDescuento() {
		float precioProductos = calcTotal();
		if (precioProductos >= 50)
			return (float) (precioProductos * 0.1);
		else
			return 0;
	}

	public void saveOrder(String fileName) {
		FileUtil.saveToFile(fileName, orderList);
	}

	public void initialize() {
		orderList.clear();
	}

	public String toStringConDescuento() {
		String cadena = "";
		cadena += "TU PEDIDO: \n";
		cadena += "\n";
		for (Product product : orderList) {
			cadena += product + "\n";
			;
		}
		cadena += "\n";
		cadena += "Precio productos: " + calcTotal() + "\n";
		cadena += "Descuentos oferta: " + calcDescuento() + "\n";
		cadena += "Importe total: " + (calcTotal() - calcDescuento()) + "\n";
		return cadena;
	}
	
	@Override
	public String toString() {
		String cadena = "";
		for (Product product : orderList) {
			cadena += product.toString2() + "\n";
			;
		}
		cadena += "\n";
		cadena += "Importe total: " + calcTotal() + "\n";
		return cadena;
	}
}