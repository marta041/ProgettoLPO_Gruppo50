package progettoLPO.visitors.evaluation;

import java.util.Iterator;

import java.util.NoSuchElementException;

public class RangeValue implements Value, Iterable<Integer>{
    private final Integer fstVal;
    private final Integer sndVal;

    public RangeValue(Integer fstVal, Integer sndVal){
        this.fstVal = fstVal;
        this.sndVal = sndVal;
    }

    public Integer getFirst() {
		return fstVal;
	}

	public Integer getLast() {
		return sndVal;
	}
    @Override
    public RangeValue toRange() { return this; }

    @Override
    public String toString() { return "[ " + this.fstVal + " : " + this.sndVal + " ]"; }

   
    @Override
	public final boolean equals(Object obj){
		if(this == obj)
				return true;
		if (!(obj instanceof RangeValue))
	return false;
		var r = (RangeValue)obj;
		return ((fstVal.equals(r.fstVal) && sndVal.equals(r.sndVal)) || (fstVal.equals(sndVal) && r.fstVal.equals(r.sndVal)));

	}

    @Override
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>(){
            
            private Integer first = fstVal;
            private Integer last = sndVal;
            
            public boolean hasNext() {
            	return (first<last || first>last); 
            }

            public Integer next() {
            	if (!hasNext())
            		throw new NoSuchElementException();
            	if(first<last) return first++;
            	return first--;
            }

            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}
