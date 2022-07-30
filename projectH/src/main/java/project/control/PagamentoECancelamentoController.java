package project.control;

import project.model.Cancelamento;
import project.model.Pagamento;

public class PagamentoECancelamentoController {

	
	public Pagamento getNewPagamento() {
		return new Pagamento();
	}
	
	public Cancelamento getNewCancelamento() {
		return new Cancelamento();
	}
}
