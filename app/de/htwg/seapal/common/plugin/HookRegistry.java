package de.htwg.seapal.common.plugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

import com.google.inject.Singleton;

@Singleton
public class HookRegistry {
	Map<String, Set<HookHandler<?,?>>> hooks;
	
	public HookRegistry(){
		hooks = new HashMap<String, Set<HookHandler<?,?>>>();
	}
	
	public HookRegistry(HashMap<String, Set<HookHandler<?,?>>> hooks){
		this.hooks = hooks;
	}
	
	public void registerHook(String hookName, HookHandler<?,?> handler){
		if(!hooks.containsKey(hookName)){
			hooks.put(hookName, new HashSet<HookHandler<?,?>>());
		}
		
		hooks.get(hookName).add(handler);
	}
	
	@SuppressWarnings("unchecked")
	public <ReturnType, ArgType> Set<HookHandler<ReturnType, ArgType>> getHooks(String hookName, Class<ReturnType> ret, Class<ArgType> arg){
		Set<HookHandler<ReturnType, ArgType>> hooksReturn = new HashSet<HookHandler<ReturnType,ArgType>>();
		
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
