package de.htwg.seapal.common.plugin;

public abstract class HookHandler<ReturnType, ArgType> {
	
	private final Class<ReturnType> retType;
	private final Class<ArgType> argType;
	
	public HookHandler(Class<ReturnType> retType, Class<ArgType> argType){
		this.retType = retType;
		this.argType = argType;
	}
	
	abstract public ReturnType execute(ArgType a);
	
	public Class<ReturnType> getReturnType(){
		return retType;
	}
	
	public Class<ArgType> getArgType(){
		return argType;
	}

}