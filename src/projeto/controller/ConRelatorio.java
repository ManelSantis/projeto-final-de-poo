package projeto.controller;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import projeto.model.bo.NotaFiscalBO;
import projeto.model.vo.VendaVO;

public class ConRelatorio extends ConMenu implements Initializable {
	private static String dataInicio;
	private static String dataFim;
	@FXML
	private TableView<VendaVO> lista;
	@FXML
	private TableColumn<VendaVO, String> data;
	@FXML
	private TableColumn<VendaVO, Double> valor;
	@FXML
	private TableColumn<VendaVO, String> cliente;
	@FXML
	private TableColumn<VendaVO, String> id;
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
			NotaFiscalBO aux = new NotaFiscalBO();
			ObservableList<VendaVO> ob = FXCollections.observableArrayList(aux.listar());
			data.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("string"));
			valor.setCellValueFactory(new PropertyValueFactory<VendaVO, Double>("valor"));
			cliente.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("cli"));
			responsavel.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("resp"));
			id.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("codigo"));
			lista.setItems(ob);
		}
	}

	public void pesquisar(ActionEvent e) throws Exception {
		if(comeco.getValue() != null) {
			//primeiro estará pegando o valor que vem do DatePicker e o transformando em date
			SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd"); //aqui é para saber o formato da data
			LocalDate value = comeco.getValue(); //pega o que tem dentro do DatePicker
			Date data1 = (Date) form.parse(value.getYear() + "-" 
					+ value.getMonthValue() + "-" 
					+ value.getDayOfMonth()); //Coloca dia mes e ano dentro da variavel do tipo date
			setDataInicio(value.getYear() + "-" 
					+ value.getMonthValue() + "-" 
					+ value.getDayOfMonth());
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
			setDataFim(value.getYear() + "-" 
						+ value.getMonthValue() + "-" 
						+ value.getDayOfMonth());
			} else {
				//caso não tenha sido selecionado nada
				//na data final, então ela recebe o valor da data inicial
				fi.setTime(data1);
				setDataFim(value.getYear() + "-" 
						+ value.getMonthValue() + "-" 
						+ value.getDayOfMonth());
			}
			//e adiciona tudo dentro da lista
			NotaFiscalBO aux = new NotaFiscalBO();
			ObservableList<VendaVO> ob = FXCollections.observableArrayList(aux.relatorio(com, fi));
			data.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("string"));
			valor.setCellValueFactory(new PropertyValueFactory<VendaVO, Double>("valor"));
			cliente.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("cli"));
			responsavel.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("resp"));
			id.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("codigo"));
			lista.setItems(ob);
			mensagem.setTextFill(Color.web("green"));
			if(getDataInicio().equals(getDataFim())) {
				mensagem.setText("Mostrando relatório de compras feitas em " + getDataInicio());
			} else {
				mensagem.setText("Mostrando relatório de vendas feitas de " + getDataInicio() + " até " + getDataFim());
			}
			mensagem.setVisible(true);
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecione pelo menos a data inicial para poder processeguir");
			mensagem.setVisible(true);
		}
	}

	public void gerarNota (ActionEvent e) throws Exception {
		VendaVO aux = lista.getSelectionModel().getSelectedItem();
		if (aux != null) {
			File pdf = new File("./Notas/"+aux.getString()+" - "+aux.getCodigo()+".pdf");
			Desktop.getDesktop().open(pdf);
		} else {
			mensagem.setTextFill(Color.web("red"));
			mensagem.setText("Por favor, selecione uma linha para ver a nota fiscal");
			mensagem.setVisible(true);
		}
	}

	public static String getDataInicio() {
		return dataInicio;
	}

	public static void setDataInicio(String dataInicio) {
		ConRelatorio.dataInicio = dataInicio;
	}

	public static String getDataFim() {
		return dataFim;
	}

	public static void setDataFim(String dataFim) {
		ConRelatorio.dataFim = dataFim;
	}
}
