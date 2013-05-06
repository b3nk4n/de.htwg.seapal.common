package de.htwg.seapal.common.plugin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.inject.Singleton;

@Singleton
public class HookRegistry {
	Map<String, List<HookHandler<?,?>>> hooks;
	
	public HookRegistry(){
		hooks = new HashMap<String, List<HookHandler<?,?>>>();
	}
	
	public HookRegistry(HashMap<String, List<HookHandler<?,?>>> hooks){
		this.hooks = hooks;
	}
	
	public void registerHook(String hookName, HookHandler<?,?> handler){
		if(!hooks.containsKey(hookName)){
			hooks.put(hookName, new LinkedList<HookHandler<?,?>>());
		}
		
		hooks.get(hookName).add(handler);
	}
	
	public <ReturnType, ArgType> List<HookHandler<ReturnType, ArgType>> getHooks(String hookName, Class<ReturnType> ret, Class<ArgType> arg){
		List<HookHandler<ReturnType, ArgType>> hooksReturn = new LinkedList<HookHandler<ReturnType,ArgType>>();
		
		if(hooks.containsKey(hookName)){
			for(HookHandler<?,?> hook : hooks.get(hookName)){
				if(ret.isAssignableFrom(hook.getReturnType()) && arg.isAssignableFrom(hook.getArgType())){
					hooksReturn.add((HookHandler<ReturnType, ArgType>) hook);
				}
			}
		}

		return hooksReturn;
	}
}
