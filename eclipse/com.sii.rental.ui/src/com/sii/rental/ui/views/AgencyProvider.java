package com.sii.rental.ui.views;

import java.util.Collection;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.RentalAgency;


public class AgencyProvider extends LabelProvider implements ITreeContentProvider {

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
			return ((RentalAgency) parentElement).getCustomers().toArray();
		}
		else
		{
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
		// TODO Auto-generated method stub
		return true;// fleches pour rien
	}
	
	public String getText(Object element)
	{
		String result = "";
		if (element instanceof RentalAgency)
		{
			result = ((RentalAgency)element).getName();
		} else if (element instanceof Customer) {
			result = ((Customer)element).getFirstName() + " " + ((Customer)element).getLastName();
		}
			
		
		return result;
	}

}
