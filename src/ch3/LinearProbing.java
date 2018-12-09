package ch3;


public class LinearProbing<Key,Value> {
   Key[] keys;
   Value[] values;
   private int M = 30001;
   private int hash(Key key){
       return (key.hashCode()&0x7fffffff)%M;
   }
   public void put(Key key,Value value){
       int hash = hash(key);
       for(;keys[hash]!=null;hash = (hash+1)%M){
           if(key.equals(keys[hash]))
               break;
       }
       keys[hash] = key;
       values[hash] = value;
   }

   public Value get(Key key){
       int i = hash(key);
       for(;keys[i]!=null;i=(i+1)%M){
           if(key.equals(keys[i])) return values[i];
       }
       return null;
   }
}
