package com.swing;

import com.model.model_Menu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class listMenu<E extends Object> extends JList<E> {
    private final DefaultListModel model;
    private int selectedIndex = -1;
    
    public listMenu(){
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof model_Menu) {
                        model_Menu menu = (model_Menu) o;
                        if (menu.getType() == model_Menu.MenuType.MENU) {
                            selectedIndex = index;
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
        });
    }
    
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                model_Menu data;
                if (o instanceof model_Menu) {
                    data = (model_Menu) o;
                } else {
                    data = new model_Menu("", o + "", model_Menu.MenuType.EMPTY);
                }
                MenuItem item = new MenuItem(data);
                item.setSelected(selectedIndex == index);
                return item;
            }

        };
    }

    public void addItem(model_Menu data) {
        model.addElement(data);
    }
}
