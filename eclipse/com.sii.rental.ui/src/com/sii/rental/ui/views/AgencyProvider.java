package com.sii.rental.ui.views;

import java.util.Collection;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sii.rental.ui.RentalUIConstants;


public class AgencyProvider extends LabelProvider implements ITreeContentProvider, IColorProvider {

	private class Node {
		String label;
		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		RentalAgency agency;
		
		public Node(String label, RentalAgency rentalAgency)
		{
			this.label = label;
			this.agency = rentalAgency;
		}
		
		public Object[] getChildren() {
			if (label == RentalUIConstants.CUSTOMER_NODE) {
				return agency.getCustomers().toArray();
			} else if (label == RentalUIConstants.RENTAL_NODE) {
				return agency.getRentals().toArray();
			} else if (label == RentalUIConstants.OBJECT_NODE) {
				return agency.getObjectsToRent().toArray();
			} else {
				return null;
			}
		}
	}
	
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		Object[] result = null;
		
		if (inputElement instanceof Collection<?>)
		{
			return ((Collection<?>) inputElement).toArray();
		}
		
		return result;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		if (parentElement instanceof RentalAgency)
		{
			Node[] nodes = {
					new Node(RentalUIConstants.CUSTOMER_NODE, (RentalAgency)parentElement),
					new Node(RentalUIConstants.RENTAL_NODE, (RentalAgency)parentElement),
					new Node(RentalUIConstants.OBJECT_NODE, (RentalAgency)parentElement)
			};
			
			return nodes;
		} else if(parentElement instanceof Node) {			
			return ((Node)parentElement).getChildren();
		
		} else {
			return null;
		}
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return ((element instanceof RentalAgency) || (element instanceof Node));
	}
	
	public String getText(Object element)
	{
		String result = "";
		if (element instanceof RentalAgency)
		{
			result = ((RentalAgency)element).getName();
		} else if (element instanceof Customer) {
			result = ((Customer)element).getFirstName() + " " + ((Customer)element).getLastName();
		} else if (element instanceof Node) {
			result = ((Node)element).getLabel();
		} else if (element instanceof RentalObject) {
			result = ((RentalObject)element).getName();
		} else if (element instanceof Rental) {
			result = ((Rental)element).toString();
		}
			
		
		return result;
	}

	@Override
	public Color getForeground(Object element) {
		// TODO Auto-generated method stub
		if (element instanceof Customer)
		{
			return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GREEN);
		} else if (element instanceof Rental)
		{
		//	return new Color(Display.getCurrent(), 20, 200, 255);
			return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_BLUE);
		} else if (element instanceof RentalObject) {

			return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED);
		}
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

}
