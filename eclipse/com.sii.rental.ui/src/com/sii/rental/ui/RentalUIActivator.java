package com.sii.rental.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class RentalUIActivator extends AbstractUIPlugin {


	// The plug-in ID
	public static final String PLUGIN_ID = "com.sii.rental.ui"; //$NON-NLS-1$

	// The shared instance
	private static RentalUIActivator plugin;
	
	private Map<String, Palette> paletteManager = new HashMap<String, Palette>();

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
		
		readPaletteExtensions();
	}

	private void readPaletteExtensions() {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		for (IConfigurationElement e : reg.getConfigurationElementsFor("com.sii.ui.rental.palette"))
		{
			if("palette".equals(e.getName()))
			{
				Palette currentPalette;
				try 
				{
					currentPalette = new Palette(e.getAttribute("id"), e.getAttribute("name"), (IColorProvider) e.createExecutableExtension("class"));
					paletteManager.put(currentPalette.getId(), currentPalette);
					System.out.println(currentPalette.getName());
				} 
				catch (InvalidRegistryObjectException e1) 
				{
					// TODO Auto-generated catch block
					//getLog()
					e1.printStackTrace();
				} 
				catch (CoreException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}	
	
	private void readViewExtensions() {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		for (IConfigurationElement e : reg.getConfigurationElementsFor("org.eclipse.ui.views"))
		{
			if("view".equals(e.getName()))
			{
				System.out.println("Plugin : " + e.getNamespaceIdentifier() + "\t\tVue : " + e.getAttribute("name") );
			}
		}
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

	public Map<String, Palette> getPaletteManager() {
		return paletteManager;
	}

}
