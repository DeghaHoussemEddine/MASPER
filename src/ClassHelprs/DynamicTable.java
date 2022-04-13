package ClassHelprs;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class DynamicTable {

	private String[] Columns;
	// private ArrayList<String[]> Data_input;
	// TABLE VIEW AND DATA
	private ObservableList<ObservableList> data;
	private TableView tableview;

	// MAIN EXECUTOR

	public TableView getTableView() {
		return tableview;
	}

	public DynamicTable(String[] Columns) {
		this.Columns = Columns;
	//	this.Data_input = Data_input;
		data = FXCollections.observableArrayList();

	}

	// CONNECTION DATABASE
	public void buildData(ArrayList<String[]> Data_input) {
		tableview = new TableView();
		try {
			/**********************************
			 * TABLE COLUMN ADDED DYNAMICALLY *
			 **********************************/
			for (int i = 0; i < Columns.length; i++) {
				// We are using non property style for making dynamic table
				final int j = i;
				TableColumn col = new TableColumn(Columns[i]);
				col.setCellValueFactory(
						new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
							public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
								return new SimpleStringProperty(param.getValue().get(j).toString());
							}
						});
				
				tableview.getColumns().addAll(col);
			}

			/********************************
			 * Data added to ObservableList *
			 ********************************/
		
			for (int j = 0; j < Data_input.size(); j++) {
				// Iterate Row
				ObservableList<String> row = FXCollections.observableArrayList();
				String[] Data = (String[]) Data_input.get(j);
				for (int i = 0; i < Data.length; i++) {

					// Iterate Column
					row.add(Data[i]);
				}

				data.add(row);

			}

			// FINALLY ADDED TO TableView
			tableview.setItems(data);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}