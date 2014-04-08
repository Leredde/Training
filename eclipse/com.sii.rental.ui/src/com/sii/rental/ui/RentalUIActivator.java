package com.sii.rental.ui;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class RentalUIActivator extends AbstractUIPlugin {

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		//super.initializeImageRegistry(reg);
		// Eclipse 3 pur
		reg.put(RentalUIConstants.IMG_CUSTOMER, imageDescriptorFromPlugin(PLUGIN_ID, RentalUIConstants.IMG_CUSTOMER));
		reg.put(RentalUIConstants.IMG_OBJECT, imageDescriptorFromPlugin(PLUGIN_ID, RentalUIConstants.IMG_OBJECT));
		reg.put(RentalUIConstants.IMG_RENTAL, imageDescriptorFromPlugin(PLUGIN_ID, RentalUIConstants.IMG_RENTAL));
		
		// Eclipse 4
		/*
		Bundle b = Platform.getBundle(PLUGIN_ID); // do this
		b = FrameworkUtil.getBundle(this.getClass()); // or that
		// And then
		reg.put(RentalUIConstants.IMG_CUSTOMER, ImageDescriptor.createFromURL(... */
	}

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sii.rental.ui"; //$NON-NLS-1$

	// The shared instance
	private static RentalUIActivator plugin;
	
	/**
	 * The constructor
	 */
	public RentalUIActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static RentalUIActivator getDefault() {
		return plugin;
	}

}
