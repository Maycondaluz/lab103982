package br.univel.webservices;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.univel.classes.Produto;
import br.univel.ejb.ProcessProduto;

public class ProdutoWservices {
	@WebService
	public class ProdutoWBS {

		@EJB
		ProcessProduto ProcessProdutoEJB;

		@WebMethod(operationName = "Cadastrar_Produto")
		@WebResult(name = "Status_Cad_Produto")
		public String criar(@WebParam(name = "Cod_barra") String cod_barra, @WebParam(name = "Descricao") String desc,
				@WebParam(name = "Preco") BigDecimal preco) {

			Produto p = new Produto();
			p.setCod_barra(cod_barra);
			p.setDesc(desc);
			p.setPreco(preco);

			return ProcessProdutoEJB.criar(p);
		}

		@WebMethod(operationName = "Ler_Produto")
		@WebResult(name = "Produto")
		public String ler(@WebParam(name = "IdProduto") Long idProd) {
			return ProcessProdutoEJB.ler(idProd);
		}

		@WebMethod(operationName = "Atualizar_Produto")
		@WebResult(name = "Produto_Atualizado")
		public String atualizar(@WebParam(name = "IdProduto") Long idProd,
				@WebParam(name = "Cod_barra") String cod_barra, @WebParam(name = "Descricao") String desc,
				@WebParam(name = "Preco") BigDecimal preco) {

			Produto p = new Produto();
			p.setId(idProd);
			p.setCod_barra(cod_barra);
			p.setDesc(desc);
			p.setPreco(preco);
			return ProcessProdutoEJB.atualizar(p);
		}

		@WebMethod(operationName = "Excluir_Produto")
		@WebResult(name = "Status_Produto")
		public String excluir(@WebParam(name = "IdProduto") Long idProd) {
			return ProcessProdutoEJB.excluir(idProd);
		}

	}
}
