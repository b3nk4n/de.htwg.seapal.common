package de.htwg.seapal.common.plugin;

public interface HookHandler<ReturnType, ArgType> {
	
	public ReturnType execute(ArgType a);

}