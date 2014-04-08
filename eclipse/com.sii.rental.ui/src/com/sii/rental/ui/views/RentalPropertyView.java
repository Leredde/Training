/**
 * 
 */
package com.sii.rental.ui.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Rental;
import com.sii.rental.core.RentalCoreActivator;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;

/**
 * @author lleredde
 *
 */
public class RentalPropertyView extends ViewPart implements ISelectionListener {

	private Group infoGroup;
	private Label infoLabel;
	private Label customerLabel;
	
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		site.getPage().addSelectionListener(this);
	}
	
	@Override
	public void dispose() {
		getSite().getPage().removeSelectionListener(this);
		super.dispose();
	}
	
	/**
	 * 
	 */
	public RentalPropertyView() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));
		// TODO Auto-generated method stub
		infoGroup = new Group(parent,SWT.NONE);
		infoGroup.setText("Informations");
		infoGroup.setLayout(new GridLayout(2, false));
		
		
		infoLabel = new Label(infoGroup, SWT.NONE);
		new Label(infoGroup, SWT.NONE);
		
		Label rentToLabel = new Label(infoGroup, SWT.NONE);
		rentToLabel.setText("Currently rent to :");
		
		customerLabel = new Label(infoGroup, SWT.NONE);
		
		Group grpDate = new Group(parent, SWT.NONE);
		grpDate.setText("Date");
		
		Rental r = RentalCoreActivator.getAgency().getRentals().get(0);
		setRental(r);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	public void setRental(Rental r) {
		infoLabel.setText(r.getRentedObject().getName());
		customerLabel.setText(r.getCustomer().getDisplayName());
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			Object selected = ((StructuredSelection) selection).getFirstElement();
			
			if (selected instanceof Rental) {
				setRental((Rental)selected);
			}
		}
			
		
		
	}

}
