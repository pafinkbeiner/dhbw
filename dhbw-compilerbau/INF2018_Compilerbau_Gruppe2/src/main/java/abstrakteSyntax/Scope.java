package abstrakteSyntax;

import java.util.HashMap;

public class Scope {
    
    Scope parent;
    HashMap<String, String> variables;

    public Scope(Scope parent){
        this.parent = parent;
        this.variables = new HashMap<>();
    }

    public boolean Contains(String name, String type){
        if(this.variables.containsKey(name)){
            if(this.variables.get(name).equals(type)){
                return true;
            }else{
                return false;
            }
        }else{
            if(this.parent == null) return false;

            return this.parent.Contains(name, type);
        }
    }

    public boolean Contains(String name){
        if(this.variables.containsKey(name)){
            return true;
        }else{
            if(this.parent == null) return false;

            return this.parent.Contains(name);
        }
    }

    public String Get(String name){
        if(this.variables.containsKey(name)){
            return this.variables.get(name);
        }else{
            if(this.parent == null){
                return null;
            }
            return this.parent.Get(name);
        }
    }

    public String GetFromClassContext(String name){
        if(this.parent == null){
            return this.variables.get(name);
        }else{
            return this.parent.GetFromClassContext(name);
        }
    }

    public Scope GetParentScope(){
        if(this.parent == null){
            return this;
        }else{
            return this.parent.GetParentScope();
        }
    }

    public boolean Add(String name, String type){
        if(this.variables.containsKey(name)){
            return false;
        }else{
            this.variables.put(name, type);
            return true;
        }
    }

    public HashMap<String, String> GetAll(){
        if(this.parent == null){
            return this.variables;
        }else{
            HashMap<String, String> hashMapCombined = new HashMap<>();
            hashMapCombined.putAll(this.variables);
            hashMapCombined.putAll(this.parent.GetAll());
            return hashMapCombined;
        }
    }

    public int GetVariablesSize(){
        int count = 0;
        if(this.parent == null){
            count += this.variables.size();
        }else{
            count += this.parent.GetVariablesSize();
        }
        return count;
    }

}