package de.htwg.seapal.common.modules;


import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;


import de.devsurf.injection.guice.annotations.features.MultiBindingFeature;
import de.devsurf.injection.guice.scanner.ClasspathScanner;
import de.devsurf.injection.guice.scanner.PackageFilter;
import de.devsurf.injection.guice.scanner.StartupModule;
import de.devsurf.injection.guice.scanner.features.ScannerFeature;
import de.devsurf.injection.guice.scanner.asm.ASMClasspathScanner;

public class ReflectionModule extends StartupModule {

	public ReflectionModule(Class<? extends ClasspathScanner> scanner, PackageFilter... packages) {
		super(scanner, packages);
		
		disableLogging();
	}
	
	public ReflectionModule(){
		this(ASMClasspathScanner.class, PackageFilter.create("de.htwg.seapal", true));
		
	}
	
	private void disableLogging(){
		final Logger LOGGER = Logger.getLogger(ReflectionModule.class.getName());
		for(Handler h : LOGGER.getParent().getHandlers()){
		    if(h instanceof ConsoleHandler){
		        h.setLevel(Level.OFF);
		    }
		} 
	}

	@Override
	protected Multibinder<ScannerFeature> bindFeatures(Binder binder) {	
		Multibinder<ScannerFeature> listeners = Multibinder.newSetBinder(binder, ScannerFeature.class);
		listeners.addBinding().to(MultiBindingFeature.class);
		return listeners;
	}

}