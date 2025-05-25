package org.example.jface.checkboxviewer;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckboxViewerExample {
    public static void main(String[] args) {
        Shell shell = createShell();

        Composite composite = createRootComposite(shell);

        var viewer = CheckboxTableViewer.newCheckList(composite, SWT.BORDER);
        GridDataFactory.create(GridData.FILL_HORIZONTAL).span(3,1).hint(SWT.DEFAULT, 100).applyTo(viewer.getTable());

        viewer.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                return (String) element;
            }
        });

        viewer.setContentProvider(new ArrayContentProvider());

        viewer.setInput(new ArrayList<>(List.of("test", "otherTest")));
        viewer.setCheckedElements(List.of("test").toArray());

        Button acceptButton = new Button(composite, SWT.PUSH);
        acceptButton.setText("Accept change");
        acceptButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                var checkedElements = Stream.of(viewer.getCheckedElements()).map(Object::toString).collect(Collectors.joining("|"));
                Logger.getAnonymousLogger().info(checkedElements);
            }
        });



        run(shell);
    }

    private static Composite createRootComposite(Shell shell) {
        Composite composite = new Composite(shell, SWT.BORDER);
        GridData gridData = new GridData (GridData.HORIZONTAL_ALIGN_FILL | GridData.FILL_BOTH);
        composite.setLayoutData (gridData);
        GridLayout layout = new GridLayout(3, false);
        layout.marginWidth = 4;
        composite.setLayout (layout);
        return composite;
    }

    private static Shell createShell() {
        Shell shell = new Shell();
        shell.setText("Table Examples");
        shell.setLayout(new GridLayout());
        shell.setSize(300,400);
        return shell;
    }

    private static void run(Shell shell) {
        shell.open();
        var display = shell.getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    private static void createLabelIn(Composite parent, String text) {
        Label label = new Label(parent, SWT.NONE);
        label.setText(text);
    }
}