package application;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.paint.Color;

public class ColorPickerTableCell<T> extends TableCell<T, Color> {
    private final ColorPicker picker;

    public ColorPickerTableCell(TableColumn<T, Color> col) {
        picker = new ColorPicker();

        picker.editableProperty().bind(col.editableProperty());
        picker.disableProperty().bind(col.editableProperty().not());

        picker.setOnHiding(e -> {
            if (isEditing()) {
                this.commitEdit(this.picker.getValue());
            }
        });

        picker.setOnShowing(e -> getTableView().edit(getTableRow().getIndex(), getTableColumn()));
    }

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
