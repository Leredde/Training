/**
 * 
 */
package com.sii.rental.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Rental;
import com.sii.rental.core.RentalCoreActivator;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;

/**
 * @author lleredde
 *
 */
public class RentalPropertyView extends ViewPart {

	private Group infoGroup;
	private Label infoLabel;
	private Label customerLabel;
	
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
		infoGroup.setLayout(null);
		
		
		infoLabel = new Label(infoGroup, SWT.NONE);
		infoLabel.setBounds(6, 18, 102, 15);
		
		Label rentToLabel = new Label(infoGroup, SWT.NONE);
		rentToLabel.setBounds(6, 39, 46, 15);
		rentToLabel.setText("is rent to");
		
		customerLabel = new Label(infoGroup, SWT.NONE);
		customerLabel.setBounds(67, 39, 64, 15);
		
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

}
