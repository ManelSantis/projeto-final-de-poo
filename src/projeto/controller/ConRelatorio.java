package projeto.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import projeto.model.bo.VendaBO;
import projeto.model.vo.VendaVO;

public class ConRelatorio extends ConMenu implements Initializable {

	@FXML
	private TableView<VendaVO> lista;
	@FXML
	private TableColumn<VendaVO, String> data;
	@FXML
	private TableColumn<VendaVO, Double> valor;
	@FXML
	private TableColumn<VendaVO, String> cliente;
	@FXML
	private TableColumn<VendaVO, Long> id;
	@FXML
	private TableColumn<VendaVO, String> responsavel;

	@FXML
	private Label mensagem;
	@FXML
	private DatePicker fim;
	@FXML
	private DatePicker comeco;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		preenxer();
	}

	public void preenxer() {
		if (lista != null) {
			VendaBO aux = new VendaBO();
			ObservableList<VendaVO> ob = FXCollections.observableArrayList(aux.listar());
			data.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("string"));
			valor.setCellValueFactory(new PropertyValueFactory<VendaVO, Double>("valor"));
			cliente.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("cli"));
			responsavel.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("resp"));
			id.setCellValueFactory(new PropertyValueFactory<VendaVO, Long>("id"));
			lista.setItems(ob);
		}
	}

	public void pesquisar(ActionEvent e) throws Exception {
		if(comeco.getValue() != null) {
			//primeiro estará pegando o valor que vem do DatePicker e o transformando em date
			SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd"); //aqui é para saber o formato da data
			LocalDate value = comeco.getValue(); //pega o que tem dentro do DatePicker
			String a, b; //para mostrar quando terminar o relatorio
			Date data1 = (Date) form.parse(value.getYear() + "-" 
					+ value.getMonthValue() + "-" 
					+ value.getDayOfMonth()); //Coloca dia mes e ano dentro da variavel do tipo date
			a = value.getYear() + "-" 
					+ value.getMonthValue() + "-" 
					+ value.getDayOfMonth();
			Calendar com = Calendar.getInstance();
			com.setTime(data1); //e adiciona dentro da variavel calendar
			Calendar fi = Calendar.getInstance();
			if(fim.getValue() != null) { //se tiver sido selecionado um valor para a data final
				//irá adicionar ele da mesma forma
				value = fim.getValue();
				data1 = (Date) form.parse(value.getYear() + "-" 
						+ value.getMonthValue() + "-" 
						+ value.getDayOfMonth());
				fi.setTime(data1);
				b = value.getYear() + "-" 
						+ value.getMonthValue() + "-" 
						+ value.getDayOfMonth();
			} else {
				//caso não tenha sido selecionado nada
				//na data final, então ela recebe o valor da data inicial
				fi.setTime(data1);
				b = value.getYear() + "-" 
						+ value.getMonthValue() + "-" 
						+ value.getDayOfMonth();
			}
			//e adiciona tudo dentro da lista
			VendaBO aux = new VendaBO();
			ObservableList<VendaVO> ob = FXCollections.observableArrayList(aux.relatorio(com,fi));
			data.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("string"));
			valor.setCellValueFactory(new PropertyValueFactory<VendaVO, Double>("valor"));
			cliente.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("cli"));
			responsavel.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("resp"));
			id.setCellValueFactory(new PropertyValueFactory<VendaVO, Long>("id"));
			lista.setItems(ob);
			mensagem.setTextFill(Color.web("green"));
			if(a.equals(b)) {
				mensagem.setText("Mostrando relatório de compras feitas em " + a);
			} else {
				mensagem.setText("Mostrando relatório de vendas feitas de " + a + " até " + b);
			}
			mensagem.setVisible(true);
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecione pelo menos a data inicial para poder processeguir");
			mensagem.setVisible(true);
		}
	}

}
