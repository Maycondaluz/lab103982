package br.univel.webservices;
import java.sql.Date;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.univel.classes.Entrega;
import br.univel.ejb.ProcessEntrega;





@WebService
public class EntregaWservices {

	@EJB
	ProcessEntrega ProcessEntregaEJB;

	@WebMethod(operationName = "estabelecimento")
	@WebResult(name = "Entrega_establecimento")
	public String doGet(@WebParam(name = "endereco_estabelecimento") String endereco) {

		Entrega entrega = new Entrega();
		entrega.setCliente("Jose");
		entrega.setEstabelecimento("bar do ze");

		ProcessEntregaEJB.processarEntrega(entrega);
		return "Entrega enviada";
	}

}
