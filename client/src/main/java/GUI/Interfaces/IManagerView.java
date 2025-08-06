package GUI.Interfaces;

import javax.swing.table.DefaultTableModel;

public interface IManagerView {

    public void succes();
    public void error();
    public void disposee();

    public void refresh(DefaultTableModel x);

}
