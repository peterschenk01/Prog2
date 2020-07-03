package array2d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IterableArray2D implements Iterable<Double>{

	private double[][] a2d;
	
	public IterableArray2D(double[][] a2d) {
		if(a2d == null)
			throw new IllegalArgumentException();
		for(int i = 0; i < a2d.length; i++) {
			if(a2d[i] == null || a2d[i].length == 0)
				throw new IllegalArgumentException();
		}
		
		this.a2d = a2d;
	}
	
	@Override
	public Iterator<Double> iterator(){
		return new Array2DIterator();
	}
	
	private class Array2DIterator implements Iterator<Double>{
		private int nextIndex;
		
		private Array2DIterator() {
			this.nextIndex = 0;
		}
		
		@Override
		public boolean hasNext() {
			int sum = 0;
			for(double[] row : IterableArray2D.this.a2d) {
				for(double column : row)
					sum++;
			}
				
			return nextIndex < sum;
		}
		
		@Override
		public Double next(){
			if(!hasNext())
				throw new NoSuchElementException();
			
			List<Double> list = new ArrayList<Double>();
			
			for(double[] row : IterableArray2D.this.a2d) {
				for(double column : row)
					list.add(column);
			}
			
			return list.get(nextIndex++);
		}
	}
}
