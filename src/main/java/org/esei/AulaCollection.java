package org.esei;

import java.util.*;

public class AulaCollection implements Collection<Aula>{
    List<Aula> aulas;


    public AulaCollection(){
        this.aulas = new ArrayList<Aula>();    
    }

    public Aula getById(String Id){
        boolean ctrl = false;
        Iterator<Aula> itr = aulas.iterator();
        Aula aula = null;
        while(!ctrl && itr.hasNext()){
            aula = itr.next();
            ctrl = aula.getId().equals(Id);                   
        }
        if(!ctrl){
            aula = null;
        }
        return aula;
    }

    @Override
    public Iterator<Aula> iterator() {
        return aulas.iterator();
    }



    @Override
    public boolean add(Aula e) {
        if (this.contains(e)){
            return false;
        }else{
            aulas.add(e);
            return true;
        }
    }



    @Override
    public boolean addAll(Collection<? extends Aula> c) {
        Iterator<? extends Aula> itr = c.iterator();
        boolean ctrl = true;
        while (itr.hasNext()){
            if (!aulas.add(itr.next())){
                ctrl = false; 
            }
        }
        return ctrl;
    }



    @Override
    public void clear() {
        this.aulas.clear();
        
    }



    @Override
    public boolean contains(Object o) {
        if(aulas.contains(o)){
            return true;
        }else{
            if("Aula".equals(o.getClass().getSimpleName())){
                Aula a = (Aula)o;
                boolean ctrl = false;
                Iterator<Aula> itr = aulas.iterator();
                while(!ctrl && itr.hasNext()){
                    ctrl = itr.next().getId().equals(a.getId());
                }
                return ctrl;
            }else{ 
                return false;
            }
        }
    }



    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> itr = c.iterator();
        boolean ctrl = false;
        while(!ctrl && itr.hasNext()){
            ctrl = aulas.contains(itr.next());
        }
        return ctrl;
    }



    @Override
    public boolean isEmpty() {
        return aulas.isEmpty();
    }



    @Override
    public boolean remove(Object o) {
        if(aulas.remove(o)){
            return true;
        }else{
            if("Aula".equals(o.getClass().getSimpleName())){
                Aula a = (Aula)o;
                boolean ctrl = false;
                Iterator<Aula> itr = aulas.iterator();
                Aula x = null;
                while(!ctrl && itr.hasNext()){
                    x = itr.next();
                    ctrl = x.getId().equals(a.getId());                   
                }
                return aulas.remove(x);
            }else{ 
                return false;
            }
        }
    }



    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> itr = c.iterator();
        boolean ctrl = true;
        while(itr.hasNext()){
            ctrl = ctrl & aulas.remove(itr.next());
        }
        return ctrl;
    }



    @Override
    public boolean retainAll(Collection<?> c) {
        return aulas.retainAll(c);
    }



    @Override
    public int size() {
        return aulas.size();
    }



    @Override
    public Object[] toArray() {
        return aulas.toArray();
    }



    @Override
    public <T> T[] toArray(T[] a) {
        return aulas.toArray(a);
    }

    

}
