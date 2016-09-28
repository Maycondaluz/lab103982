package br.univel.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

import br.univel.classes.Venda;
import br.univel.ejb.ProcessVenda;

public class VendaWservices {
	@EJB
	ProcessVenda ProcessVendaEJB;

	@WebMethod(operationName = "volume")
	@WebResult(name = "Volume_Pacote")
	public String doGet(@WebParam(name = "Nota") int num) {
		Venda venda = new Venda();
		venda.setVolume(5);

		ArrayList<String> item = new ArrayList<>();
		item.add("1");
		item.add("2");

		venda.setItem(item);
		venda.setVolume(1);




		return "Venda Concluída";
	}

}
