package GUI;


import org.junit.jupiter.api.Test;

import javax.swing.table.DefaultTableModel;

import static org.junit.jupiter.api.Assertions.*;

class ManagerViewTest {

    @Test
    void refresh() {
        var X =new ManagerView();
        DefaultTableModel dtm=new DefaultTableModel();
        dtm.addColumn("da");
        dtm.addRow(new String[]{"D"});
        assertDoesNotThrow(()->{X.refresh(dtm);});
    }
}