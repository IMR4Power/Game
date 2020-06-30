package application.ui.newGameDialog.colorPickerTableCell;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.paint.Color;

/**
 * @param <T> Type of structure handled by the TableView
 * @author Kevin
 * @see javafx.scene.control.TableView
 */
public class ColorPickerTableCell<T> extends TableCell<T, Color> {
    private final ColorPicker picker;

    public ColorPickerTableCell(TableColumn<T, Color> col) {
        picker = new ColorPicker();

        // Make the color picker editable when the column is
        picker.editableProperty().bind(col.editableProperty());
        picker.disableProperty().bind(col.editableProperty().not());

        // When the color picker choice dialog closes, update the data
        picker.setOnHiding(e -> {
            if (isEditing()) {
                this.commitEdit(this.picker.getValue());
            }
        });

        // When user opens the color picker, mark the cell as beeing edited
        picker.setOnShowing(e -> getTableView().edit(getTableRow().getIndex(), getTableColumn()));
    }

    /**
     * Update the color picker's value to make him show the new selected color
     *
     * @param item  The new color
     * @param empty Tells if cell is empty
     */
    @Override
    protected void updateItem(Color item, boolean empty) {
        super.updateItem(item, empty);

        setText(null);

        if (empty)
            setGraphic(null);
        else {
            picker.setValue(item);
            setGraphic(picker);
        }
    }
}
