package projeto.controller;

import javafx.scene.input.MouseEvent;
import projeto.view.Telas;

public class ConVender extends ConMenu{

	public void inicio (MouseEvent e) throws Exception{
			Telas.telaInicio();
		}
	public void Avançar  (MouseEvent e) throws Exception{
		Telas.telaVendaCliente();
	}
	public void OK  (MouseEvent e) throws Exception{
		Telas.telaVendaCliente();
	}
	public void tabela  (MouseEvent e) throws Exception{
		Telas.telaVendaCliente();
	}
} 

