package com.sii.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.sii.rental.core.RentalCoreActivator;

public class AgencyView extends ViewPart {

	AgencyProvider provider;
	TreeViewer treeViewer;
	
	public AgencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		Collection<RentalAgency> agencies = new ArrayList<RentalAgency>();
		treeViewer = new TreeViewer(parent);
		provider = new AgencyProvider();
		agencies.add(RentalCoreActivator.getAgency());
		treeViewer.setContentProvider(provider);
		treeViewer.setLabelProvider(provider);
		treeViewer.setInput(agencies);
	
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
